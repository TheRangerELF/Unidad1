package U3_4;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
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

public class NuevoProducto  implements Initializable {

    private ArrayList<AAAAProveedor> Proveedores;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXComboBox<String> proveedor;

    @FXML
    private JFXTextArea descripcion;

    @FXML
    void Cancelar(ActionEvent event) {
        Pane Panel = (Pane) contenedor.getParent();
        Panel.getChildren().remove(0);

    }

    @FXML
    void Crear(ActionEvent event) throws SQLException {
        String nombreProducto = nombre.getText();
        String descripcionProducto = descripcion.getText();
        int indiceSeleccionado = proveedor.getSelectionModel().getSelectedIndex();
        int idProveedor = Proveedores.get(indiceSeleccionado).getIdProveedor();

        Connection connection = DriverManager.
                getConnection("jdbc:sqlite:puntoVenta.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "INSERT INTO productos (idProveedor, nombre, descripcion) " +
                "VALUES ("+idProveedor+", '"+nombreProducto+"', '"+descripcionProducto+"')";
        statement.execute(sql);
        statement.close();
        connection.close();
        proveedor.getSelectionModel().clearSelection();
        nombre.setText("");
        descripcion.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:sqlite:puntoVenta.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String sql = "SELECT * FROM proveedores";

            ResultSet resultSet = statement.executeQuery(sql);

            Proveedores = new ArrayList<AAAAProveedor>();

            while(resultSet.next()) {

                proveedor.getItems().add(resultSet.getString("nombre"));
                Proveedores.add(new AAAAProveedor(
                        resultSet.getInt("idProvedor"),
                        resultSet.getString("nombre"),
                        resultSet.getString("rfc"),
                        resultSet.getString("calle"),
                        resultSet.getString("colonia"),
                        resultSet.getString("ciudad"),
                        resultSet.getString("pais"),
                        resultSet.getString("telefono"),
                        resultSet.getString("celular"),
                        resultSet.getString("email")
                ));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
