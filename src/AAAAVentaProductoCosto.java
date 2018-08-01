package U3_4;

public class AAAAVentaProductoCosto {
    private int idProducto;
    private int idExistencias;
    private int cantidad;
    private double costo;
    private String nombre;
    private String descripcion;

    public AAAAVentaProductoCosto(int idProducto, int idExistencias, int cantidad, double costo, String nombre, String descripcion) {
        this.idProducto = idProducto;
        this.idExistencias = idExistencias;
        this.cantidad = cantidad;
        this.costo = costo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdExistencias() {
        return idExistencias;
    }

    public void setIdExistencias(int idExistencias) {
        this.idExistencias = idExistencias;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
