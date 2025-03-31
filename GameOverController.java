package com.example.tiktaktoealsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController {
    @FXML
    Button ja;
    @FXML
    Button nein;

    Parent root;
    Stage stage;
    Scene scene;

    public void onYesButtonClick (ActionEvent e) throws IOException {
        FXMLLoader laden = new FXMLLoader(getClass().getResource("einloggen.fxml"));
        root = laden.load();

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onNoButtonClick (){
        System.exit(0);
    }

}
