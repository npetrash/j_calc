package com.petrash.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.BreakIterator;

public class CalculatorGUI extends JFrame{

    JTextField tfShow;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9; //цифры
    JButton bAdd, bEx, bDiv, bRem, bEq; //кнопки
    String txt = ""; //строка из поля ввода
    Double result; //переменная результата
    char operator; //оператор

    OperandClickListener l = new OperandClickListener();
    OperatorClickListener o = new OperatorClickListener();

    public CalculatorGUI(String s){ //конструктор
        super(s);
        setLayout(new FlowLayout(100));
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");


        bAdd = new JButton("+");
        bEx = new JButton("*");
        bDiv = new JButton("/");
        bRem = new JButton("-");
        bEq = new JButton("=");

        tfShow = new JTextField(25);
        tfShow.setEditable(false);
        tfShow.setSize(100, 100);

        add(tfShow);
        addAll();
    }

    private void addAll(){ //добавление элементов на jframe
        //добавим кнопки на фрейм
        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(bAdd);
        add(bEx);
        add(bDiv);
        add(bRem);
        add(bEq);

        //добавим кнопкам слушателя
        b0.addActionListener(l);
        b1.addActionListener(l);
        b2.addActionListener(l);
        b3.addActionListener(l);
        b4.addActionListener(l);
        b5.addActionListener(l);
        b6.addActionListener(l);
        b7.addActionListener(l);
        b8.addActionListener(l);
        b9.addActionListener(l);

        //добавим слушателя операторам
        bAdd.addActionListener(o);
        bEx.addActionListener(o);
        bRem.addActionListener(o);
        bDiv.addActionListener(o);
        bEq.addActionListener(o);

    }

    private class OperandClickListener implements ActionListener{
        /*
          Обработчик нажатий на цифры
         */
        @Override
        public void actionPerformed(ActionEvent e) { //реализуем метод actionPerformed интерфейса ActionListener
            if (e.getSource() == b0){
                txt = txt + 0;
            }else if (e.getSource() == b1){
                txt = txt + 1;
            }else if (e.getSource() == b2){
                txt = txt + 2;
            }else if (e.getSource() == b3){
                txt = txt + 3;
            }else if (e.getSource() == b4){
                txt = txt + 4;
            }else if (e.getSource() == b5){
                txt = txt + 5;
            }else if (e.getSource() == b6){
                txt = txt + 6;
            }else if (e.getSource() == b7){
                txt = txt + 7;
            }else if (e.getSource() == b8){
                txt = txt + 8;
            }else if (e.getSource() == b9){
                txt = txt + 9;
            }
            tfShow.setText(txt);
            }
        }

    private class OperatorClickListener implements ActionListener{
        /*
          Обработчик нажатий на операторы
         */

        private void performOper(char op){
            /*
              Записываем введенные до знака цифры в буфер. Узнаем операцию, которую будем производить
             */
            result = Double.parseDouble(txt); //заносим первый ввод в буфер
            operator = op; //операция приходит из обработчика нажатия

            //очищаем поля
            tfShow.setText("");
            txt = "";
        }

        @Override
        public void actionPerformed(ActionEvent e) { //реализуем метод actionPerformed интерфейса ActionListener
            if (e.getSource() == bAdd) {
                performOper('+');
            } else if (e.getSource() == bEx) {
                performOper('*');
            } else if (e.getSource() == bDiv) {
                performOper('/');
            } else if (e.getSource() == bRem) {
                performOper('-');
            } else if (e.getSource() == bEq) {
                try {
                    switch (operator) {
                        case '+':
                            result = result + Double.parseDouble(txt);
                            break;
                        case '-':
                            result = result - Double.parseDouble(txt);
                            break;
                        case '*':
                            result = result * Double.parseDouble(txt);
                            break;
                        case '/':
                            result = result / Double.parseDouble(txt);
                            break;
                    }
                    tfShow.setText("Результат: " + result);
                    txt = "";
                    result = 0.0;
                } catch (ArithmeticException ex) { //ловим единственно возможную в данном случае ошибку - деление на 0
                    tfShow.setText("На ноль делить нельзя!");
                    txt = "";
                    result = 0.0;
                }
            }
        }
    }
}
