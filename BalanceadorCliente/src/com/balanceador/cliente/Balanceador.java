package com.balanceador.cliente;

import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;

import javax.xml.ws.BindingProvider;

import com.balanceador.db.DB;
import com.balanceador.monitor.CPUmon;
import com.balanceador.monitor.Datos;
import com.balanceador.monitor.Proceso;

public class Balanceador {

	public static void main(String args[]) throws SQLException, RemoteException, InterruptedException, UnknownHostException{
		long tiempoInicio;
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
				      "http://"+itServidores.next()+":8080/BalanceadorServidor/Balanceador");
			proxyServidores[i]=cpu;
			i++;
		}
		Set listaProcesos = db.obtenerListaProcesos(nombresProcesos);
	    Iterator itProcesos = listaProcesos.iterator();
	    
	    i = 0;
	    
	    while (itProcesos.hasNext())
	    {
	    	boolean ejecutado = false;
	    	int tiempoEstimado1erServidor = 0;
	    	Proceso p = (Proceso) itProcesos.next();
	    	CPUmon cpu;
	        for (i = 0; i < listaIPs.size(); i++)
	        {
	        	if(ejecutado==true){
	        		if(itProcesos.hasNext()){
	        			p = (Proceso) itProcesos.next();
	        		}
	        	}else if(i==1 && ejecutado==false){
	        		tiempoEstimado1erServidor = p.getTiempoEstimado();
	        	}
	            cpu = (CPUmon)proxyServidores[i];
	            Datos datos = cpu.obtenerProcesamientoMemoriaOcioso();
	            p = cpu.obtenerProceso(p.getDescripcion());
	            BigDecimal procesamientoRestante = datos.getProcesamientoOcioso().subtract(new BigDecimal(p.getUsoCpu()));
	            if (procesamientoRestante.intValue() >= 0)
	            {
	            	System.out.println("Procesando en servidor : " + p.getDescripcion() + cpu.toString());
		            ArrayList lista = new ArrayList();
		            lista.add(p.getDescripcion());
		            lista.add(Integer.toString(p.getPrioridad()));
		            cpu.ejecutarProceso(lista);
		            datos.setProcesamientoOcioso(procesamientoRestante);
		            ejecutado = true;
	            }
	            if(i==2 && ejecutado==false){
	            	System.out.println("Ninguno tiene capacidad para procesar. Se espera para su resolución.");
	  	          	Thread.sleep(tiempoEstimado1erServidor);
	  	          	i=-1;
	            }
	        }
	      }
	    
	    Calendar ca2 = new GregorianCalendar();
	    long tiempoFin = ca2.getTimeInMillis();
	    fecha.setTime(tiempoFin);
	    long diff = tiempoFin - tiempoInicio;
	    System.out.println("Tiempo insumido en balancear: " + diff + " ms");
	    
	  }
	
	private boolean esComprobableElServidor(){
		
		
		return false;
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
