package com.balanceador.cliente;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.xml.ws.BindingProvider;

import com.balanceador.db.DB;
import com.balanceador.monitor.CPUmon;
import com.balanceador.monitor.Proceso;

public class Cliente {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws SQLException, RemoteException {

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

	    Iterator itProcesos = nombresProcesos.iterator();
	    
	    i = 0;
        for (i = 0; i < listaIPs.size(); i++)
        {
		    while (itProcesos.hasNext())
		    {
			    	boolean ejecutado = false;
			    	Proceso p = (Proceso) itProcesos.next();
			    	CPUmon cpu;

			    	cpu = (CPUmon)proxyServidores[i];
			    	System.out.println("Procesando en servidor : " + p.getDescripcion() + cpu.toString());
			    	ArrayList lista = new ArrayList();
			    	lista.add(p.getDescripcion());
			    	lista.add(Integer.toString(p.getPrioridad()));
			    	cpu.ejecutarProceso(lista);
	        }
		    itProcesos = nombresProcesos.iterator();
	      }
	    
	  }
	
	private static Collection parseStringCollection(String args[]){
		Collection col = new ArrayList();
		
		try{
			Proceso p;
			for(int i=0;i<200;i++){
				p=new Proceso();
				String proceso=args[i];
				p.setDescripcion(proceso);
				i++;
				String prioridad = args[i];
				p.setPrioridad(Integer.parseInt(prioridad));
				col.add(p);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		return col;	
	}
	

}
