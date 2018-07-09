//Practica uno Layout en Pila.
package Layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Practica001_StackPane extends Application {
    public static void main(String[]args){
        launch(args);
    }
//Interfaz
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button Boton = new Button("Click Aqui");
        Label Etiqueta = new Label("Buen Dia") ;
        Rectangle  Rectangulo = new Rectangle(300,200,Color.CYAN);
//Panel
        StackPane Layout = new StackPane();
            Layout.getChildren().add(Rectangulo);
            Layout.getChildren().add(Boton);
            Layout.getChildren().add(Etiqueta);
        //Direcciones
            Layout.setAlignment(Rectangulo, Pos.TOP_LEFT);
            Layout.setAlignment(Etiqueta, Pos.BOTTOM_CENTER);
//Mostrar Interfaz
        Scene Escena = new Scene(Layout, 300, 200);
            primaryStage.setScene(Escena);
            primaryStage.show();

    }
}
