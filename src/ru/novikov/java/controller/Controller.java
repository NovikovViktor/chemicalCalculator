package ru.novikov.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ru.novikov.java.Calculator;
import ru.novikov.java.Tools;


public class Controller {

    public Calculator data = new Calculator();
    private Tools tools = new Tools();

    @FXML
    private TextField mBlud, mChash, mChashAndObr, procOpen, drySubs, mDry, density, salt, buterometr, calories, fat,
            calcDrySubs, zola, aminCarbo, jMd, pJ, sMd, aminUmd, kmd, sF, jF, aminUf, kF, sumCalories, sumDry, sumFat;
    @FXML
    private Button calc, insertData, clear, exit;

    @FXML
    private ImageView secret;

    @FXML
    public void insertDataAct(ActionEvent event) {

        String drySubsStr = tools.formatReplaceTrim(drySubs);
        String mDryStr = tools.formatReplaceTrim(mDry);
        String caloriesStr = tools.formatReplaceTrim(calories);
        String fatStr = tools.formatReplaceTrim(fat);

        if(drySubsStr.equals("") || mDryStr.equals("")||caloriesStr.equals("")||fatStr.equals("")){
            tools.alertEmptyCell();
            return;
        }
        data.getDrySubsList().add(tools.parseStringToBigDecimal(drySubsStr));
        data.getMDryList().add(tools.parseStringToBigDecimal(mDryStr));
        data.getCaloriesList().add(tools.parseStringToBigDecimal(caloriesStr));
        data.getFatList().add(tools.parseStringToBigDecimal(fatStr));
        drySubs.setText("");
        mDry.setText("");
        calories.setText("");
        fat.setText("");
    }

    @FXML
    public void calcAct(ActionEvent event) {

        String mBludStr = tools.formatReplaceTrim(mBlud);
        String mChashStr = tools.formatReplaceTrim(mChash);
        String mChashAndObrStr = tools.formatReplaceTrim(mChashAndObr);
        String procOpenStr = tools.formatReplaceTrim(procOpen);
        String densityStr = tools.formatReplaceTrim(density);
        String saltStr = tools.formatReplaceTrim(salt);
        String buterometrStr = tools.formatReplaceTrim(buterometr);

        if(mBludStr.equals("")||mChashStr.equals("")||mChashAndObrStr.equals("")||
                procOpenStr.equals("")||densityStr.equals("")||saltStr.equals("")||buterometrStr.equals("")){

            tools.alertEmptyCell();
            return;
        }

        data.setMBlud(tools.parseStringToBigDecimal(mBludStr));
        data.setMChash(tools.parseStringToBigDecimal(mChashStr));
        data.setMChashAndObr(tools.parseStringToBigDecimal(mChashAndObrStr));
        data.setProcOpen(tools.parseStringToBigDecimal(procOpenStr));
        data.setDensity(tools.parseStringToBigDecimal(densityStr));
        data.setSalt(tools.parseStringToBigDecimal(saltStr));
        data.setButerometr(tools.parseStringToBigDecimal(buterometrStr));

        data.calculate();

        calcDrySubs.setText(data.getCalcDrySubs().toString());
        zola.setText(data.getZola().toString());
        aminCarbo.setText(data.getAminCarbo().toString());
        jMd.setText(data.getJMd().toString());
        pJ.setText(data.getPJ().toString());
        sMd.setText(data.getSMd().toString());
        aminUmd.setText(data.getAminUmd().toString());
        kmd.setText(data.getKmd().toString());
        sF.setText(data.getSF().toString());
        jF.setText(data.getJF().toString());
        aminUf.setText(data.getAminUf().toString());
        kF.setText(data.getKF().toString());
        sumCalories.setText(data.getSumCalories().toString());
        sumFat.setText(data.getSumFat().toString());
        sumDry.setText(data.getSumDry().toString());
    }

    @FXML
    public void clearAct(ActionEvent event) {

        data.getMDryList().clear();
        data.getDrySubsList().clear();
        tools.alertClearList();
    }

    @FXML
    public void secretAct(MouseEvent event) {
        tools.alertSecret();
    }

    @FXML
    public void exitAct(ActionEvent event) {
        System.exit(0);
    }
}
