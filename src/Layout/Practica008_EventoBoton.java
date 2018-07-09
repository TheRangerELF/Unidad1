package Layout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class Practica008_EventoBoton extends Application {
    public static void main(String[]args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//Interfaz
        //Label
        Label Valor1 = new Label("Valor 1");
        Label Valor2 = new Label("Valor 2");
        Label Resultado = new Label("Resultado");
        //TextField
        TextField V1 = new TextField();
        TextField V2 = new TextField();
        TextField Res = new TextField();
        //Boton
        Button Sumar = new Button("Sumar");
        Button Restar = new Button("Restar");
        Button Borrar = new Button("Borrar");
        Button Multiplicar = new Button("Multiplicar");
        //Layout
        GridPane Layout = new GridPane();
        Layout.setPadding(new Insets(10));
        Layout.add(Valor1,0,0);
        Layout.add(Valor2,0,1);
        Layout.add(Resultado,0,2);
        Layout.add(V1,1,0);
        Layout.add(V2,1,1);
        Layout.add(Res,1,2);
        Layout.add(Sumar,2,0);
        Sumar.setOnAction(event -> {
            int Va1= Integer.valueOf(V1.getText());
            int Va2= Integer.valueOf(V2.getText());
            int R = Va1 +Va2;
            Res.setText(String.valueOf(R));
        });
        Layout.add(Restar,2,1);
        Restar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int Va1= Integer.valueOf(V1.getText());
                int Va2= Integer.valueOf(V2.getText());
                int R= Va1-Va2;
                Res.setText(String.valueOf(R));
            }
        });
        Layout.add(Multiplicar,3,0);
        Multiplicar.setOnAction(event -> {
            int Va1= Integer.valueOf(V1.getText());
            int Va2= Integer.valueOf(V2.getText());
            int R= Va1*Va2;
            Res.setText(String.valueOf(R));
        });
        Layout.add(Borrar,2,2);
        Borrar.setOnAction(event -> {
            Res.setText("");
            V1.setText("");
            V2.setText("");
        });

        Layout.setVgap(5);
        Layout.setHgap(5);
        //Escena
        Scene Escena = new Scene(Layout);
        primaryStage.setTitle("Le Calculete");
        primaryStage.setScene(Escena);
        primaryStage.show();

    }
}
