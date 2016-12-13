package br.com.listavip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	public Connection obterConexao() {

		try {

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			String serverName = "localhost";

			String mydatabase = "listavip"; 

			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

			String username = "root";

			String password = "";

			Connection connection = DriverManager.getConnection(url, username, password);

			return connection;

		} catch (ClassNotFoundException e) {

			return null;

		} catch (SQLException e) {

			return null;

		}

	}

}
