package com.example.simplenotepad1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;

public class HelloController {
    @FXML
    private Button save;

    @FXML
    private TextArea textArea;

    public HelloController(){

    }

    @FXML
    private void initialize(){

    }

    public void onSave(){
        String text = textArea.getText().replaceAll("\n", System.getProperty("line.separator"));
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Text");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(textArea.getScene().getWindow());
        if (file != null) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(file);
                writer.println(text);
                writer.close();
            } catch (IOException ex) {
                System.out.println("");
            }
        }
    }
}