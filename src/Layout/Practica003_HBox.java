package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;

public class Practica003_HBox extends Application {

    public static void main(String[] args){
            launch(args);
        }
        @Override
        public void start(Stage primaryStage) throws Exception {
//Interfaz
            Button Boton1 = new Button("Boton 1");
            Button Boton2 = new Button("Boton 2");
            Button Boton3 = new Button("Boton 3");
//Panel
            HBox Layout = new HBox();
            Layout.setPadding(new Insets(10));
            Layout.setSpacing(10);
            Layout.getChildren().addAll(Boton1,Boton2,Boton3);
            Scene Escena = new Scene(Layout);
//Mostrar Interfaz
            primaryStage.setScene(Escena);
            primaryStage.show();
        }
    }

