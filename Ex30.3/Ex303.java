/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex30.pkg3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author jlmcc
 */
public class Ex303 extends Application {
    public ImageView iv = new ImageView("images/us.png");
    
    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        // Create a pane
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        
        // Add an image view and add it to the pane
        ImageView iv1 = genFlag();
        hbox.getChildren().add(iv1);
        
        ImageView iv2 = genFlag();
        hbox.getChildren().add(iv2);

        Runnable pt1 = new flagPath(iv1, 0, 0);
        Runnable pt2 = new flagPath(iv2, 300, 300);
        
        Thread thread1 = new Thread(pt1);
        Thread thread2 = new Thread(pt2);
        
        thread1.start();
        thread2.start();
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(hbox, 1000, 500);
        primaryStage.setTitle("FlagRisingAnimation"); // Set stage title
        primaryStage.setScene(scene); // Place scene in stage
        primaryStage.show(); // Display stage
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public ImageView genFlag(){
        ImageView imgView = new ImageView("images/us.png");
        return imgView;
    }
    
    public class flagPath implements Runnable{
        private PathTransition pt;
        private double y1 = 100;
        private double y2 = 300;
        
        
        
        public flagPath(ImageView iv, double x1, double x2){
            PathTransition path = new PathTransition(Duration.millis(10000),
                new Line(x1, y1, x2, y2), iv);
            this.pt = path;
            pt.setCycleCount(5);
        }
        
        @Override
        
        public void run(){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex303.class.getName()).log(Level.SEVERE, null, ex);
            }
            pt.play();
        }
    }
}
