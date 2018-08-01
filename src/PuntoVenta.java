package U3_4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.LongAccumulator;

public class PuntoVenta  extends Application {

    @FXML
    private Pane contenedor;

    @FXML
    void acercaDe(ActionEvent event) {

    }

    @FXML
    void crearCliente(ActionEvent event) throws IOException {
        Parent Layout =FXMLLoader.load(getClass().getResource("NuevoCliente.fxml"));
        contenedor.getChildren().add(Layout);

    }

    @FXML
    void crearExistencia(ActionEvent event) throws IOException {
        Parent Layout =FXMLLoader.load(getClass().getResource("NuevaExistencia.fxml"));
        contenedor.getChildren().add(Layout);

    }

    @FXML
    void crearProducto(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("NuevoProducto.fxml"));
        contenedor.getChildren().add(Layout);

    }

    @FXML
    void crearProveedor(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("NuevoProveedor.fxml"));
        contenedor.getChildren().add(Layout);

    }

    @FXML
    void crearVenta(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("NuevaVenta.fxml"));
        contenedor.getChildren().add(Layout);

    }

    @FXML
    void editarCliente(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("EditarCliente.fxml"));
        contenedor.getChildren().add(Layout);

    }

    @FXML
    void editarExintencia(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("EditarExistencia.fxml"));
        contenedor.getChildren().add(Layout);

    }

    @FXML
    void editarProducto(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("EditarProducto.fxml"));
        contenedor.getChildren().add(Layout);


    }

    @FXML
    void editarProveedor(ActionEvent event) throws IOException {
        Parent Layout = FXMLLoader.load(getClass().getResource("EditarProveedor.fxml"));
        contenedor.getChildren().add(Layout);

    }

    @FXML
    void salir(ActionEvent event) {
        Platform.exit();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent Layout = FXMLLoader.load(getClass().getResource("PuntoVenta.fxml"));

        Scene Escena = new Scene(Layout);
        primaryStage.setScene(Escena);
        primaryStage.setTitle("Punto de Venta");
        primaryStage.show();
    }
}
