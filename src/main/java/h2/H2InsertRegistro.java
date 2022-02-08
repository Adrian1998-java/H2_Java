package h2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2InsertRegistro {

	private static final String INSERT_USERS_SQL = "INSERT INTO TIENDA (CODTIENDA, NOMPRODUCTO, LOCALIZACION) VALUES (?, ?, ?);";
//			"INSERT INTO users" +
//	        "  (id, name, email, country, password) VALUES " +
//	        " (?, ?, ?, ?, ?);";

	    public static void main(String[] argv) throws SQLException {
	        H2InsertRegistro createTableExample = new H2InsertRegistro();
	        createTableExample.insertRecord();
	    }

	    public void insertRecord() throws SQLException {
	        System.out.println(INSERT_USERS_SQL);
	        // Step 1: Establishing a Connection
	        try (Connection connection = H2JDBCUtils.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setString(1, "12345678A");
	            preparedStatement.setString(2, "Mantequilla");
	            preparedStatement.setString(3, "C\\ Sabandeño");

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {

	            // print SQL exception information
	        	H2JDBCUtils.printSQLException(e);
	        }

	        // Step 4: try-with-resource statement will auto close the connection.
	    }
	
}
