package ex1529;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author jlmcc
 */
public class Ex1529 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    HBox hbox = new HBox(5);
    Button btnPause = new Button("Pause");
    Button btnResume = new Button("Resume");
    hbox.setAlignment(Pos.CENTER);
    hbox.getChildren().addAll(btnPause,btnResume);
    
    BorderPane pane = new BorderPane();
    pane.setBottom(hbox);
    
    CarPane car1 = new CarPane();
    pane.setLeft(car1);
    pane.setAlignment(car1, Pos.BOTTOM_LEFT);
    
    int duration = 10000;
    PathTransition pt = new PathTransition(Duration.millis(duration), new Line(0,280,300,280), car1);
    pt.setRate(1.0);
    pt.setCycleCount(5);
    pt.play();
    
    btnPause.setOnAction(e -> pt.pause());
    btnResume.setOnAction(e -> pt.play());
    
    pane.setOnKeyPressed(e -> {
        switch (e.getCode()){
            case RIGHT: pt.setRate(pt.getRate() + 1.0); break;
            case LEFT: pt.setRate(pt.getRate() - 1.0); break;
        }
    });
    
    Scene scene = new Scene(pane, 300, 300);
    primaryStage.setTitle("Exercise 15.29");
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

    class CarPane extends Pane {
        private double height = 300;
        private double width = 300;
        
        Group group = new Group();
        
        private Circle c1 = new Circle(5, 5, 5);
        private Circle c2 = new Circle(5, 5, 5);
        private Rectangle r = new Rectangle(40, 10);
        //-10,8,-20,16,-20,24,-10,32
        private Polygon p = new Polygon(8,0,16,-10,24,-10,32,0);
        
        public CarPane() {
            r.setStroke(Color.GREEN);
            r.setFill(Color.GREEN);
            c1.setLayoutX(8);
            c1.setLayoutY(10);
            c2.setLayoutX(24);
            c2.setLayoutY(10);
            p.setFill(Color.RED);
            getChildren().addAll(r,c1,c2,p);
        }
    }
