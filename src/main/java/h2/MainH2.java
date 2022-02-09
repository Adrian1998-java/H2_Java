package h2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainH2 {

	private static Connection conn;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		conn = H2JDBCUtils.getConnection();

		int valor = 99;

		System.out.println("Bienvenido al programa Java para tratar con H2");

		while (valor != 0) {
			System.out.println("Selecione la opcion que quiera realizar:");
			System.out.println("(1) Insertar datos");
			System.out.println("(2) Eliminar datos");
			System.out.println("(3) Actualizar datos");
			System.out.println("(0) Salir de la aplicación");

			valor = Integer.parseInt(in.nextLine());
			switch (valor) {
			case 1:
				InsertarDatos();
				break;
			case 2:
				EliminarDatos();
				break;
			case 3:
				ModificarDatos();
				break;
			case 0:
				System.out.println("Saliendo de la aplicación");
				System.out.println("¡Hasta luego!");
				break;
			default:
				System.out.println("Elija una opción válida...");
				break;
			}
		}

		// Cierra la conexión
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void InsertarDatos() throws SQLException {
		int valor = 99;

		while (valor != 0) {
			System.out.println("Selecione la tabla donde quiera insertar:");
			System.out.println("(1) Tienda");
			System.out.println("(2) Clientes");
			System.out.println("(0) Salir");

			PreparedStatement ps;
			valor = Integer.parseInt(in.nextLine());
			switch (valor) {
			case 1:
				ps = conn.prepareStatement(
						"INSERT INTO TIENDA (CODTIENDA, NOMPRODUCTO, LOCALIZACION) VALUES (?, ?, ?);");
				System.out.print("CodTienda (9 valores)-> ");
				ps.setString(1, in.nextLine());
				System.out.print("nomProducto -> ");
				ps.setString(2, in.nextLine());
				System.out.print("Localizacion -> ");
				ps.setString(3, in.nextLine());

				System.out.println("Introduciendo el siguiente registro: " + ps);
				ps.executeUpdate();
				break;

			case 2:
				ps = conn.prepareStatement("INSERT INTO CLIENTES (IDCLIENTE, NOMCLIENTE, CODTIENDA) VALUES (?, ?, ?);");
				System.out.print("idCliete (5 valores) -> ");
				ps.setString(1, in.nextLine());
				System.out.print("nomCLiente -> ");
				ps.setString(2, in.nextLine());
				System.out.print("CodTienda (9 valores)-> ");
				ps.setString(3, in.nextLine());

				System.out.println("Introduciendo el siguiente registro: " + ps);
				ps.executeUpdate();
				break;
			case 0:
				break;
			default:
				System.out.println("Elija una opción válida...");
				break;
			}

		}

	}

	private static void EliminarDatos() throws SQLException {
		int valor = 99;

		while (valor != 0) {
			System.out.println("Selecione la tabla donde quiera eliminar un registro:");
			System.out.println("(1) Tienda");
			System.out.println("(2) Clientes");
			System.out.println("(0) Salir");

			String id;
			Statement statement;
			valor = Integer.parseInt(in.nextLine());
			switch (valor) {
			case 1:
				System.out.print("CodTienda -> ");
				id = in.nextLine();
				statement = conn.createStatement();
				statement.execute("delete from Tienda where CODTIENDA = '" + id + "'");
				System.out.println("El registro se a borrado con éxito");
				break;
			case 2:
				System.out.print("idCliente -> ");
				id = in.nextLine();
				statement = conn.createStatement();
				statement.execute("delete from Clientes where IDCLIENTE = '" + id + "'");
				System.out.println("El registro se a borrado con éxito");
				break;
			case 0:
				break;
			default:
				System.out.println("Elija una opción válida...");
				break;
			}
		}

	}

	private static void ModificarDatos() throws SQLException {

		int valor = 99;

		while (valor != 0) {
			System.out.println("Selecione la tabla donde quiera modificar un registro:");
			System.out.println("(1) Tienda");
			System.out.println("(2) Clientes");
			System.out.println("(0) Salir");

			PreparedStatement ps;
			valor = Integer.parseInt(in.nextLine());
			switch (valor) {
			case 1:
				ps = conn.prepareStatement("update TIENDA set NOMPRODUCTO = ?, LOCALIZACION = ? where CODTIENDA = ?;");
				System.out.print("nomProducto -> ");
				ps.setString(1, in.nextLine());
				System.out.print("Localizacion -> ");
				ps.setString(2, in.nextLine());
				System.out.print("CodTienda (9 valores)-> ");
				ps.setString(3, in.nextLine());

				ps.executeUpdate();
			case 2:
				ps = conn.prepareStatement("update CLIENTES set NOMCLIENTE = ? where IDCLIENTE = ?;");
				System.out.print("nomCliente -> ");
				ps.setString(1, in.nextLine());
				System.out.print("idCliente (5 valores) -> ");
				ps.setString(2, in.nextLine());

				ps.executeUpdate();
			case 0:
				break;
			default:
			}
		}

	}

}
