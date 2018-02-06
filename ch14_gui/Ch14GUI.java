package ch14gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author jlmcc
 */
public class Ch14GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new VBox(10);
        pane.setPadding(new Insets(5,5,5,5));
        ImageView imageView = new ImageView(new Image("/ocean.jpg"));
        imageView.setFitHeight(200);
        imageView.setFitWidth(250);
        pane.getChildren().add(imageView);
        
        Label ftLaud = new Label("Ft. Lauderdale, Florida");
        ftLaud.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        pane.getChildren().add(ftLaud);
        
        Button okBtn = new Button("OK");
        pane.getChildren().add(okBtn);
        
        TextField txtFld = new TextField();
        pane.getChildren().add(txtFld);
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Chapter 14 GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
