package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class Evaluacion1 extends Application {
    char Cuenta;
    public Double V1;
    public Double V2;
    public Double Res;
    public Double Entero;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//Interfaz
    //Text
        javafx.scene.control.TextField Pantalla = new javafx.scene.control.TextField("0");
        //Botones
        javafx.scene.control.Button BotonLimpiarTodo = new javafx.scene.control.Button("Limpiar Todo");BotonLimpiarTodo.setPrefSize(100,50);
        javafx.scene.control.Button BotonLimpiar = new javafx.scene.control.Button("C");BotonLimpiar.setPrefSize(45,45);
        javafx.scene.control.Button BotonResultado = new javafx.scene.control.Button("=");BotonResultado.setPrefSize(45,45);
        javafx.scene.control.Button Punto = new javafx.scene.control.Button(".");Punto.setPrefSize(45,45);
        javafx.scene.control.Button Sumar = new javafx.scene.control.Button("+");Sumar.setPrefSize(45,45);
        javafx.scene.control.Button Restar = new javafx.scene.control.Button("-");Restar.setPrefSize(45,45);
        javafx.scene.control.Button Dividir = new javafx.scene.control.Button("/");Dividir.setPrefSize(45,45);
        javafx.scene.control.Button Multiplicar = new javafx.scene.control.Button("*");Multiplicar.setPrefSize(45,45);
        javafx.scene.control.Button Boton1 = new javafx.scene.control.Button("1");Boton1.setPrefSize(45,45);
        javafx.scene.control.Button Boton2 = new javafx.scene.control.Button("2");Boton2.setPrefSize(45,45);
        javafx.scene.control.Button Boton3 = new javafx.scene.control.Button("3");Boton3.setPrefSize(45,45);
        javafx.scene.control.Button Boton4 = new javafx.scene.control.Button("4");Boton4.setPrefSize(45,45);
        javafx.scene.control.Button Boton5 = new javafx.scene.control.Button("5");Boton5.setPrefSize(45,45);
        javafx.scene.control.Button Boton6 = new javafx.scene.control.Button("6");Boton6.setPrefSize(45,45);
        javafx.scene.control.Button Boton7 = new javafx.scene.control.Button("7");Boton7.setPrefSize(45,45);
        javafx.scene.control.Button Boton8 = new javafx.scene.control.Button("8");Boton8.setPrefSize(45,45);
        javafx.scene.control.Button Boton9 = new javafx.scene.control.Button("9");Boton9.setPrefSize(45,45);
        javafx.scene.control.Button Boton0 = new javafx.scene.control.Button("0");Boton0.setPrefSize(100,50);
        Boton0.setAlignment(Pos.CENTER);
        Boton1.setAlignment(Pos.CENTER);
        Boton2.setAlignment(Pos.CENTER);
        Boton3.setAlignment(Pos.CENTER);
        Boton4.setAlignment(Pos.CENTER);
        Boton5.setAlignment(Pos.CENTER);
        Boton6.setAlignment(Pos.CENTER);
        Boton7.setAlignment(Pos.CENTER);
        Boton8.setAlignment(Pos.CENTER);
        Boton9.setAlignment(Pos.CENTER);
        Punto.setAlignment(Pos.CENTER);
        Sumar.setAlignment(Pos.CENTER);
        Restar.setAlignment(Pos.CENTER);
        Dividir.setAlignment(Pos.CENTER);
        Multiplicar.setAlignment(Pos.CENTER);
        BotonResultado.setAlignment(Pos.CENTER);
        BotonLimpiar.setAlignment(Pos.CENTER);
        BotonLimpiarTodo.setAlignment(Pos.CENTER);
//Grafico
        GridPane Layout = new GridPane();
        Layout.setPadding(new Insets(10));
        Layout.add(Pantalla,0,0,5,1);
        Layout.add(BotonLimpiarTodo,0,1,2,1);
        BotonLimpiarTodo.setOnAction(event -> {
            Pantalla.setText("0");
        });
        Layout.add(BotonLimpiar,2,1);
        BotonLimpiar.setOnAction(event -> {

        });
        Layout.add(Dividir,3,1);
        Dividir.setOnAction(event -> {
            Cuenta ='/';
            V1 = Double.valueOf(Pantalla.getText());
            Pantalla.setText("0");
        });
        Layout.add(Boton7,0,2);
        Boton7.setOnAction(event -> {
        if (Pantalla.getText().equalsIgnoreCase("0")){
            Pantalla.setText("7");}
            else {
            Pantalla.setText(Pantalla.getText()+7);
        }
    });
        Layout.add(Boton8,1,2);
        Boton8.setOnAction(event -> {
            if (Pantalla.getText().equalsIgnoreCase("0")){
            Pantalla.setText("8");}
            else {
                Pantalla.setText(Pantalla.getText()+8);
            }
        });
        Layout.add(Boton9,2,2);
        Boton9.setOnAction(event -> {
            if(Pantalla.getText().equalsIgnoreCase("0")){
            Pantalla.setText("9");}
            else{
                Pantalla.setText(Pantalla.getText()+9);
            }
        });
        Layout.add(Multiplicar,3,2);
        Multiplicar.setOnAction(event -> {
            Cuenta ='*';
            V1 = Double.valueOf(Pantalla.getText());
            Pantalla.setText("0");
        });
        Layout.add(Boton4,0,3);
        Boton4.setOnAction(event -> {
            if(Pantalla.getText().equalsIgnoreCase("0")){
            Pantalla.setText("4");}
            else{
                Pantalla.setText(Pantalla.getText()+4);
            }
        });
        Layout.add(Boton5,1,3);
        Boton5.setOnAction(event -> {
            if(Pantalla.getText().equalsIgnoreCase("0")){
                Pantalla.setText("5");}
            else{
                Pantalla.setText(Pantalla.getText()+5);
            }
        });
        Layout.add(Boton6,2,3);
        Boton6.setOnAction(event -> {
            if(Pantalla.getText().equalsIgnoreCase("0")){
                Pantalla.setText("6");}
            else{
                Pantalla.setText(Pantalla.getText()+6);
            }
        });
        Layout.add(Restar,3,3);
        Restar.setOnAction(event -> {
                    Cuenta = '-';
                    V1 = Double.valueOf(Pantalla.getText());
                    Pantalla.setText("0");
                });
        Layout.add(Boton1,0,4);
        Boton1.setOnAction(event -> {
                    if (Pantalla.getText().equalsIgnoreCase("0")){
                        Pantalla.setText("1"); }
                        else {
                        Pantalla.setText(Pantalla.getText()+1);
                    }
                        });
        Layout.add(Boton2,1,4);
        Boton2.setOnAction(event -> {
                    if (Pantalla.getText().equalsIgnoreCase("0")){
                        Pantalla.setText("2");}
                        else {
                        Pantalla.setText(Pantalla.getText() + 2);
                    }
                        });
        Layout.add(Boton3,2,4);
        Boton3.setOnAction(event -> {
            if(Pantalla.getText().equalsIgnoreCase("0")){
                Pantalla.setText("3");}
                else
                {
                Pantalla.setText(Pantalla.getText()+3);
            }
        });
        Layout.add(Sumar,3,4);
        Sumar.setOnAction(event -> {
            Cuenta ='+';
            V1 = Double.valueOf(Pantalla.getText());
            Pantalla.setText("0");
        });
        Layout.add(Boton0,0,5,2,1);
        Boton0.setOnAction(event -> {
            if(Pantalla.getText().equalsIgnoreCase("0")){
            Pantalla.setText("0");}
            else{
                Pantalla.setText(Pantalla.getText()+0);
            }
        });
        Layout.add(Punto,2,5);
        Punto.setOnAction(event -> {
            if (Pantalla.getText().equalsIgnoreCase("0")){
            Pantalla.setText(".");}
            else{
                Pantalla.setText(Pantalla.getText());
            }
        });
        Layout.add(BotonResultado,3,5);
        BotonResultado.setOnAction(event -> {
            switch (Cuenta) {
                case '+':
                    V2 = Double.valueOf(Pantalla.getText());
                    Res = V1 + V2;
                    Pantalla.setText(String.valueOf(Res));
                    break;
            }
            switch (Cuenta) {
                case'*':
                    V2 = Double.valueOf(Pantalla.getText());
                    Res = V1*V2;
                    Pantalla.setText(String.valueOf(Res));
                    break;
            }
            switch (Cuenta) {
                case'-':
                    V2 = Double.valueOf(Pantalla.getText());
                    Res = V1-V2;
                    Pantalla.setText(String.valueOf(Res));
                    break;
            }
            switch (Cuenta) {
                case'/':
                    V2 = Double.valueOf(Pantalla.getText());
                    Res = V1/V2;
                    Pantalla.setText(String.valueOf(Res));
                    break;
            }
        });
        Layout.setVgap(10);
        Layout.setHgap(10);
        //Escena
        Scene Escena = new Scene(Layout);
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(Escena);
        primaryStage.show();
    }
}
