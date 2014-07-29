package com.balanceador.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.balanceador.monitor.Proceso;


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

	//probar con preparedstatements
	public Set obtenerListaProcesos(Collection procesos) throws SQLException{
		st =con.createStatement();
		String consulta = "select distinct descripcion, prioridad from procesos where descripcion in(";
		Iterator it = procesos.iterator();	
		while(it.hasNext()){
			consulta+="'"+it.next()+"',";
		}
		consulta= consulta.substring(0, consulta.length()-1);
		consulta+=") order by prioridad asc";
		ResultSet rs= st.executeQuery(consulta);
		Set lista = new LinkedHashSet();
		Proceso p;
		while(rs.next()){
			p = new Proceso();
			p.setDescripcion(rs.getString(1));
			p.setPrioridad(rs.getInt(2));
			lista.add(p);
		}
		st.close();
		rs.close();
		return lista;	
		
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
