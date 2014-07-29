package com.balanceador.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public Proceso obtenerProceso(String descripcion) throws SQLException{
		st =con.createStatement();
		ResultSet rs= st.executeQuery("select * from procesos where descripcion = '"+ descripcion+"'");
		Proceso p = new Proceso();
		if(rs.next()){
			p.setId(rs.getInt(1));
			p.setDescripcion(rs.getString(2));
			p.setPrioridad(rs.getInt(3));
			p.setUsoCpu(rs.getString(4));
			p.setUsoMemoria(rs.getString(5));
			p.setTiempoEstimado(rs.getInt(6));
			st.close();
			rs.close();
			return p;
		}else{
			st.close();
			rs.close();
			return null;
		}	
		
	}
	
	public void insertarProceso(Proceso proceso) throws SQLException{
		st =con.createStatement();
		ResultSet rs= st.executeQuery("select * from procesos order by id desc");
		Proceso p = new Proceso();
		if(rs.next()){
			p.setId(rs.getInt(1)+1);
			String insert ="insert into procesos values("+p.getId()+",'"+proceso.getDescripcion()+"',"
			+proceso.getPrioridad()+",'"+proceso.getUsoCpu()+"','"+proceso.getUsoMemoria()+"',"+proceso.getTiempoEstimado()+")";
			st.executeUpdate(insert);
		}else{
			String insert ="insert into procesos values("+1+",'"+proceso.getDescripcion()+"',"
			+proceso.getPrioridad()+",'"+proceso.getUsoCpu()+"','"+proceso.getUsoMemoria()+"',"+proceso.getTiempoEstimado()+")";
			st.executeUpdate(insert);
		}
		st.close();
		rs.close();
	}
	
	public void actualizarProceso(Proceso proceso) throws SQLException{
		st =con.createStatement();
		String update ="update procesos set " +
		"prioridad="+proceso.getPrioridad()+"," +
		"uso_cpu='"+proceso.getUsoCpu()+"'," +
		"uso_memoria='"+proceso.getUsoMemoria()+"'," +
		"tiempo_estimado="+proceso.getTiempoEstimado()+" " +
		"where id= "+proceso.getId();
	    st.executeUpdate(update);	
	    st.close();
	}	
	

	
}
