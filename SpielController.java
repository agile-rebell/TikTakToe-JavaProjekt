package com.example.tiktaktoealsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;

public class SpielController {
    @FXML
    Button button1;

    Parent root, root2;
    Stage stage, stage2;
    Scene scene, scene2;
    Boolean spieler2istdran = true;

    @FXML
    Button tiktak1, tiktak2, tiktak3, tiktak4, tiktak5, tiktak6, tiktak7, tiktak8, tiktak9;
    @FXML
    Pane pane;

    List <Button> buttonListe = new ArrayList<>();

    public void initialsiereButtons() {
        buttonListe.add(tiktak1);
        buttonListe.add(tiktak2);
        buttonListe.add(tiktak3);
        buttonListe.add(tiktak4);
        buttonListe.add(tiktak5);
        buttonListe.add(tiktak6);
        buttonListe.add(tiktak7);
        buttonListe.add(tiktak8);
        buttonListe.add(tiktak9);
    }
    public void verhindereGewinn (Button b1, Button b2, Button b3){
        if (b1.getText().equals("X") && b2.getText().equals("X")){
            b3.setText("o");
        }
    }
    public void setzeGewinn (Button b1, Button b2, Button b3){
        if (b1.getText().equals("o") && b2.getText().equals("o")){
            b3.setText("o");
        }
    }
    public void setzeFeldZufällig(){
        Random setzeStein = new Random();
        int i = setzeStein.nextInt(0,9);
        if ((buttonListe.get(i).getText().equals(" "))) {
            buttonListe.get(i).setText("o");
        }
    }
    public void setzeFeld1gegen1 (Button b1){
        if (b1.getText().isEmpty()) {
            if (spieler2istdran) {
                b1.setText("X");
                b1.setTextFill(Color.BLUE);
                spieler2istdran = false;
            } else {
                b1.setText("o");
                b1.setTextFill(Color.RED);
                spieler2istdran = true;
            }
        }
    }

    public boolean gewinnBedingungenprüfen(Button b1, Button b2, Button b3, String symbol){
        if (b1.getText().equals(symbol) && b2.getText().equals(symbol) && b3.getText().equals(symbol)){
            return true;
        }
        return false;
    }
    public void gameOver(ActionEvent e) throws IOException {
        FXMLLoader laden = new FXMLLoader(getClass().getResource("spielVorbei.fxml"));
        root2 = laden.load();

        stage2 = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene2 = new Scene(root2);
        stage2.setScene(scene2);
        stage2.show();
    }

    @FXML
    public void onSpielAbbrechenClick (ActionEvent e) throws IOException {
    FXMLLoader laden = new FXMLLoader(getClass().getResource("spielAbbrechen.fxml"));
    root = laden.load();

    stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
    @FXML
    public void tiktak1SetzeStein(ActionEvent e) throws IOException {
            setzeFeld1gegen1(tiktak1);
            if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
                gameOver(e);
            }
    }
    @FXML
    public void tiktak2SetzeStein(ActionEvent e) throws IOException {
            setzeFeld1gegen1(tiktak2);
            if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
                gameOver(e);
            }
    }
    @FXML
    public void tiktak3SetzeStein(ActionEvent e) throws IOException {
            setzeFeld1gegen1(tiktak3);
            if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
                gameOver(e);
            }
    }
    @FXML
    public void tiktak4SetzeStein(ActionEvent e) throws IOException {
            setzeFeld1gegen1(tiktak4);
            if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
                gameOver(e);
            }

    }
    @FXML
    public void tiktak5SetzeStein(ActionEvent e) throws IOException {
        setzeFeld1gegen1(tiktak5);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak6SetzeStein(ActionEvent e) throws IOException {
        setzeFeld1gegen1(tiktak6);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak7SetzeStein(ActionEvent e) throws IOException {
        setzeFeld1gegen1(tiktak7);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak8SetzeStein(ActionEvent e) throws IOException {
        setzeFeld1gegen1(tiktak8);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak9SetzeStein(ActionEvent e) throws IOException {
        setzeFeld1gegen1(tiktak9);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }

    public boolean prüfeGewinnbedingungen() {
      if(gewinnBedingungenprüfen(tiktak1, tiktak2, tiktak3, "X")||
              gewinnBedingungenprüfen(tiktak1, tiktak2, tiktak3, "o")||
              gewinnBedingungenprüfen(tiktak4, tiktak5, tiktak6, "X")||
              gewinnBedingungenprüfen(tiktak4, tiktak5, tiktak6, "o")||
              gewinnBedingungenprüfen(tiktak7, tiktak8, tiktak9, "X")||
              gewinnBedingungenprüfen(tiktak7, tiktak8, tiktak9, "o")||
              gewinnBedingungenprüfen(tiktak1, tiktak4, tiktak7, "X")||
              gewinnBedingungenprüfen(tiktak1, tiktak4, tiktak7, "o")||
              gewinnBedingungenprüfen(tiktak2, tiktak5, tiktak8, "X")||
              gewinnBedingungenprüfen(tiktak2, tiktak5, tiktak8, "o")||
              gewinnBedingungenprüfen(tiktak3, tiktak6, tiktak9, "X")||
              gewinnBedingungenprüfen(tiktak3, tiktak6, tiktak9, "o")||
              gewinnBedingungenprüfen(tiktak1, tiktak5, tiktak9, "X")||
              gewinnBedingungenprüfen(tiktak1, tiktak5, tiktak9, "o")||
              gewinnBedingungenprüfen(tiktak3, tiktak5, tiktak7, "X")||
              gewinnBedingungenprüfen(tiktak3, tiktak5, tiktak7, "o")){
          return true;
      }
      return false;
    }
    public boolean spielIstUnentschieden(){
        initialsiereButtons();
        for (Button button : buttonListe){
            if (button.getText().equals(" ")){
                return false;
            }
        }
        return true;
    }

    public void setzeFeldKiLeicht(){
        initialsiereButtons();
        setzeFeldZufällig();
    }

    public void setzeFeldKiMittel(){
        initialsiereButtons();
        verhindereGewinn(tiktak1, tiktak2, tiktak3);
        verhindereGewinn(tiktak2, tiktak3, tiktak1);
        verhindereGewinn(tiktak1, tiktak3, tiktak2);
        verhindereGewinn(tiktak4, tiktak5, tiktak6);
        verhindereGewinn(tiktak4, tiktak6, tiktak5);
        verhindereGewinn(tiktak5, tiktak6, tiktak4);
        verhindereGewinn(tiktak7, tiktak8, tiktak9);
        verhindereGewinn(tiktak8, tiktak9, tiktak7);
        verhindereGewinn(tiktak9, tiktak7, tiktak8);
        verhindereGewinn(tiktak1, tiktak4, tiktak7);
        verhindereGewinn(tiktak4, tiktak7, tiktak1);
        verhindereGewinn(tiktak1, tiktak7, tiktak4);
        verhindereGewinn(tiktak2, tiktak5, tiktak8);
        verhindereGewinn(tiktak2, tiktak8, tiktak5);
        verhindereGewinn(tiktak5, tiktak8, tiktak2);
        verhindereGewinn(tiktak3, tiktak6, tiktak9);
        verhindereGewinn(tiktak6, tiktak9, tiktak3);
        verhindereGewinn(tiktak3, tiktak9, tiktak6);
        verhindereGewinn(tiktak1, tiktak5, tiktak9);
        verhindereGewinn(tiktak1, tiktak9, tiktak5);
        verhindereGewinn(tiktak5, tiktak9, tiktak1);
        verhindereGewinn(tiktak3, tiktak5, tiktak7);
        verhindereGewinn(tiktak7, tiktak5, tiktak3);
        verhindereGewinn(tiktak7, tiktak3, tiktak5);
        setzeGewinn(tiktak1, tiktak2, tiktak3);
        setzeGewinn(tiktak2, tiktak3, tiktak1);
        setzeGewinn(tiktak1, tiktak3, tiktak2);
        setzeGewinn(tiktak4, tiktak5, tiktak6);
        setzeGewinn(tiktak4, tiktak6, tiktak5);
        setzeGewinn(tiktak5, tiktak6, tiktak4);
        setzeGewinn(tiktak7, tiktak8, tiktak9);
        setzeGewinn(tiktak8, tiktak9, tiktak7);
        setzeGewinn(tiktak9, tiktak7, tiktak8);
        setzeGewinn(tiktak1, tiktak4, tiktak7);
        setzeGewinn(tiktak4, tiktak7, tiktak1);
        setzeGewinn(tiktak1, tiktak7, tiktak4);
        setzeGewinn(tiktak2, tiktak5, tiktak8);
        setzeGewinn(tiktak2, tiktak8, tiktak5);
        setzeGewinn(tiktak5, tiktak8, tiktak2);
        setzeGewinn(tiktak3, tiktak6, tiktak9);
        setzeGewinn(tiktak6, tiktak9, tiktak3);
        setzeGewinn(tiktak3, tiktak9, tiktak6);
        setzeGewinn(tiktak1, tiktak5, tiktak9);
        setzeGewinn(tiktak1, tiktak9, tiktak5);
        setzeGewinn(tiktak5, tiktak9, tiktak1);
        setzeGewinn(tiktak3, tiktak5, tiktak7);
        setzeGewinn(tiktak7, tiktak5, tiktak3);
        setzeGewinn(tiktak7, tiktak3, tiktak5);
        setzeFeldZufällig();
    }
    public void setzeFeldKiSchwer(){
        initialsiereButtons();


    }
    public void setzeFeldAufSchwierigkeitsgradLeicht (Button b1){
        if (b1.getText().isEmpty()) {
            if (spieler2istdran) {
                b1.setText("X");
                b1.setTextFill(Color.BLUE);
                spieler2istdran = false;
            } else {
                setzeFeldKiLeicht();
                b1.setTextFill(Color.RED);
                spieler2istdran = true;
            }
        }
    }
    public void setzeFeldAufSchwierigkeitsgradMittel (Button b1){
        if (b1.getText().isEmpty()) {
            if (spieler2istdran) {
                b1.setText("X");
                b1.setTextFill(Color.BLUE);
                spieler2istdran = false;
            } else {
                setzeFeldKiMittel();
                b1.setTextFill(Color.RED);
                spieler2istdran = true;
            }
        }
    }
    public void setzeFeldAufSchwierigkeitsgradSchwer (Button b1) {
        if (b1.getText().isEmpty()) {
            if (spieler2istdran) {
                b1.setText("X");
                b1.setTextFill(Color.BLUE);
                spieler2istdran = false;
            } else {
                setzeFeldKiSchwer();
                b1.setTextFill(Color.RED);
                spieler2istdran = true;
            }
        }
    }
    @FXML
    public void tiktak1SetzeSteinLeicht(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradLeicht(tiktak1);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak2SetzeSteinLeicht(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradLeicht(tiktak2);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak3SetzeSteinLeicht(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradLeicht(tiktak3);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak4SetzeSteinLeicht(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradLeicht(tiktak4);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak5SetzeSteinLeicht(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradLeicht(tiktak5);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak6SetzeSteinLeicht(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradLeicht(tiktak6);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak7SetzeSteinLeicht(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradLeicht(tiktak7);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak8SetzeSteinLeicht(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradLeicht(tiktak8);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak9SetzeSteinLeicht(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradLeicht(tiktak9);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak1SetzeSteinMittel(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradMittel(tiktak1);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak2SetzeSteinMittel(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradMittel(tiktak2);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak3SetzeSteinMittel(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradMittel(tiktak3);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak4SetzeSteinMittel(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradMittel(tiktak4);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak5SetzeSteinMittel(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradMittel(tiktak5);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak6SetzeSteinMittel(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradMittel(tiktak6);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak7SetzeSteinMittel(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradMittel(tiktak7);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak8SetzeSteinMittel(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradMittel(tiktak8);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }
    @FXML
    public void tiktak9SetzeSteinMittel(ActionEvent e) throws IOException {
        setzeFeldAufSchwierigkeitsgradMittel(tiktak9);
        if (prüfeGewinnbedingungen() || spielIstUnentschieden()) {
            gameOver(e);
        }
    }


}
