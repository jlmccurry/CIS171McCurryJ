/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1613;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author jlmcc
 */
public class ControlPane extends Pane {
    
    private String txtLabel;
    private Pane pane;
    private TextField txtFld;
    private int columnWidth;
    private String name;
    private String btnLabel;
    private Button btn;
    
    public ControlPane(){
        newTextField();
    }
    
    public TextField newTextField(){
        TextField txtFld1 = new TextField();
        setTextField(txtFld1);
        return txtFld;
    }
    
    public TextField getTextField(){
        return txtFld;
    }
    
    public void setTextField(TextField txtFld){
        this.txtFld = txtFld;
    }
    
    public void setColumnWidth(int columnWidth){
        this.columnWidth = columnWidth;
    }
    
    public Label newLabel(String txtLabel, TextField txtFld){
        this.txtLabel = txtLabel;
        this.txtFld = txtFld;
        Label lbl = new Label(txtLabel, txtFld);
        lbl.setContentDisplay(ContentDisplay.RIGHT);
        setLabel(txtLabel);
        return lbl;
    }
    
    public String getLabel(){
        return txtLabel;
    }
    
    public void setLabel(String txtLabel){
        this.txtLabel = txtLabel;
    }
    
    public Button newButton(String btnLabel){
        this.btnLabel = btnLabel;
        Button btn = new Button(btnLabel);
        setButton(btn);
        return(btn);
    }
    
    public void setButton(Button btn){
        this.btn = btn;
    }
    
    public HBox getHBox(){
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
    }
    
    public StackPane getStackPane(){
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER_LEFT);
        return stackPane;
    }
}
