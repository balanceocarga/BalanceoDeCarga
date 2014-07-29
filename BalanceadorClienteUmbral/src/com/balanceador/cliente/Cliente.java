package com.balanceador.cliente;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class Cliente {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws SQLException, RemoteException {
	
/*	DB db = new DB();
	Set listaIPs = db.consultarServidores();
	Iterator itServidores = listaIPs.iterator();
	CPUmon cpu;
	while(itServidores.hasNext()){
		cpu=new CPUmonProxy("http://"+itServidores.next()+":8080/BalanceadorServer/services/CPUmon");
		String[] param = new String [2];
		param[0]="com.procesos.Consulta8";
		param[1]="1";
		cpu.ejecutarProceso(param);
	
	}*/
	
	}

}
