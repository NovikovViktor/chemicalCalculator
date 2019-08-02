package ru.novikov.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import ru.novikov.java.Calculator;
import ru.novikov.java.Tools;

import java.math.BigDecimal;

public class Controller {

    public Calculator data = new Calculator();
    private Tools tools = new Tools();

    @FXML
    private TextField mBlud, mChash, mChashAndObr, procOpen, drySubs, mDry, density, salt,
            calcDrySubs, zola, aminCarbo, jMd, pJ, sMd, aminUmd, kmd, sF, jF, aminUf, kF;
    @FXML
    private Button calc, insertData, clear, exit;

    @FXML
    private ImageView secret;

    @FXML
    public void insertDataAct(ActionEvent event) {

        String drySubsStr = drySubs.getText().trim().replaceAll("[^\\d.]", "");
        String mDryStr = mDry.getText().trim().replaceAll("[^\\d.]", "");

        if(drySubsStr.equals("") || mDryStr.equals("")){
            tools.alertEmptyCell();
            return;
        }
        data.getDrySubsList().add(
                BigDecimal.valueOf(
                        Double.parseDouble(
                                drySubsStr.replaceAll(",","."))));
        data.getMDryList().add(
                BigDecimal.valueOf(
                        Double.parseDouble(
                                mDryStr.replaceAll(",","."))));
        drySubs.setText("");
        mDry.setText("");
    }

    @FXML
    public void calcAct(ActionEvent event) {

    }

    @FXML
    public void clearAct(ActionEvent event) {
        data.getMDryList().clear();
        data.getDrySubsList().clear();
        tools.alertClearList();
    }

    @FXML
    public void secretAct(ActionEvent event) {
    }

    @FXML
    public void exitAct(ActionEvent event) {
        System.exit(0);
    }
}
