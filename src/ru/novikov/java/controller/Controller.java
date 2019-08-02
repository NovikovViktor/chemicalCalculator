package ru.novikov.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import ru.novikov.java.Calculator;
import ru.novikov.java.Tools;


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

        String drySubsStr = tools.formatReplaceTrim(drySubs);
        String mDryStr = tools.formatReplaceTrim(mDry);

        if(drySubsStr.equals("") || mDryStr.equals("")){
            tools.alertEmptyCell();
            return;
        }
        data.getDrySubsList().add(tools.parseStringToBigDecimal(drySubsStr));
        data.getMDryList().add(tools.parseStringToBigDecimal(mDryStr));
        drySubs.setText("");
        mDry.setText("");
    }

    @FXML
    public void calcAct(ActionEvent event) {

        String mBludStr = tools.formatReplaceTrim(mBlud);
        String mChashStr = tools.formatReplaceTrim(mChash);
        String mChashAndObrStr = tools.formatReplaceTrim(mChashAndObr);
        String procOpenStr = tools.formatReplaceTrim(procOpen);
        String densityStr = tools.formatReplaceTrim(density);
        String saltStr = tools.formatReplaceTrim(salt);

        if(mBludStr.equals("")||mChashStr.equals("")||mChashAndObrStr.equals("")||
                procOpenStr.equals("")||densityStr.equals("")||saltStr.equals("")){
            tools.alertEmptyCell();
            return;
        }
        data.setMBlud(tools.parseStringToBigDecimal(mBludStr));
        data.setMChash(tools.parseStringToBigDecimal(mChashStr));
        data.setMChashAndObr(tools.parseStringToBigDecimal(mChashAndObrStr));
        data.setProcOpen(tools.parseStringToBigDecimal(procOpenStr));
        data.setDensity(tools.parseStringToBigDecimal(densityStr));
        data.setSalt(tools.parseStringToBigDecimal(saltStr));

        data.calculate();
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
