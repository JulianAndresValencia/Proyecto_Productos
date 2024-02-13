package CONTROLADOR;

import MODELO.Producto;
import MODELO.Registro;
import VISTA.frm_RegistrarProducto; // Importa la clase frm_RegistrarProducto del paquete VISTA
import MODELO.ListarProductos; // Importa la clase listarProductos del paquete MODELO
import java.awt.event.ActionEvent;// Importa las clases ActionEvent y ActionListener del paquete java.awt.event
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Controlador_Frm_Registrar_Producto implements ActionListener{
    frm_RegistrarProducto frm_rp;

        // Constructor que recibe la instancia del formulario frm_RegistrarProducto
    public Controlador_Frm_Registrar_Producto(frm_RegistrarProducto frm_rp) {
        // Asigna la instancia del formulario recibida al atributo de la clase
        this.frm_rp = frm_rp;
        // Agrega este controlador como ActionListener al botón guardar del formulario
        this.frm_rp.btnguardar.addActionListener(this);
    }
    
    // Método que se ejecuta cuando se realiza una acción en algún componente
       @Override
public void actionPerformed(ActionEvent e) {
    // Verifica si la acción proviene del botón guardar del formulario
    if (e.getSource()==frm_rp.btnguardar){ // Llama al método para limpiar las entradas
        
        String nombre=frm_rp.textnombre.getText();// Obtiene el texto ingresado en el campo de texto 'textnombre' del formulario 'frm_rp' y lo almacena en la variable 'nombre'
        int cantidad=Integer.parseInt(frm_rp.textcantidad.getText());// Obtiene el texto ingresado en el campo de texto 'textcantidad' del formulario 'frm_rp', lo convierte a un número entero y lo almacena en la variable 'cantidad'
        Double precio=Double.parseDouble(frm_rp.textprecio.getText());// Similar al paso anterior, pero convierte el texto ingresado en el campo 'textprecio' a un número de tipo 'Double' y lo almacena en la variable 'precio'
        
        Producto P=new Producto (nombre, cantidad, precio);// Crea un nuevo objeto de tipo 'Producto' utilizando los valores obtenidos anteriormente para el nombre, cantidad y precio
        Registro R=new Registro ();// Crea una nueva instancia de la clase 'Registro'
        R.registrarbd(P);// Llama al método 'registrarbd' del objeto 'R' (de tipo 'Registro') y le pasa el objeto 'P' (de tipo 'Producto') como parámetro para ser registrado en la base de datos
                
        ListarProductos lp=new ListarProductos();// Crea una nueva instancia de la clase 'ListarProductos'
        lp.mostrarTabla(frm_rp.TablaProductos);// Llama al método 'mostrarTabla' de la instancia 'lp' y le pasa la tabla 'TablaProductos' del formulario 'frm_rp' para mostrar los datos de los productos en esa tabla
        limpiarentradas();// Llama al método 'limpiarentradas()' para limpiar los campos de texto del formulario después de registrar el producto
    }
}

private void limpiarentradas() {
    // Limpia los campos de texto del formulario
    frm_rp.textnombre.setText("");
    frm_rp.textprecio.setText("");
    frm_rp.textprecio.setText("");
}
    
}
