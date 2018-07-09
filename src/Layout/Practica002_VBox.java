package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;

public class Practica002_VBox extends Application {
    public static void main (String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//Interfaz
        javafx.scene.control.Button Boton = new javafx.scene.control.Button("Click Aqui");
        javafx.scene.control.Label Etiqueta = new javafx.scene.control.Label("Buen Dia");
        Rectangle Rectangulo = new Rectangle(200,400, Color.RED);
//Panel
        VBox Layout = new VBox();
        Layout.setPadding(new Insets(10));
        Layout.setSpacing(10);
        Layout.getChildren().add(Boton);
        Layout.getChildren().add(Etiqueta);
        Layout.getChildren().add(Rectangulo);
//Mostrar Interfaz
        Scene Escena = new Scene(Layout);
        primaryStage.setScene(Escena);
        primaryStage.show();

    }
}
