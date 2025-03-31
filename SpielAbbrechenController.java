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

public class SpielAbbrechenController {
    @FXML
    Button ja;
    @FXML
    Button nein;

    Parent parent;
    Stage stage;
    Scene scene;

    @FXML
    public void onJoButtonClick(ActionEvent e) throws IOException {
        FXMLLoader laden = new FXMLLoader(getClass().getResource("spiel.fxml"));
        parent = laden.load();

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onNoiButtonClick() {
        System.exit(0);
    }
}
