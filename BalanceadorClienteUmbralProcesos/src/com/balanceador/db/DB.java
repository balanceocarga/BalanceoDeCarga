package com.balanceador.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;


public class DB {
	
	Connection con = null;
	Statement st=null;
	public DB() throws SQLException{
		
        try {
          Class.forName("org.sqlite.JDBC");
          con = DriverManager.getConnection("jdbc:sqlite:C:/db/db");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
	}
	
	public void cerrarConexion() throws SQLException{
		con.close();
	}

	
	public Collection consultarServidores() throws SQLException{
		st =con.createStatement();
		String consulta = "select ip from servidores";
		ResultSet rs= st.executeQuery(consulta);
		Collection lista = new ArrayList();
		while(rs.next()){
			lista.add(rs.getString(1));
		}
		st.close();
		rs.close();
		return lista;	
	}	

	
}
