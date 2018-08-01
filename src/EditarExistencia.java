package U3_4;

import Unidad3_4.AAAProducto;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditarExistencia implements Initializable {

    private ArrayList<AAAAProducto> Productos;
    private ArrayList<AAAAExistencias> Existencias;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField cantidad;

    @FXML
    private JFXTextField costo;

    @FXML
    private JFXComboBox<String> producto;

    @FXML
    private JFXComboBox<String> existencia;

    @FXML
    void Actualizar(ActionEvent event) throws SQLException {
        int idSelecExistencia = existencia.getSelectionModel().getSelectedIndex();
        int idExistencia  = Existencias.get(idSelecExistencia).getIdExistencias();
        int indiceProductoSeleccionado = producto.getSelectionModel().
                getSelectedIndex();
        int idProducto = Productos.get(indiceProductoSeleccionado).getIdProducto();
        int cantidadExistencia = Integer.valueOf(cantidad.getText());
        double costoExistencia = Double.valueOf(costo.getText());

        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);
        String sql = "UPDATE existencias SET " +
                "idProducto="+idProducto+", " +
                "cantidad="+cantidadExistencia+"," +
                "costo="+costoExistencia+" WHERE idExistencias="+idExistencia;
        statement.execute(sql);
        statement.close();
        connection.close();

        Existencias.get(idSelecExistencia).setIdProducto(idProducto);
        Existencias.get(idSelecExistencia).setCosto(costoExistencia);
        Existencias.get(idSelecExistencia).setCantidad(cantidadExistencia);

        existencia.getSelectionModel().clearSelection();
        producto.getSelectionModel().clearSelection();
        cantidad.setText("");
        costo.setText("");

    }

    @FXML
    void Cancelar(ActionEvent event) {
        Pane Panel = (Pane) contenedor.getParent();
        Panel.getChildren().remove(0);

    }

    @FXML
    void Eliminar(ActionEvent event) throws SQLException {
        int idSelecExistencia = existencia.getSelectionModel().getSelectedIndex();
        int idExistencia  = Existencias.get(idSelecExistencia).getIdExistencias();

        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM existencias WHERE idExistencias="+idExistencia;
        statement.execute(sql);

        statement.close();
        connection.close();
        existencia.getItems().remove(idSelecExistencia);
        Existencias.remove(idSelecExistencia);

        existencia.getSelectionModel().clearSelection();
        producto.getSelectionModel().clearSelection();
        cantidad.setText("");
        costo.setText("");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");


        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "SELECT * FROM productos";

        Productos = new ArrayList<AAAAProducto>();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            producto.getItems().add(resultSet.getString("nombre"));

            Productos.add(new AAAAProducto(
                    resultSet.getInt("idProducto"),
                    resultSet.getInt("idProveedor"),
                    resultSet.getString("nombre"),
                    resultSet.getString("descripcion")
            ));
        }


        sql = "SELECT existencias.*, productos.nombre AS prodNombre, " +
                "proveedores.nombre AS provNombre " +
                "FROM existencias, productos, proveedores" +
                " WHERE existencias.idProducto=productos.idProducto" +
                " AND productos.idProveedor=proveedores.idProvedor";

        Existencias = new ArrayList<AAAAExistencias>();
        resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            existencia.getItems().add(
                    resultSet.getString("prodNombre")+ "[" + resultSet.getString("provNombre")+ "]");

            Existencias.add(new AAAAExistencias(
                    resultSet.getInt("idExistencias"),
                    resultSet.getInt("idProducto"),
                    resultSet.getInt("cantidad"),
                    resultSet.getDouble("costo")
            ));
        }

        statement.close();
        connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        existencia.setOnAction(e -> {
            int indiceSeleccionadoExistencia = existencia.getSelectionModel().
                    getSelectedIndex();


            cantidad.setText(String.valueOf(
                    Existencias.get(indiceSeleccionadoExistencia).getCantidad()
            ));
            costo.setText(String.valueOf(
                    Existencias.get(indiceSeleccionadoExistencia).getCosto()
            ));

            for(int i = 0; i<Productos.size(); i++) {
                if(Existencias.get(indiceSeleccionadoExistencia).getIdProducto()==
                        Productos.get(i).getIdProducto()) {
                    producto.getSelectionModel().select(i);
                }
            }

        });

    }
}
