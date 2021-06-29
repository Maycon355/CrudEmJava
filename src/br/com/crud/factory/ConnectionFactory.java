package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	// Nome usuário do Banco de Dadps
	private static final String USERNAME = "root";
	// Senha do banco (vazio)
	private static final String PASSWORD = "";
	// Caminho do Banco (Docker/Port)
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud";

	//Conexão com o Banco:
	
	public static Connection createConnectionToMySql () throws Exception {
	
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}  
	
	public static void main(String[] args) throws Exception {
		
		
	//Recuperar alguma conexão com o bando de dados de houver
		Connection con = createConnectionToMySql ();
		
	//Testar se a conexão é Nula
		if (con != null) {
			System.out.println("Conexão Feita com sucesso!!!");
			con.close();
			
		}
	}
}
