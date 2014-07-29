package com.balanceador.monitor;
/*Joseph Fabisevich
 *Michael Knower
 */

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.balanceador.servicio.EstadoServidor;
import com.balanceador.servicio.EstadoServidores;
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
    	
    	EstadoServidor estado = new EstadoServidor();
    	EstadoServidores servicio = estado.getEstadoServidorPort();
    	InetAddress ip=InetAddress.getLocalHost();
    	servicio.actulizarEstadoServidor(ip.getHostAddress());
    	System.out.println(ip.getHostAddress());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}