package ru.novikov.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.awt.event.MouseEvent;

public class Controller {

    @FXML
    private TextField mBlud, mChash, mChashAndObr, procOpen, drySubs, mDry,
            calcDrySubs, zola, aminCarbo, jMd, pJ, sMd, aminUmd, kmd, sF, jF, aminUf, kF;
    @FXML
    private Button  calc, insertData, clear, exit;

    @FXML
    private ImageView secret;

    @FXML
    public void insertDataAct(ActionEvent event){

    }
    @FXML
    public void calcAct(ActionEvent event){

    }
    @FXML
    public void clearAct(ActionEvent event){

    }

    @FXML
    public void secretAct (ActionEvent event){
    }

    @FXML
    public void exitAct(ActionEvent event){
        System.exit(0);
    }
}
