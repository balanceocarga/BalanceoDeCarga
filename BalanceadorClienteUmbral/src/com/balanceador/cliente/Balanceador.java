package com.balanceador.cliente;

import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.xml.ws.BindingProvider;

import com.balanceador.db.DB;
import com.balanceador.monitor.CPUmon;
import com.balanceador.monitor.Datos;

public class Balanceador {

	public static void main(String args[]) throws SQLException, RemoteException, InterruptedException, UnknownHostException{
		long tiempoInicio;
	    long tiempoFin;
	    long diff;
		Calendar ca = new GregorianCalendar();
        tiempoInicio=ca.getTimeInMillis();
    	Date fecha = new Date();
    	fecha.setTime(tiempoInicio);
    	
		Collection nombresProcesos = parseStringCollection(args);
		if(nombresProcesos.isEmpty()){
			System.out.println("No hay procesos a ejecutar");
			System.exit(0);
		}
		DB db = new DB();
		
		Collection listaIPs = db.consultarServidores();
		
		Iterator itServidores = listaIPs.iterator();
		Object proxyServidores[] = new Object[listaIPs.size()];
		int i = 0;
		com.balanceador.monitor.Balanceador balanceador = new com.balanceador.monitor.Balanceador();
		
		while(itServidores.hasNext()){
			CPUmon cpu = balanceador.getBalanceadorPort();
			BindingProvider bindingProvider = (BindingProvider) cpu;
			bindingProvider.getRequestContext().put(
				      BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				      "http://"+itServidores.next()+":8080/BalanceadorServidorUmbral/BalanceadorUmbral");
			proxyServidores[i]=cpu;
			i++;
		}

		Iterator itProcesos = nombresProcesos.iterator();
		
	    i = 0;
	    
	    while (itProcesos.hasNext())
	    {
	    	boolean ejecutado = false;
	    	String p = (String) itProcesos.next();
	        for (i = 0; i < listaIPs.size(); i++)
	        {
	        	if(ejecutado==true){
	        		if(itProcesos.hasNext()){
	        			p = (String) itProcesos.next();
	        		}else{
	        			break;
	        		}
	        	}
	            CPUmon cpu = (CPUmon)proxyServidores[i];
	            Datos datos = cpu.obtenerProcesamientoMemoriaOcioso();
	            if (datos.getProcesamientoOcioso().intValue() >= 90)
	            {
	            	System.out.println("Procesando en servidor : " + p +" "+ cpu.toString());
		            ArrayList lista = new ArrayList();
		            lista.add(p);
		            cpu.ejecutarProceso(lista);
		            ejecutado = true;
	            }
	            if(i==2 && ejecutado==false){
	            	System.out.println("Ninguno tiene capacidad para procesar. Se espera para su resolución.");
	  	          	Thread.sleep(500);
	  	          	i=-1;
	            }
	        }
	      }

		Calendar ca2 = new GregorianCalendar();
        tiempoFin=ca2.getTimeInMillis();
    	fecha.setTime(tiempoFin);
    	diff=tiempoFin-tiempoInicio;
    	System.out.println("Tiempo insumido en balancear: "+ diff +" ms");
    	
	}
	
	private static Collection parseStringCollection(String args[]){
		Collection col = new ArrayList();
		
		try{
			for(int i=0;i<20;i++){
				String proceso=args[i];
				col.add(proceso);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		return col;	
	}
}
