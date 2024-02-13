package MODELO;

import Conexion.ConexionMysql;// Importa la clase ConexionMysql del paquete Conexion
import java.sql.Connection;// Importa la clase Connection del paquete java.sql
import java.sql.PreparedStatement;// Importa la clase PreparedStatement del paquete java.sql
import java.sql.SQLException; // Se agrega la importación de SQLException
import javax.swing.JOptionPane;// Importa la clase JOptionPane del paquete javax.swing

public class Registro {
    ConexionMysql con=new ConexionMysql(); // Se crea una instancia de la clase ConexionMysql
    Connection cn=con.conectar(); // Se establece la conexión con la base de datos
    
    // Método para registrar un producto en la base de datos
    public void registrarbd (Producto p){
       try {
           // Prepara la consulta SQL para insertar un nuevo producto en la tabla "producto"
           PreparedStatement ps=cn.prepareStatement("INSERT INTO producto (nombre,cantidad,precio,total)VALUES(?,?,?,?)");
           ps.setString(1, p.getNombre()); // Establece el nombre del producto en la primera posición del PreparedStatement
           ps.setInt(2, p.getCantidad()); // Establece la cantidad del producto en la segunda posición del PreparedStatement
           ps.setDouble(3, p.getPrecio()); // Establece el precio del producto en la tercera posición del PreparedStatement
           ps.setDouble(4, p.Total());// Establece el total del producto en la cuarta posición del PreparedStatement
           ps.executeUpdate();// Ejecuta la consulta para insertar el nuevo producto en la base de datos           
           
        } catch (SQLException e) { // Captura y maneja las excepciones de SQL
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR DATOS"+e);// Muestra un mensaje de error en caso de fallo al registrar el producto
        }        
    }    
}