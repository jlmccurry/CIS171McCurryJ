package ex247;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jlmcc
 */
public class Ex247 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        VBox vbox = new VBox();
        pane.setPadding(new Insets(5,5,5,5));
        vbox.setPadding(new Insets(5,5,5,5));
        pane.setBottom(vbox);
        //vbox.setAlignment(Pos.CENTER);
        LinkedList<Integer> list = new LinkedList();
        LinkedList<Integer> workList = new LinkedList();
        
        TextField listFld = new TextField();
        pane.setCenter(listFld);
        listFld.setText(list.toString());
        
        TextField txtFld1 = new TextField();
        //Label lbl1 = new Label("Search", txtFld1);
        //lbl1.setContentDisplay(ContentDisplay.RIGHT);
        txtFld1.setPrefWidth(100);
        Button btn1 = new Button("Search");

        TextField txtFld2 = new TextField();
        //Label lbl2 = new Label("Delete", txtFld2);
        //lbl2.setContentDisplay(ContentDisplay.RIGHT);
        txtFld2.setPrefWidth(100);
        Button btn2 = new Button("Delete");
        
        TextField txtFld3 = new TextField();
        //Label lbl3 = new Label("Insert", txtFld3);
        //lbl3.setContentDisplay(ContentDisplay.RIGHT);
        txtFld3.setPrefWidth(100);
        Button btn3 = new Button("Insert");
        
        //vbox.getChildren().addAll(lbl1, btn1, lbl2, btn2, lbl3, btn3);
        vbox.getChildren().addAll(txtFld1, btn1, txtFld2, btn2, txtFld3, btn3);
        
        btn1.setOnAction(e -> {
            while(!txtFld1.getText().isEmpty()){
                String txtFldString = txtFld1.getText();
                int value = Integer.parseInt(txtFldString);
                if(list.isEmpty()){
                    System.out.println("List is empty");
                    break;
                }
                boolean search = searchList(list, value);
                if(search = false){
                    //System.out.println("Value " + value + " not found");
                    break;
                }
                if(search = true){
                    System.out.println("Value " + value + " found.");
                    System.out.println(search);
                    break;
                }
            }
            
            
            
        });
        
        btn2.setOnAction(e -> {
            while(!txtFld2.getText().isEmpty()){
                String txtFldString = txtFld2.getText();
                int value = Integer.parseInt(txtFldString);
                if(list.isEmpty()){
                    System.out.println("List is empty");
                    break;
                }
                else{
                    listFld.setText(deleteList(list, value).toString());
                }
            }
        });
        
        btn3.setOnAction(e -> {
            while(!txtFld3.getText().isEmpty()){
                String txtFldString = txtFld3.getText();
                int value = Integer.parseInt(txtFldString);

                insertList(list, value);
                listFld.setText(list.toString());
                break;
            }
        });
        
        Scene scene = new Scene(pane, 500, 450);
        
        primaryStage.setTitle("Exercise 24.7");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean searchList(LinkedList<Integer> list, Integer index){
        boolean flag = false;
        int value = index;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == value){
                flag = true;
            }
        }
        return flag;
    }
    
    public LinkedList<Integer> insertList(LinkedList<Integer> list, int value){
        list.add(value);
        return list;
    }
    
    public LinkedList<Integer> deleteList(LinkedList<Integer> list, int value){
        int checkVal = value;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == checkVal){
                list.remove(i);
            }
        }
        return list;
    }
    
    public static TextField newTextField(int value){
        String val = Integer.toString(value);
        TextField txtFld = new TextField(val);
        txtFld.setPrefWidth(70);
        return txtFld;
    }

    
}
