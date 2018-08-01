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

public class EditarProveedor implements Initializable {

    private  int indice;

    @FXML
    private AnchorPane contenedor;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextField rfc;

    @FXML
    private JFXTextField calle;

    @FXML
    private JFXTextField colonia;

    @FXML
    private JFXTextField ciudad;

    @FXML
    private JFXTextField pais;

    @FXML
    private JFXTextField telefono;

    @FXML
    private JFXTextField celular;

    @FXML
    private JFXTextField correo;

    @FXML
    private JFXComboBox<String> proveedor;
    private ArrayList<AAAAProveedor> Proveedores;

    @FXML
    void Actualizar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE proveedores SET " +
                "nombre='"+nombre.getText()+"', " +
                "rfc='"+rfc.getText()+"', " +
                "calle='"+calle.getText()+"', " +
                "colonia='"+colonia.getText()+"', " +
                "ciudad='"+ciudad.getText()+"', " +
                "pais='"+pais.getText()+"', " +
                "telefono='"+telefono.getText()+"', " +
                "celular='"+celular.getText()+"', " +
                "email='"+correo.getText()+"' " +
                " WHERE idProvedor ="+Proveedores.get(indice).getIdProveedor();

        statement.execute(sql);
        Proveedores.get(indice).setNombre(nombre.getText());
        Proveedores.get(indice).setRfc(rfc.getText());
        Proveedores.get(indice).setCalle(calle.getText());
        Proveedores.get(indice).setColonia(colonia.getText());
        Proveedores.get(indice).setCiudad(ciudad.getText());
        Proveedores.get(indice).setPais(pais.getText());
        Proveedores.get(indice).setTelefono(telefono.getText());
        Proveedores.get(indice).setCelular(celular.getText());
        Proveedores.get(indice).setCorreo(correo.getText());

    }

    @FXML
    void Cancelar(ActionEvent event) {
        Pane Panel = (Pane) contenedor.getParent();
        Panel.getChildren().remove(0);

    }

    @FXML
    void Eliminar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.
                getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM proveedores WHERE idProvedor=" + Proveedores.get(indice).getIdProveedor();

        statement.execute(sql);
        statement.close();
        connection.close();

        proveedor.getItems().remove(indice);
        Proveedores.remove(indice);

        nombre.setText("");
        rfc.setText("");
        calle.setText("");
        colonia.setText("");
        ciudad.setText("");
        pais.setText("");
        telefono.setText("");
        celular.setText("");
        correo.setText("");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(60);

            String sql = "SELECT * FROM proveedores";

            ResultSet resultSet = statement.executeQuery(sql);

            Proveedores = new ArrayList<AAAAProveedor>();
                while(resultSet.next()){
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
                    proveedor.getItems().add(resultSet.getString("nombre"));
                }

                proveedor.setOnAction(event -> {
                    indice = proveedor.getSelectionModel().getSelectedIndex();
                    nombre.setText(Proveedores.get(indice).getNombre());
                    rfc.setText(Proveedores.get(indice).getRfc());
                    calle.setText(Proveedores.get(indice).getCalle());
                    colonia.setText(Proveedores.get(indice).getColonia());
                    ciudad.setText(Proveedores.get(indice).getCiudad());
                    pais.setText(Proveedores.get(indice).getPais());
                    telefono.setText(Proveedores.get(indice).getTelefono());
                    celular.setText(Proveedores.get(indice).getCelular());
                    correo.setText(Proveedores.get(indice).getCorreo());

                });
                statement.close();
                connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
