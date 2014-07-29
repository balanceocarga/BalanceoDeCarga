package com.procesos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta37 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:C:/db/db");        

    	try {
			Statement s =c.createStatement();
			for(int i=0; i<10000;i++){
				s.execute("select * from prueba where id > 1 and id < 10000");
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        		        
        
        c.close();
        
        } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	    }
    }  


}
