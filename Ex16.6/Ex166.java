package ex166;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jlmcc
 */
public class Ex166 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5,5,5,5));
        
        ControlPane ctrlPane = new ControlPane();
        
        // Create a new text field
        TextField txtFld1 = ctrlPane.newTextField();
        Label lbl1 = ctrlPane.newLabel("Text Field", txtFld1);
        pane.setTop(lbl1);
        
        // Create a hbox for the bottom pane
        HBox hbox = ctrlPane.getHBox();
        
        // Create a togglegroup, the radio buttons, and add them to hbox and group
        ToggleGroup group = new ToggleGroup();
        RadioButton rdBtn1 = ctrlPane.newRdoBtn();
        Label lbl2 = ctrlPane.newLabel("Left", rdBtn1);
        RadioButton rdBtn2 = ctrlPane.newRdoBtn();
        Label lbl3 = ctrlPane.newLabel("Center", rdBtn2);
        RadioButton rdBtn3 = ctrlPane.newRdoBtn();
        Label lbl4 = ctrlPane.newLabel("Right", rdBtn3);
        rdBtn1.setToggleGroup(group);
        rdBtn2.setToggleGroup(group);
        rdBtn3.setToggleGroup(group);
        
        // Create a second text field for column width
        TextField txtFld2 = ctrlPane.newTextField();
        Label lbl5 = ctrlPane.newLabel("Column Size", txtFld2);
        txtFld2.setPrefWidth(80);
        
        // If "Left" is selected, set the textfield alignment
        // If column size textfield is not blank, set the textfield width to it's value
        rdBtn1.setOnAction(e -> {
            if (rdBtn1.isSelected()) {
                txtFld1.setAlignment(Pos.BASELINE_LEFT);
                
                // if "column size" isn't null, get it's value and set the text field width to the value
                if (!txtFld2.getText().isEmpty()){
                    double size = Double.parseDouble(txtFld2.getText());
                    txtFld1.setPrefWidth(size);
                }
            }
        });
        
        // If "Left" is selected, set the textfield alignment
        // If column size textfield is not blank, set the textfield width to it's value
        rdBtn2.setOnAction(e -> {
            if (rdBtn2.isSelected()) {
                txtFld1.setAlignment(Pos.BASELINE_CENTER);
            }
            
            if (!txtFld2.getText().isEmpty()){
                double size = Double.parseDouble(txtFld2.getText());
                txtFld1.setPrefWidth(size);
            }
        });
        
        // If "Left" is selected, set the textfield alignment
        // If column size textfield is not blank, set the textfield width to it's value
        rdBtn3.setOnAction(e -> {
            if (rdBtn3.isSelected()) {
                txtFld1.setAlignment(Pos.BASELINE_RIGHT);
            }
            
            if (!txtFld2.getText().isEmpty()){
                double size = Double.parseDouble(txtFld2.getText());
                txtFld1.setPrefWidth(size);
            }
        });
        
        hbox.getChildren().addAll(lbl2,lbl3,lbl4,lbl5);
        
        pane.setBottom(hbox);
        
        Scene scene = new Scene(pane, 400, 120);
        
        primaryStage.setTitle("Exercise 16.6");
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
