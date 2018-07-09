package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Practica005_BorderPane extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//Interfaz
        Button Boton1 = new Button("Arriba");
        Button Boton2 = new Button("Abajo");
        Button Boton3 = new Button("Izquiera");
        Button Boton4 = new Button("Derecha");
        Button Boton5 = new Button("Centro");
//Panel
        BorderPane Layout = new BorderPane();
        Layout.setTop(Boton1);
        Layout.setBottom(Boton2);
        Layout.setLeft(Boton3);
        Layout.setRight(Boton4);
        Layout.setCenter(Boton5);
        BorderPane.setAlignment(Boton2, Pos.CENTER);
        BorderPane.setAlignment(Boton1, Pos.CENTER);
        BorderPane.setAlignment(Boton3, Pos.CENTER);
        BorderPane.setAlignment(Boton4, Pos.CENTER);
        Layout.setPadding(new Insets(5));
//Mostrar Interfaz
        Scene Escena = new Scene(Layout, 200, 200);
        primaryStage.setScene(Escena);
        primaryStage.show();
    }
}
