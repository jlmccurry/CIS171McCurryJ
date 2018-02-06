package ex14.pkg7;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jlmcc
 */
public class Ex147 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(1,1,1,1));
        // Iterate through integer i 10 times to create 10 "rows"
        for(int i = 0; i < 10; i++){
            // Iterate through integer j 10 times to create 10 "columns"
            for(int j = 0; j < 10; j++){
                // Generate a 0 or 1 randomly
                Random random = new Random();
                int k = random.nextInt(2);
                // Create a new textfield with a value equal to the random integer
                TextField rando = new TextField(String.valueOf(k));
                // Center the alignment of the textfield and add each text field sequentially to the pane
                rando.setAlignment(Pos.CENTER);
                pane.add(rando, i, j);
                
            }
        }
        
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Exercise 14.7 - Random Numbers");
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
