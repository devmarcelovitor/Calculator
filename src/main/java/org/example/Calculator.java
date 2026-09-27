package org.example;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {
    int boardWidth = 500;
    int boardHeight = 600;
    Color customLightGray = new Color(192, 192, 192);
    Color customDarkGray = new Color(95, 9, 0);
    Color customWhite = new Color(34, 34, 34);
    Color customBlack = new Color(0, 0, 0);

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};




    JFrame frame =  new JFrame("Calculator");
    JLabel displayLabel  = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonPanel = new JPanel();





    Calculator(){
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(customWhite);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(5, 4));
        buttonPanel.setBackground(customBlack);
        frame.add(buttonPanel);




        for(int i = 0; i < buttonValues.length; i++){
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 60));
            button.setText(buttonValue);
            buttonPanel.add(button);
        }









    }

}