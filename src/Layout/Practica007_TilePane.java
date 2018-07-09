package Layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Practica007_TilePane extends Application {
    public static void main(String[]args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane Layout = new TilePane();
        Layout.setPrefColumns(3);
        Layout.setPrefRows(2);

        for (int i=0;i<9;i++){
            Layout.getChildren().add(new Button(""+i));}
            Scene Escena = new Scene(Layout);
        primaryStage.setScene(Escena);
        primaryStage.show();

    }
}
