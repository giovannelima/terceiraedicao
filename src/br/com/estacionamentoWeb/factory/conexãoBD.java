package br.com.estacionamentoWeb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conex�oBD {
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/estacionamento";

	public static Connection conectar() throws SQLException {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName(com.mysql.jdbc.Driver.class.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conn;
	}

	public static void main(String[] args) {
		try {
			Connection conexao = conex�oBD.conectar();
			System.out.println("Conectado com sucesso!! ");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Conex�o falhou!!");
		}
	}

}
