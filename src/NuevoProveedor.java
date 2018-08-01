package U3_4;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NuevoProveedor {

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
    void Cancelar(ActionEvent event) {
        Pane panel = (Pane) contenedor.getParent();
        panel.getChildren().remove(0);

    }

    @FXML
    void Crear(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:puntoVenta.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(60);

        String sql = "INSERT INTO proveedores (" + "nombre, rfc, calle, colonia, ciudad," + "pais, telefono, celular, email) VALUES (" +
                "'" + nombre.getText() + "'," +
                "'" + rfc.getText() + "'," +
                "'" + calle.getText() + "'," +
                "'" + colonia.getText() + "'," +
                "'" + ciudad.getText() + "'," +
                "'" + pais.getText() + "'," +
                "'" + telefono.getText() + "'," +
                "'" + celular.getText() + "'," +
                "'" + correo.getText() + "'" +
                ")";
        statement.execute(sql);
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

}
