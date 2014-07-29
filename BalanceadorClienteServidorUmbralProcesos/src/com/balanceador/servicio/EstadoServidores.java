package com.balanceador.servicio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="estadoServidor",
portName="estadoServidorPort")
public class EstadoServidores {
	
	@WebMethod(operationName="actulizarEstadoServidor")
	@Oneway
	public void actulizarEstadoServidor(String ip){
		Properties prop = new Properties();
        String propFileName = "c:/estadoServidores.properties"; 
        InputStream inputStream = null;
		try {
			inputStream = new FileInputStream( propFileName );
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
        try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
        int cantProcesos= Integer.valueOf(prop.getProperty(ip));
        cantProcesos=cantProcesos-1;
        prop.setProperty(ip,String.valueOf(cantProcesos));
        try {
			OutputStream outputStream = new FileOutputStream( propFileName );
			prop.store(outputStream, "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   
	}	
}