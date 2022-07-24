package com.javafee.darts.back.toBeRemoved2Calc.controller;

import com.javafee.darts.back.toBeRemoved2Calc.backCalc2.BackCalc2;
import com.javafee.darts.back.toBeRemoved2Calc.frontCalc2.FrontCalc2;
import com.javafee.darts.back.toberemove.frontCalculator.FrontCalculator;

public class ControllerCalc2 {
    FrontCalc2 frontCalc = new FrontCalc2();
    BackCalc2 backCalc = new BackCalc2();

    public void controll(){
        frontCalc.printMessage("Pass an equasion: ");
        String quasion = backCalc.getEquasionString();
    }
}
