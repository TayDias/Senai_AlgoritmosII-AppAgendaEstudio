
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Taynara
 */
public class PostgreSQL {
    public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");

			String nomeServidor = "localhost:5432";
			String database = "EstudioGravacao";
			String url = "jdbc:postgresql://" + nomeServidor + "/" + database;
			String username = "postgres";
			String password = "";
			
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}
}
