package ru.novikov.java;


import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Calculator {

    private BigDecimal mBlud;
    private BigDecimal mChash;
    private BigDecimal mChashAndObr;
    private BigDecimal procOpen;
    private List<BigDecimal> drySubsList = new ArrayList<>();
    private List<BigDecimal> mDryList = new ArrayList<>();

    public void calculate(){

    }
}
