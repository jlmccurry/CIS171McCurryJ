package exam1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 *
 * @author jlmcc
 */
public class Exam1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane pane = new Pane();
        
        //create the base of the hangman
        Arc arc1 = new Arc(190,380,70,70,30,120);
        arc1.setType(ArcType.OPEN);
        arc1.setStroke(Color.BLACK);
        arc1.setFill(Color.WHITE);
        
        //create the vertical and horizontal beam, and the noose
        Line line1 = new Line(190,310,190,40);
        Line line2 = new Line(190,40,300,40);
        Line line3 = new Line(300,40,300,60);
        
        //create the head
        Circle circle1 = new Circle(300,80,25);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
        
        //create the body
        Line line4 = new Line(300,105,300,200);
        
        //create right(5) and left(6) arms
        Line line5 = new Line(300,125,235,165);
        Line line6 = new Line(300,125,365,165);
        
        //create right(7) and left(8) legs
        Line line7 = new Line(300,200,230,280);
        Line line8 = new Line(300,200,360,280);
        
        //add the shapes to the pane
        pane.getChildren().add(arc1);
        pane.getChildren().add(line1);
        pane.getChildren().add(line2);
        pane.getChildren().add(line3);
        pane.getChildren().add(circle1);
        pane.getChildren().add(line4);
        pane.getChildren().add(line5);
        pane.getChildren().add(line6);
        pane.getChildren().add(line7);
        pane.getChildren().add(line8);
        
        //create scene and call the pane
        Scene scene = new Scene(pane, 420, 350);
        
        primaryStage.setTitle("Exam 1");
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
