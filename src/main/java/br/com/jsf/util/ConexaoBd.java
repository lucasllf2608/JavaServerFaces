package br.com.jsf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConexaoBd {
	
	private static String status = "Não conectou...";
	
	public static java.sql.Connection getConexao(){
		
		Connection connection = null;
		
		try {
			
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			
			String serverName = "localhost";
			String dataBase="crud";
			String url = "jdbc:mysql://" + serverName + "/" + dataBase;
			String user="root";
			String password="";
			connection = DriverManager.getConnection(url, user, password);
			if(connection != null){
				status = ("Conectado com sucesso");
			}else{
				status = ("Não foi possivel conectar");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public String getStatusConexao(){
		return status;
	}
	
	
	public static boolean fecharConexao(){
		
		try {
			
			ConexaoBd.getConexao().close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}
		
	}
	

}
