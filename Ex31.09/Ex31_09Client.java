/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex31_09client;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jlmcc
 */
public class Ex31_09Client extends Application {
    
    public TextArea clientReceive = new TextArea();
    public TextField clientSend = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(5,5,5,5));
        vBox.setSpacing(5);
        
        Label labelRec = new Label("Received:");
        Label labelSend = new Label("Send:");
  
        vBox.getChildren().addAll(labelRec, clientReceive, labelSend, clientSend);
        new Thread(() -> {
            while(true){
                try{
                    Socket socket = new Socket("localhost", 8000);
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
                    Platform.runLater(() -> {
                        try{
                            out.writeChars("Test");
                            osw.write("Test 2");
                            setText(br.readLine());
                            String read = in.readUTF();
                            setText(read);  
                        }
                        catch(IOException ex){
                            ex.printStackTrace();
                        }
                    });
                    
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }).start();

        Scene scene = new Scene(vBox, 450, 550);
        
        primaryStage.setTitle("Exercise 31.9 Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
    
    public void setText(String text){
        clientReceive.setText(text);
    }
}
