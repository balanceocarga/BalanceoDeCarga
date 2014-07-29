package com.balanceador.cliente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Propiedades {
	
	public int obtenerPropiedad(String propiedad){
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
        return Integer.valueOf(prop.getProperty(propiedad));
	}
	
	public void escribirPropiedad(String propiedad){
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
        int cantProcesos= Integer.valueOf(prop.getProperty(propiedad));
        cantProcesos=cantProcesos+1;
        prop.setProperty(propiedad,String.valueOf(cantProcesos));
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
