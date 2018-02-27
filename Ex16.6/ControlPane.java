/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex166;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author jlmcc
 */
public class ControlPane extends Pane {
    private String txtLabel;
    private Pane pane;
    private TextField txtFld;
    private int columnWidth;
    private RadioButton rdoBtn;
    private String name;
    
    public ControlPane(){
        newTextField();
        newRdoBtn();
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
    
    public Label newLabel(String txtLabel, RadioButton rdoBtn){
        this.txtLabel = txtLabel;
        this.rdoBtn = rdoBtn;
        Label lbl = new Label(txtLabel, rdoBtn);
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
    
    public RadioButton newRdoBtn(){
        RadioButton rdoBtn = new RadioButton();
        setRadioButton(rdoBtn);
        return rdoBtn;
    }
    
    public void setRadioButton(RadioButton rdoBtn){
        this.rdoBtn = rdoBtn;
    }
    
    public HBox getHBox(){
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
    }
    
    public VBox getVBox(){
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }
    
}
