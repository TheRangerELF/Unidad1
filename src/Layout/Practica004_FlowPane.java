package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.awt.*;

public class Practica004_FlowPane extends Application {
    public static void main (String [] args) {

        launch(args) ;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//Interfaz
        Button Boton1 = new Button("Boton1");
        Button Boton2 = new Button("Boton2");
        Button Boton3 = new Button("Boton3");
        Button Boton4 = new Button("Boton4");
        Button Boton5 = new Button("Boton5");
//Panel
        FlowPane Layout = new FlowPane();
        Layout.setAlignment(Pos.CENTER);
        Layout.setPadding(new Insets(10));
        Layout.setVgap(10);
        Layout.setHgap(10);
        Layout.getChildren().addAll(Boton1,Boton2,Boton3,Boton4,Boton5);
        Scene Escena = new Scene(Layout, 400,400);
//Mostrar Interfaz
        primaryStage.setScene(Escena);
        primaryStage.show();
    }
}
