package U3_4;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class AAAAVentaElementos extends RecursiveTreeObject<AAAAVentaElementos> {
    private int idProductos;
    private int idExistencias;
    private int cantidad;
    private double costoUnitario;
    private double costoTotal;
    private  String nombre;

    public AAAAVentaElementos(int idProductos, int idExistencias, int cantidad, double costoUnitario, String nombre) {
        this.idProductos = idProductos;
        this.idExistencias = idExistencias;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.nombre = nombre;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
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

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getCostoTotal() {
        return costoTotal = cantidad*costoUnitario;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
