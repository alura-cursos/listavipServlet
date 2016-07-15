package br.com.listavip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FabricaDeConexao {

	Connection connection = null;

	public Connection obterConexao() {

		try {

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			String serverName = "localhost";

			String mydatabase = "listavip"; 

			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

			String username = "root";

			String password = "root";

			connection = DriverManager.getConnection(url, username, password);

			return connection;

		} catch (ClassNotFoundException e) {

			return null;

		} catch (SQLException e) {

			return null;

		}

	}
	
	public static void main(String[] args) throws SQLException {
		FabricaDeConexao conexao = new FabricaDeConexao();
		Connection conn = conexao.obterConexao();
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO convidado(nome, email, telefone) VALUES(?, ?, ?);";
		
		preparedStatement = conn.prepareStatement(insertSQL);
		preparedStatement.setString(1, "Paula");
		preparedStatement.setString(2, "paula@gmail.com");
		preparedStatement.setString(3, "(41) 8877-0099");
		
		preparedStatement.execute();
		
		
		String selectSQL = "select * from convidado";
		
		preparedStatement = conn.prepareStatement(selectSQL);
		
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {

			String userid = rs.getString("id");
			String username = rs.getString("nome");

			System.out.println("userid : " + userid);
			System.out.println("username : " + username);

		}
		
	}

}
