package Graphique;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by root on 5/7/17.
 */
public class game {


    public void startGame(Stage stage){


        stage.setTitle("Le Pendu ");
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 50, 50, 50));
        Label label=new Label();
        label.setText("Score");
        bp.setCenter(label);


        Scene scene = new Scene(bp);
        //scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }




}
