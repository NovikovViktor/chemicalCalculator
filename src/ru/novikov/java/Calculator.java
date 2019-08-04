package ru.novikov.java;


import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Data
public class Calculator {

    //in value
    private BigDecimal mBlud = BigDecimal.ZERO;
    private BigDecimal mChash = BigDecimal.ZERO;
    private BigDecimal mChashAndObr = BigDecimal.ZERO;
    private BigDecimal procOpen = BigDecimal.ZERO;
    private BigDecimal density = BigDecimal.ZERO;
    private BigDecimal salt = BigDecimal.ZERO;
    private BigDecimal buterometr = BigDecimal.ZERO;
    private List<BigDecimal> drySubsList = new ArrayList<>();
    private List<BigDecimal> mDryList = new ArrayList<>();
    private List<BigDecimal> fatList = new ArrayList<>();
    private List<BigDecimal> caloriesList = new ArrayList<>();

    //calc value
    private BigDecimal calcDrySubs = BigDecimal.ZERO;
    private BigDecimal zola = BigDecimal.ZERO;
    private BigDecimal sumDry = BigDecimal.ZERO;
    private BigDecimal sumDryWithSalt = BigDecimal.ZERO;
    private BigDecimal sumFat = BigDecimal.ZERO;
    private BigDecimal sumCalories = BigDecimal.ZERO;
    private BigDecimal aminCarbo = BigDecimal.ZERO;
    private BigDecimal jMd = BigDecimal.ZERO;
    private BigDecimal pJ = BigDecimal.ZERO;
    private BigDecimal sMd = BigDecimal.ZERO;
    private BigDecimal aminUmd = BigDecimal.ZERO;
    private BigDecimal kmd = BigDecimal.ZERO;
    private BigDecimal sF = BigDecimal.ZERO;
    private BigDecimal jF = BigDecimal.ZERO;
    private BigDecimal aminUf = BigDecimal.ZERO;
    private BigDecimal kF = BigDecimal.ZERO;

    private List<BigDecimal> sumDryList = new ArrayList<>();
    private List<BigDecimal> sumFatList = new ArrayList<>();
    private List<BigDecimal> sumCaloriesList = new ArrayList<>();

    public void calculate(){

        calcDrySubs = (mChash.subtract(mChashAndObr)).abs().setScale(2, RoundingMode.HALF_UP);
        zola = mBlud.multiply(density).setScale(2, RoundingMode.HALF_UP);


        for (int i=0; i<drySubsList.size(); i++){
            sumDryList.add((drySubsList.get(i).multiply(mDryList.get(i))).divide(new BigDecimal(100), RoundingMode.HALF_UP));
        }

        for (int i=0; i<drySubsList.size(); i++){
            sumFatList.add((drySubsList.get(i).multiply(fatList.get(i))).divide(new BigDecimal(100), RoundingMode.HALF_UP));
        }

        for (int i=0; i<drySubsList.size(); i++){
            sumCaloriesList.add((drySubsList.get(i).multiply(caloriesList.get(i))).divide(new BigDecimal(100), RoundingMode.HALF_UP));
        }

        for(BigDecimal el : sumDryList){
            sumDry = sumDry.add(el).setScale(2, RoundingMode.HALF_UP);
        }

        for(BigDecimal el : sumFatList){
            sumFat = sumFat.add(el).setScale(2, RoundingMode.HALF_UP);
        }

        for(BigDecimal el : sumCaloriesList){
            sumCalories = sumCalories.add(el).setScale(2, RoundingMode.HALF_UP);
        }

        sumDryWithSalt = sumDry.add(salt);
        aminCarbo = sumDry.subtract(sumFat.add(zola)).setScale(2, RoundingMode.HALF_UP);
        jMd = (sumFat.multiply(procOpen)).divide(new BigDecimal(100), RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        pJ = sumFat.subtract(jMd).setScale(2, RoundingMode.HALF_UP);
        sMd = (sumDryWithSalt.subtract(pJ)).subtract(sumDryWithSalt.multiply(new BigDecimal(0.1))).setScale(2, RoundingMode.HALF_UP);
        aminUmd = sMd.subtract(jMd.add(zola)).setScale(2, RoundingMode.HALF_UP);
        kmd = (new BigDecimal(4).multiply(aminUmd)).add(new BigDecimal(9).multiply(jMd)).setScale(2, RoundingMode.HALF_UP);
        sF = (mBlud.multiply(calcDrySubs)).divide(new BigDecimal(5), RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        jF = (new BigDecimal(0.01133).multiply(mBlud).multiply(buterometr))
                .divide(new BigDecimal(5), RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        aminUf = sF.subtract(jF.add(zola)).setScale(2, RoundingMode.HALF_UP);
        kF = new BigDecimal(4).multiply(aminUf).add(new BigDecimal(9).multiply(jF)).setScale(2, RoundingMode.HALF_UP);
    }
}
