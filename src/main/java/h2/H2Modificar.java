package h2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Modificar {

    private static final String UPDATE_USERS_SQL = "update TIENDA set NOMPRODUCTO = ?, LOCALIZACION = ? where CODTIENDA = ?;";

    public static void main(String[] argv) throws SQLException {
        H2Modificar updateStatementExample = new H2Modificar();
        updateStatementExample.updateRecord();
    }

    public void updateRecord() throws SQLException {
        System.out.println(UPDATE_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, "Huevos");
            preparedStatement.setString(2, "Calle Mis Huevos");
            preparedStatement.setString(3, "12345678A");


            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}