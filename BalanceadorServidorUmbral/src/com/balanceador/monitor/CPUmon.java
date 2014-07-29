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
public class CPUmon 
{
	
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
		
		try{
    	
        final Class app = Class.forName (args[0]);
        final Method appmain = app.getMethod ("main", new Class [] {String[].class});
        long tiempoInicio;
        long tiempoFin;
        long diff; 
		   
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
    	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}