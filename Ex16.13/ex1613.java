package ex1613;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jlmcc
 */
public class Ex1613 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ControlPane ctrlPane = new ControlPane();
        ComputeLoan cmpLoan = new ComputeLoan();
        
        //Create a group, HBox, and StackPane, then add to group
        VBox vbox = new VBox();
        HBox hbox = ctrlPane.getHBox();
        hbox.setPadding(new Insets(5,5,5,5));
        StackPane pane = ctrlPane.getStackPane();
        pane.setPadding(new Insets(5,5,5,5));
        vbox.getChildren().addAll(hbox,pane);
               
        //Create Loan Amount label/text field
        TextField txtFld1 = ctrlPane.newTextField();
        Label lbl1 = ctrlPane.newLabel("Loan Amount", txtFld1);
        hbox.getChildren().add(lbl1);
        
        //Create Number of Years label/text field
        TextField txtFld2 = ctrlPane.newTextField();
        txtFld2.setPrefWidth(40);
        Label lbl2 = ctrlPane.newLabel("Number of Years", txtFld2);
        hbox.getChildren().add(lbl2);
        
        //Create a button
        Button btn1 = ctrlPane.newButton("Show Table");
        hbox.getChildren().add(btn1);
        
        //Create a DescriptionPane
        TextArea textArea = new TextArea();
        pane.getChildren().add(textArea);
        
        Scene scene = new Scene(vbox, 550, 275);
        
        btn1.setOnAction(e -> {
            //set the interest to 5%
            cmpLoan.setInterest(5.00);
            String txtFldStr1 = txtFld1.getText();
            String txtFldStr2 = txtFld2.getText();
            if(!txtFld1.getText().isEmpty() && !txtFld2.getText().isEmpty()){
                if(cmpLoan.getInterest() >= 5 || cmpLoan.getInterest() <= 8){
                    //get the values user set as loan amount and number of years
                    Double txt1 = Double.parseDouble(txtFld1.getText());
                    Double txt2 = Double.parseDouble(txtFld2.getText());
                    //compute the numbers
                    cmpLoan.ComputeLoan(txt1, txt2);
                    //for each index in the list paymentsList, display the relevant values
                    int paySize = cmpLoan.getPaymentList().size();
                    textArea.setText("Interest Rate" + "\t\t" + "Monthly Payment" + "\t\t" + "Total Payment");
                    for (int i = 0; i < paySize; i++){
                        textArea.setText(textArea.getText() + "\n" + cmpLoan.getInterestList(i) + "\t\t\t\t" + cmpLoan.getPaymentList(i) + "\t\t\t\t" + cmpLoan.getAddedInterestList(i));
                    }
                }
            }
        });
        
        primaryStage.setTitle("Exercise 16.13");
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
