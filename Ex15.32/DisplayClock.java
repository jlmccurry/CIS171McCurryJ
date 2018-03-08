/// good use of class, inheritance and methods
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class DisplayClock extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    
    // Create a clock    
    ClockPane clock = new ClockPane();
   
    // Create a Start and Stop button
    Button btnStart = new Button("Start");
    Button btnStop = new Button("Stop");

    // Place clock and label in border pane
    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    
    // Create a HBox at bottom of pane
    HBox hbox = new HBox(2);
    hbox.setAlignment(Pos.CENTER);
    hbox.getChildren().addAll(btnStart,btnStop);
    pane.setBottom(hbox); 
    
    // Listen for a button click and stop/start animation
    btnStart.setOnAction(e -> clock.Start());
    btnStop.setOnAction(e -> clock.Stop());
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("DisplayClock"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
