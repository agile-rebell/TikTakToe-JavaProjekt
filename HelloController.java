package com.example.tiktaktoealsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {
    @FXML
    TextField textfeld1, textfeld2;

    @FXML
    RadioButton radioButton1, radioButton2, radioButton3, radioButton1vs1;

    Parent root;
    Stage stage;
    Scene scene;

    public void fxmlladen (RadioButton r, String s2, ActionEvent e) throws IOException {
        if (textfeld2.getText().equals("Passwort123") && r.isSelected()){
            FXMLLoader laden = new FXMLLoader(getClass().getResource(s2));
            root = laden.load();

            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void onLoginButtonClick(ActionEvent e) throws IOException {
        fxmlladen(radioButton1vs1,  "spiel.fxml", e);
    }

    @FXML
    public void spieleAufLeicht(ActionEvent e) throws IOException {
        fxmlladen(radioButton1,  "spielgegenkileicht.fxml", e);
    }

    @FXML
    public void spieleAufMittel(ActionEvent e) throws IOException {
        fxmlladen(radioButton2, "spielgegenkimittel.fxml", e);
    }

    @FXML
    public void spieleAufSchwer(ActionEvent e) throws IOException{
        fxmlladen(radioButton3, "spielgegenkischwer.fxml", e);
    }
}