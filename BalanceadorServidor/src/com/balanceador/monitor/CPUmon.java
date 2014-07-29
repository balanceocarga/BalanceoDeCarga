package com.balanceador.monitor;
/*Joseph Fabisevich
 *Michael Knower
 */

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.hyperic.sigar.SigarException;

import com.balanceador.db.DB;
import com.balanceador.dto.Datos;
import com.balanceador.servidor.DatosServidor;
import com.vladium.utils.CPUUsageThread;
import com.vladium.utils.SystemInformation;

// ----------------------------------------------------------------------------
/**
 * A demo of {@link SystemInformation} and {@link CPUUsageThread} functionality.
 * This class starts an instance of CPU usage monitoring thread, registers itself
 * as a CPU usage event listener, and launches another application.
 * Usage:
 * <PRE>
 *   java -Djava.library.path=(silib native lib dir) CPUmon AnotherApp ...args...
 * </PRE>
 *
 * @author (C) 2002, Vladimir Roubtsov
 */
@WebService(serviceName="balanceador",
portName="balanceadorPort")
public class CPUmon implements CPUUsageThread.IUsageEventListener
{
    // public: ................................................................
    static Collection listaMediciones = new ArrayList();
      
    public CPUmon ()
    {
        m_PID = SystemInformation.getProcessID ();
        
        m_format = new DecimalFormat ();
        m_format.setMaximumFractionDigits (1);
    }
    
    /**
     * Implements {@link CPUUsageThread.IUsageEventListener}. Simply
     * prints the current process PID and CPU usage since last snapshot
     * to System.out.
     */
    public void accept (final SystemInformation.CPUUsageSnapshot event)
    {
        if (m_prevSnapshot != null)
        {
        	String porcentaje = m_format.format (100.0 * SystemInformation.getProcessCPUUsage (m_prevSnapshot, event));
            //System.out.println ("[PID: " + m_PID + "] CPU usage: " + porcentaje + "%");
            listaMediciones.add(porcentaje);
        }
       
        m_prevSnapshot = event;
    }

    // protected: .............................................................

    // package: ...............................................................

    // private: ...............................................................
    
    
    private final int m_PID; // process ID
    private final DecimalFormat m_format;
    private SystemInformation.CPUUsageSnapshot m_prevSnapshot;

	

    private static BigDecimal round(BigDecimal d, int scale, boolean roundUp) {
      int mode = (roundUp) ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
      return d.setScale(scale, mode);
    }

	@WebMethod(operationName="obtenerProcesamientoMemoriaOcioso")
	public Datos obtenerProcesamientoMemoriaOcioso()
			throws RemoteException {
		Datos d = new Datos();
		DatosServidor datos = new DatosServidor();
		try {
			d.setMemoriaOciosa(datos.getMemoriaOciosa());
			d.setProcesamientoOcioso(datos.getProcesamientoOcioso());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	@WebMethod(operationName="ejecutarProceso")
	@Oneway
	public void ejecutarProceso(String[] args){
		Runtime.getRuntime().gc();
		Runtime.getRuntime().gc();
		DatosServidor datos = new DatosServidor();
		try{
    	BigDecimal memoriaInicio=datos.getMemoriaTotal().subtract(datos.getMemoriaOciosa());
        final CPUUsageThread monitor = CPUUsageThread.getCPUThreadUsageThread ();
        final CPUmon _this = new CPUmon ();      
        final Class app = Class.forName (args[0]);
        final Method appmain = app.getMethod ("main", new Class [] {String[].class});
        double cantidad=0d;
        long tiempoInicio;
        long tiempoFin;
        long diff; 
		
        monitor.addUsageEventListener (_this);
        
        
        Calendar ca = new GregorianCalendar();
        tiempoInicio=ca.getTimeInMillis();
    	Date fecha = new Date();
    	fecha.setTime(tiempoInicio);
    	
        appmain.invoke (null, new Object [] {new String [0]});
        
        Calendar ca2 = new GregorianCalendar();
        tiempoFin=ca2.getTimeInMillis();
    	fecha.setTime(tiempoFin);
    	diff=tiempoFin-tiempoInicio;
    	System.out.println("Fin del procesamiento de: " +  args[0] + " Tiempo insumido: "+ diff +" ms");
    	monitor.removeUsageEventListener(_this);
    	
    	Iterator it = listaMediciones.iterator();
    	BigDecimal porcentajePromediado = new BigDecimal(0);
    	while(it.hasNext()){
    		String numeroConPunto=(String)it.next();
    		numeroConPunto=numeroConPunto.replace(',', '.');
    		BigDecimal porcentaje = new BigDecimal(numeroConPunto);
    		porcentajePromediado=porcentajePromediado.add(porcentaje);
    		cantidad++;
    	}
    	porcentajePromediado=porcentajePromediado.divide(BigDecimal.valueOf(cantidad),RoundingMode.HALF_UP);
    	System.out.println("El promedio de consumo es: "+ porcentajePromediado);

        BigDecimal memoriaFin=datos.getMemoriaTotal().subtract(datos.getMemoriaOciosa());
        BigDecimal memoriaUsada= memoriaFin.subtract(memoriaInicio);
        BigDecimal memoriaUsadaKb= memoriaUsada.divide(new BigDecimal(1024),RoundingMode.HALF_UP);
        BigDecimal memoriaUsadaMb= memoriaUsadaKb.divide(new BigDecimal(1024),RoundingMode.HALF_UP);
        memoriaUsadaMb= round(memoriaUsadaMb, 2, true);
        System.out.println("La memoria usada es: "+memoriaUsadaMb );
        
    	DB db = new DB();
    	Proceso proceso= db.obtenerProceso(args[0]);
    	if(proceso==null){
    		proceso = new Proceso();
    		proceso.setDescripcion(args[0]);
    		proceso.setPrioridad(Integer.parseInt(args[1]));
    		proceso.setTiempoEstimado(Long.valueOf(diff).intValue());
    		proceso.setUsoCpu(porcentajePromediado.toString());
    		proceso.setUsoMemoria(memoriaUsadaMb.toString());
    		
    		db.insertarProceso(proceso);
    	}else{
    		proceso.setPrioridad(Integer.parseInt(args[1]));
    		int tiempoEstimado=proceso.getTiempoEstimado();
    		BigDecimal usoCpu = new BigDecimal(proceso.getUsoCpu());
    		BigDecimal usoMemoria = new BigDecimal(proceso.getUsoMemoria());
    		tiempoEstimado= (tiempoEstimado+Long.valueOf(diff).intValue())/2;
    		usoCpu= usoCpu.add(porcentajePromediado);
    		usoCpu= usoCpu.divide(new BigDecimal(2),RoundingMode.HALF_UP);
    		usoMemoria= usoMemoria.add(memoriaUsadaMb);
    		usoMemoria= usoMemoria.divide(new BigDecimal(2),RoundingMode.HALF_UP);
    		proceso.setTiempoEstimado(tiempoEstimado);
    		proceso.setUsoCpu(usoCpu.toString());
    		proceso.setUsoMemoria(usoMemoria.toString());
    		db.actualizarProceso(proceso);
    	}     
      
    	db.cerrarConexion();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@WebMethod(operationName="obtenerProceso")
	public Proceso obtenerProceso(String descripcion) {
		DB db;
		Proceso proceso = null;
		try {
			db = new DB();
			proceso= db.obtenerProceso(descripcion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proceso;
	}
}