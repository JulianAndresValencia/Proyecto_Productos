
package MODELO;

// Clase que representa un Producto en el modelo
public class Producto {
    
    // Atributos del producto
    private String nombre;
    private int cantidad;
    private Double precio;
    private Double total;

    // Constructor para inicializar un producto con nombre, cantidad y precio
    public Producto(String nombre, int cantidad, Double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Métodos de acceso para obtener y modificar los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    public Double Total(){
        Double resultado=cantidad*precio;
        return resultado; 
    }
    
}
