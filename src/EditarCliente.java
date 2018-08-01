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

public class EditarCliente implements Initializable {

    private int indice;


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
    private JFXComboBox<String> cliente;
    private ArrayList<AAAACliente> Clientes;

    @FXML
    void Actualizar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.
                getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "UPDATE clientes SET " +
                "nombre='"+nombre.getText()+"', " +
                "rfc='"+rfc.getText()+"', " +
                "calle='"+calle.getText()+"', " +
                "colonia='"+colonia.getText()+"', " +
                "ciudad='"+ciudad.getText()+"', " +
                "pais='"+pais.getText()+"', " +
                "telefono='"+telefono.getText()+"', " +
                "celular='"+celular.getText()+"', " +
                "email='"+correo.getText()+"' " +
                " WHERE idCliente="+Clientes.get(indice).getIdCliente();

        statement.execute(sql);

        Clientes.get(indice).setNombre(nombre.getText());
        Clientes.get(indice).setRfc(rfc.getText());
        Clientes.get(indice).setCalle(calle.getText());
        Clientes.get(indice).setColonia(colonia.getText());
        Clientes.get(indice).setCiudad(ciudad.getText());
        Clientes.get(indice).setPais(pais.getText());
        Clientes.get(indice).setTelefono(telefono.getText());
        Clientes.get(indice).setCelular(celular.getText());
        Clientes.get(indice).setEmail(correo.getText());
    }

    @FXML
    void Cancelar(ActionEvent event) {
        Pane Panel = (Pane) contenedor.getParent();
        Panel.getChildren().remove(0);

    }

    @FXML
    void eliminar(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "DELETE FROM clientes WHERE idCliente=" + Clientes.get(indice).getIdCliente();

        statement.execute(sql);
        statement.close();
        connection.close();

        cliente.getItems().remove(indice);
        Clientes.remove(indice);

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

            String sql = "SELECT * FROM clientes";

            ResultSet resultSet = statement.executeQuery(sql);

            Clientes = new ArrayList<AAAACliente>();
            while(resultSet.next()) {
                Clientes.add(new AAAACliente(
                        resultSet.getInt("idCliente"),
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
                cliente.getItems().add(
                        resultSet.getString("nombre"));
            }

            cliente.setOnAction( e-> {
                indice = cliente.getSelectionModel().getSelectedIndex();
                nombre.setText(Clientes.get(indice).getNombre());
                rfc.setText(Clientes.get(indice).getRfc());
                calle.setText(Clientes.get(indice).getCalle());
                colonia.setText(Clientes.get(indice).getColonia());
                ciudad.setText(Clientes.get(indice).getCiudad());
                pais.setText(Clientes.get(indice).getPais());
                telefono.setText(Clientes.get(indice).getTelefono());
                celular.setText(Clientes.get(indice).getCelular());
                correo.setText(Clientes.get(indice).getEmail());
            });
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
