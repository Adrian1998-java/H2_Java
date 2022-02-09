package h2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

			valor = in.nextInt();
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
			System.out.println("(0) Salir de la aplicación");

			valor = in.nextInt();
			switch (valor) {
			case 1:
				PreparedStatement ps = conn.prepareStatement(
						"INSERT INTO TIENDA (CODTIENDA, NOMPRODUCTO, LOCALIZACION) VALUES (?, ?, ?);");
				System.out.print("CodTienda -> ");
				ps.setString(1, in.next());
				System.out.print("nomProducto -> ");
				ps.setString(2, in.next());
				System.out.print("Localizacion -> ");
				ps.setString(3, in.next());

				System.out.println("Introduciendo el siguiente registro: " + ps);
				ps.executeUpdate();
				break;

			case 2:
				break;

			case 3:
				break;
			}

		}

	}

	private static void EliminarDatos() {
		int valor = 99;
		
		while (valor != 0) {
			System.out.println("Selecione la tabla donde quiera insertar:");
			System.out.println("(1) Tienda");
			System.out.println("(2) Clientes");
			System.out.println("(0) Salir de la aplicación");
		
		}
		
	}

	private static void ModificarDatos() {
		// TODO Auto-generated method stub

	}

}
