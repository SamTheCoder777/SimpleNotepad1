package com.example.simplenotepad1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HelloController {
    @FXML
    private MenuItem save;

    @FXML
    private MenuItem delete;

    @FXML
    private MenuItem about;

    @FXML
    private TextArea textArea;

    private String text;

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

    public void onDelete(){
        textArea.clear();
    }

    public void onAbout(){
        try {
            java.awt.Desktop.getDesktop().browse(new URL("https://github.com/SamTheCoder777/SimpleNotepad1").toURI());
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}