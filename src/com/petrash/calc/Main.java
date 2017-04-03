package com.petrash.calc;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        CalculatorGUI c = new CalculatorGUI("Калькулятор");
        c.setVisible(true);
        c.setSize(300, 300);
        c.setResizable(false);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
