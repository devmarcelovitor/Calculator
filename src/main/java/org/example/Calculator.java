package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Calculator {
    int boardWidth = 500;
    int boardHeight = 600;
    Color customGray = new Color(51, 51, 51);
    Color customDiscord = new Color(88, 101, 242);
    Color customWhite = new Color(165, 165, 165);
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


    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonPanel = new JPanel();


    String A = "0";
    String operator = null;
    String B = null;


    Calculator() {
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(getClass().getResource("/calculator_icon.png"));
        frame.setIconImage(icon.getImage());

        displayLabel.setBackground(customBlack);
        displayLabel.setForeground(Color.gray);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(5, 4));
        buttonPanel.setBackground(customGray);
        frame.add(buttonPanel);


        for (int i = 0; i < buttonValues.length; i++) {
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 60));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(customBlack));

            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(customWhite);
                button.setForeground(customBlack);

            } else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                button.setBackground(customDiscord);
                button.setForeground(customBlack);
            } else {
                button.setBackground(customGray);
                button.setForeground(customBlack);
            }


            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();
                    if (Arrays.asList(rightSymbols).contains(buttonValue)) {

                    } else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                        if(buttonValue == "AC"){
                            clearAll();
                            displayLabel.setText("0");

                        }
                        else if(buttonValue == "+/-"){
                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            numDisplay *= -1;
                            displayLabel.setText(Double.toString(numDisplay));

                        }
                        else if(buttonValue == "%"){

                        }

                    } else {//digits or .
                        if (buttonValue == ".") {
                            if(!displayLabel.getText().contains(buttonValue)) {
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        } else if ("123456789".contains(buttonValue)) {
                            if (displayLabel.getText() == "0") {
                                displayLabel.setText(buttonValue);


                            } else {
                                displayLabel.setText(displayLabel.getText() + buttonValue);

                            }
                        }
                    }
                }

            });
        }
        frame.setVisible(true);


    }
    void clearAll(){
        A = "0";
        operator = null;
        B = null;
    }
}

