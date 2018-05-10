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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author jlmcc
 */
public class Ex247 extends Application {
    public LinkedList<Integer> list = new LinkedList<>();
    private LinkedListView view = new LinkedListView();
    private LinkedList<Integer> workList = new LinkedList();
    private TextField txtFldIndex = new TextField();
    private TextField txtFldValue = new TextField();
    private Label txtIndex = new Label("Index", txtFldIndex);
    private Label txtValue = new Label("Value", txtFldValue);
    private Button btnDelete = new Button("Delete");
    private Button btnInsert = new Button("Insert");
    private Button btnSearch = new Button("Search");
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        HBox hbox = new HBox();
        pane.setPadding(new Insets(5,5,5,5));
        hbox.setPadding(new Insets(5,5,5,5));
        hbox.setAlignment(Pos.CENTER);
        pane.setCenter(view);
        pane.setBottom(hbox);

        txtFldIndex.setPrefWidth(100);
        txtFldValue.setPrefWidth(100);
        txtIndex.setContentDisplay(ContentDisplay.RIGHT);
        txtValue.setContentDisplay(ContentDisplay.RIGHT);
        
  
        hbox.getChildren().addAll(txtIndex, txtValue, btnDelete, btnInsert, btnSearch);
        
        btnDelete.setOnAction(e -> {
            if(!list.contains(Integer.parseInt(txtValue.getText()))){
                System.out.println("Key not found in list");
            }
            else{
                list.remove(new Integer(Integer.parseInt(txtValue.getText())));
                view.repaint();
            }
        });
        
        btnInsert.setOnAction(e -> {
            if(!txtFldIndex.getText().trim().isEmpty() && !txtFldValue.getText().trim().isEmpty()){
                list.add(Integer.parseInt(txtFldIndex.getText()), Integer.parseInt(txtFldValue.getText()));
                view.repaint();
            }
        });
        
        btnSearch.setOnAction(e -> {
            if(!list.contains(Integer.parseInt(txtValue.getText()))){
                System.out.println("Key not found in list");
            }
            else{
                System.out.println("Key is present in the list");
                view.repaint();
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
    
    public class LinkedListView extends Pane {
        private int startX = 20;
        private int startY = 20;
        private int contWidth = 50;
        private int contHeight = 20;
        private int lineLength = 30;
        private int hGap = 80;
        
        protected void repaint() {
            getChildren().clear();
            if(list.size() == 0){
                getChildren().add(new Text(startX, startY, "head: null"));
                getChildren().add(new Text(startX, startY + 15, "tail: null"));
            }
            else{
                getChildren().add(new Text(startX, startY, "head"));
                int x = startX + 30;
                int y = startY + 20;
                drawLine(startX + 5, startY, x, y);
                for(int i = 0; i < list.size(); i++){
                    Rectangle box = new Rectangle(x, y, contWidth, contHeight);
                    box.setFill(Color.WHITE);
                    box.setStroke(Color.BLACK);
                    getChildren().add(box);
                    getChildren().add(new Line(x + lineLength, y, x + lineLength, y + contHeight));
                    
                    if(i < list.size() - 1){
                        drawLine(x + 40, y + contHeight / 2, x + hGap, y + contHeight / 2);
                        getChildren().add(new Text(x + 10, y + 15, list.get(i) + ""));
                        x = x + hGap;
                    }
                }
                getChildren().add(new Text(x, startY, "tail"));
                drawLine(x, startY, x = hGap, y);
                
            }
        }
        
        public void drawLine(double x1, double y1, double x2, double y2){
            getChildren().add(new Line(x1, y1, x2, y2));
            double slope = ((((double) y1) - (double) y2)) / ((((double) x1) - (((double) x2))));
            double arc = Math.atan(slope);
            double set45 = 1.57 / 2;
            if(x1 < x2){
                set45 = -1.57 * 1.5;
            }
            int arrLen = 15;
            getChildren().add(new Line(x2, y2, (x2 + (Math.cos(arc + set45) * arrLen)), ((y2)) + (Math.sin(arc + set45) * arrLen)));
            getChildren().add(new Line(x2, y2, (x2 + (Math.cos(arc - set45) * arrLen)), ((y2)) + (Math.sin(arc - set45) * arrLen)));
        }
    }   
}
