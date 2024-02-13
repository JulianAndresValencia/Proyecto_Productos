package Conexion;

// Importa las clases Connection y DriverManager del paquete java.sql
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMysql {
    // Variable para almacenar la conexión
    Connection cn;

    // Método para establecer la conexión con la base de datos
    public Connection conectar() {
        try {
            
            // Carga el controlador JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establece la conexión con la base de datos "proyecto_productos" en localhost
            // utilizando el usuario "root" y contraseña vacía
            cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_productos", "root", "");
            
            // Imprime un mensaje de éxito en la consola
            System.out.println("Conexion Exitosa");
            
        } catch (Exception e) {
            // Imprime un mensaje de error en la consola junto con la excepción
            System.out.println("Error de Conexion"+e);

        }
        // Retorna la conexión establecida
        return cn;
    }
}