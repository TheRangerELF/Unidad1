package U3_4;

public class AAAAExistencias {
    private int idExistencias;
    private int idProducto;
    private int cantidad;
    private  double costo;

    public AAAAExistencias(int idExistencias, int idProducto, int cantidad, double costo) {
        this.idExistencias = idExistencias;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getIdExistencias() {
        return idExistencias;
    }

    public void setIdExistencias(int idExistencias) {
        this.idExistencias = idExistencias;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
}
