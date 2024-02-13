package MODELO;

import Conexion.ConexionMysql; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel; 
import java.sql.Connection; 
import java.sql.Statement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 

public class ListarProductos {
    ConexionMysql con = new ConexionMysql(); // Instancia de la clase de conexión a la base de datos
    Connection cn = con.conectar(); // Conexión a la base de datos
    
    // Método para mostrar los datos en una tabla
    public void mostrarTabla(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel(); // Nuevo modelo de tabla
        modelo.addColumn("ID"); // Agrega columna "ID"
        modelo.addColumn("Nombre"); // Agrega columna "Nombre"
        modelo.addColumn("Cantidad"); // Agrega columna "Cantidad"
        modelo.addColumn("Precio"); // Agrega columna "Precio"
        modelo.addColumn("Total"); // Agrega columna "Total"
        String consultaSql = "SELECT * FROM producto"; // Consulta SQL para obtener los datos de la tabla "producto"
        Statement st; // Declaración de Statement
        
        try {
            st = cn.createStatement(); // Creación de un nuevo Statement para ejecutar la consulta
            ResultSet rs = st.executeQuery(consultaSql); // Ejecución de la consulta y obtención del ResultSet
            while (rs.next()) { // Iteración sobre los resultados del ResultSet
                // Obtención de los valores de cada fila y agregación a un arreglo de objetos
                Object[] lista = {rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5)};
                modelo.addRow(lista); // Agrega la fila al modelo de la tabla
            }
            if (tabla != null) { // Verificación de que la tabla no sea null
                tabla.setModel(modelo); // Establece el modelo de la tabla con los datos obtenidos de la base de datos
            } else {
                System.out.println("La tabla es null. No se puede establecer el modelo."); // Mensaje si la tabla es null
            }
        } catch (SQLException e) { // Manejo de excepciones SQL
            System.out.println("ERROR AL LISTAR LOS DATOS: " + e.getMessage()); // Mensaje de error si ocurre una excepción
        }          
    }

    public void MostrarTable(JTable TablaProductos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

