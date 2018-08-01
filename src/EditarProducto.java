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

public class EditarProducto  implements Initializable {

    private ArrayList<AAAAProveedor> Proveedor;
    private  ArrayList<AAAAProducto> Producto;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXComboBox<String> proveedor;

    @FXML
    private JFXTextArea descripcion;

    @FXML
    private JFXComboBox<String> producto;

    @FXML
    void Actualizar(ActionEvent event) throws SQLException {
        String nombreProducto = nombre.getText();
        String descripcionProducto = descripcion.getText();
        int indiceSeleccionado = proveedor.getSelectionModel().getSelectedIndex();
        int idProveedor = Proveedor.get(indiceSeleccionado).getIdProveedor();

        int indiceSeleccionadoProducto = producto.getSelectionModel().getSelectedIndex();
        int idProducto = Producto.get(indiceSeleccionadoProducto).getIdProducto();

        Connection connection = DriverManager.
                getConnection("jdbc:sqlite:puntoVenta.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE productos SET " +
                "idProveedor="+idProveedor+", " +
                "nombre='"+nombreProducto+"'," +
                "descripcion='"+descripcionProducto+"' WHERE idProducto="+idProducto;
        statement.execute(sql);
        statement.close();
        connection.close();
        Producto.get(indiceSeleccionadoProducto).setNombre(nombreProducto);
        Producto.get(indiceSeleccionadoProducto).setDescripcion(descripcionProducto);
        Producto.get(indiceSeleccionadoProducto).setIdProveedor(idProveedor);

        proveedor.getSelectionModel().clearSelection();
        producto.getSelectionModel().clearSelection();
        nombre.setText("");
        descripcion.setText("");

    }


    @FXML
    void Cancelar(ActionEvent event) {
        Pane Panel = (Pane) contenedor.getParent();
        Panel.getChildren().remove(0);

    }

    @FXML
    void eliminar(ActionEvent event) throws SQLException {
        int indice = producto.getSelectionModel().getSelectedIndex();
        int idProducto = Producto.get(indice).getIdProducto();

        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM productos WHERE idProducto="+idProducto;
        statement.execute(sql);

        producto.getSelectionModel().clearSelection();
        proveedor.getSelectionModel().clearSelection();
        nombre.setText("");
        descripcion.setText("");

        Producto.remove(indice);
        producto.getItems().remove(indice);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:sqlite:puntoVenta.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String sql = "SELECT * FROM productos";

            ResultSet resultSet = statement.executeQuery(sql);

            Producto = new ArrayList<AAAAProducto>();

            while(resultSet.next()) {

                producto.getItems().add(resultSet.getString("nombre"));
                Producto.add(new AAAAProducto(
                        resultSet.getInt("idProducto"),
                        resultSet.getInt("idProveedor"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion")
                ));
            }


            sql = "SELECT * FROM proveedores";

            resultSet = statement.executeQuery(sql);

            Proveedor = new ArrayList<AAAAProveedor>();

            while(resultSet.next()) {

                proveedor.getItems().add(resultSet.getString("nombre"));
                Proveedor.add(new AAAAProveedor(
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



        producto.setOnAction(e -> {
            int indice = producto.getSelectionModel().getSelectedIndex();

            nombre.setText(Producto.get(indice).getNombre());
            descripcion.setText(Producto.get(indice).getDescripcion());

            for(int i =0; i<Proveedor.size(); i++) {
                if(Producto.get(indice).getIdProveedor() == Proveedor.get(i).getIdProveedor()) {
                    proveedor.getSelectionModel().select(i);
                    break;
                }
            }

        });

    }
}
