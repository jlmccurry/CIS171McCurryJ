package exam2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static javax.swing.text.StyleConstants.Background;

/**
 *
 * @author jlmcc
 */
public class Exam2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Create a gridpane, set padding, and define column constraints
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5,5,5,5));
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(75);
        
        // Create a textfield and set it in the right column, first row
        TextField txtFld1 = new TextField();
        txtFld1.setAlignment(Pos.CENTER_RIGHT);
        pane.setConstraints(txtFld1, 1, 0);
        
        // Create a label and set it in the left column, first row
        Label lbl1 = new Label("US Dollars");
        pane.setConstraints(lbl1, 0, 0);
        pane.getChildren().addAll(lbl1, txtFld1);
        
        // Create a textfield and set it in the right column, second row
        TextField txtFld2 = new TextField();
        txtFld2.setAlignment(Pos.CENTER_RIGHT);
        txtFld2.setEditable(false);
        pane.setConstraints(txtFld2, 1, 1);
        
        // Create a label and set it in the left column, second row
        Label lbl2 = new Label("Canadian Dollars");
        pane.setConstraints(lbl2, 0, 1);
        pane.getChildren().addAll(lbl2, txtFld2);
        
        // Create a button in the right column, third row
        Button btn1 = new Button("Convert");
        pane.setConstraints(btn1, 1, 3);
        GridPane.setHalignment(btn1, HPos.RIGHT);
        pane.getChildren().add(btn1);
        
        // If the button is pressed and if the value in the textfield is a number and if it's not empty, multiply the value times 1.5 and populate the canadian textfield
        btn1.setOnAction(e -> {
            if(txtFld1.getText().matches("\\d{0,9}")){
                if(!txtFld1.getText().isEmpty()){
                    double usDollar = Double.parseDouble(txtFld1.getText());
                    double canDollar = usDollar * 1.5;
                    String format = String.format("%.2f", canDollar);
                    txtFld2.setText(format);
                }
            }
        });
        
        Scene scene = new Scene(pane, 310, 100);

        primaryStage.setTitle("Exam 2");
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
