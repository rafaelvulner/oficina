package br.com.oficina.oficina.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private Connection conn;
	
	private void connect() {
		
		System.out.println("Iniciando conexão com banco de dados MYSQL");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficina?autoReconnect=true&useSSL=false", "root", "");
			
			System.out.println("Conectando...");
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		
	
	}
	
	public Connection getConnection() throws NullPointerException{
		
		connect();
		
		return (conn != null ? conn : null);
		
	}
	
	public void exitConnection() {
		try {
			conn.close();
			System.out.println("Conexão fechada");
		} catch (SQLException e) {
			System.out.println("Problemas em fechar conexão: "+e.getMessage());
		}
	}

}
