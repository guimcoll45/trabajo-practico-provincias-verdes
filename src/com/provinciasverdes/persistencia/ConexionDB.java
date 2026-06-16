package com.provinciasverdes.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/provincias_verdes?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root"; // Cambiar si es necesario
    private static final String CLAVE = "";        // Tu contraseña de MySQL

    // Método para conectar
    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: Driver no encontrado. " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ Error de conexión: " + e.getMessage());
        }
        return conexion;
    }

    // Método para cerrar
    public static void desconectar(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("🔌 Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al cerrar: " + e.getMessage());
        }
    }
}
