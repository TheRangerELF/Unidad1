package U3_4;

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

public class NuevaExistencia  implements Initializable {

    private ArrayList<AAAAProducto> Productos;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField cantidad;

    @FXML
    private JFXTextField costo;

    @FXML
    private JFXComboBox<String> producto;

    @FXML
    void Cancelar(ActionEvent event) {
        Pane Panel =(Pane) contenedor.getParent();
        Panel.getChildren().remove(0);

    }

    @FXML
    void Crear(ActionEvent event) throws SQLException {
        int indiceProductoSeleccionado = producto.getSelectionModel().getSelectedIndex();
        int idProducto = Productos.get(indiceProductoSeleccionado).getIdProducto();
        int cantidadExistencia = Integer.valueOf(cantidad.getText());
        double costoExistencias = Double.valueOf(costo.getText());

        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "INSERT INTO existencias (idProducto, cantidad, costo)"+ "VALUES ("+
                idProducto+","+cantidadExistencia+","+costoExistencias+")";
        statement.execute(sql);
        statement.close();
        connection.close();

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

            while(resultSet.next()){
                producto.getItems().add(resultSet.getString("nombre"));

                Productos.add(new AAAAProducto(
                        resultSet.getInt("idProducto"),
                        resultSet.getInt("idProveedor"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion")
                ));
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
