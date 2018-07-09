package Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Practica006_GridPane extends Application {
    public static void main (String [] args) {

        launch(args) ;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane Layout = new GridPane();

        Layout.add(new Button("0,3"),0,3);
        Layout.add(new Button("1,0"),1,0);
        Layout.add(new Button("2,1"),2,1);
        Layout.add(new Button("2,2"),2,2);
        Layout.setPadding(new Insets(10));
        Layout.setHgap(10);
        Layout.setVgap(10);

        Scene Escena = new Scene(Layout);
        primaryStage.setScene(Escena);
        primaryStage.show();

    }
}
