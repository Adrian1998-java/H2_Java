package h2;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class H2CreateTables {

    private static final String createTableSQL = "create table Clientes (idCliente char(5) primary key, nomCliente varchar(50), codTienda char(9), foreign key (codTienda) references Tienda(codTienda))";
    		
    
//    		"create table Tienda (codTienda char(9) primary key, nomProducto varchar(50), localizacion varchar(100))"/
    
//    		"create table users (\r\n" + "  id  int(3) primary key,\r\n" +
//        "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +
//        "  password varchar(20)\r\n" + "  );";

    public static void main(String[] argv) throws SQLException {
        H2CreateTables createTableExample = new H2CreateTables();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }
}