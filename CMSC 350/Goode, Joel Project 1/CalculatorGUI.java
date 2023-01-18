/*
 * Joel Goode CMSC 350
 * This Class is the main class that will run the program.
 * Designed to allow users to convert prefix expressions to postfix and
 * and postfix to prefix
 */

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {

    // Frame Variables.
    private JPanel panel;
    private JButton preFixBtn, postFixBtn;
    private JLabel preFixLbl, postFixLbl, solutionLbl, solutionTxt;
    private JTextField preFixTxt, postFixTxt;

    // Main GUI settings.
    CalculatorGUI() {
        super("Pre & Post Expression Conversion Calculator");
        LayoutSettings();
        setClickEventListeners();
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void LayoutSettings() {

        // Create layout with constraints.
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();

        // Create Panel.
        panel = new JPanel();
        panel.setLayout(bagLayout);

        // Create Labels, buttons and text fields.
        preFixLbl = new JLabel("Enter Prefix Expression: ");
        postFixLbl = new JLabel("Enter Postfix Expression: ");
        preFixBtn = new JButton("Convert to PostFix");
        postFixBtn = new JButton("Convert to PreFix");
        solutionLbl = new JLabel("Solution: ");
        solutionTxt = new JLabel();
        preFixTxt = new JTextField(15);
        postFixTxt = new JTextField(15);

        // Additional Format of the layout. 
        bagConstraints.insets = new Insets(5, 5, 5, 5);
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;         // row 1
        panel.add(preFixLbl, bagConstraints);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        panel.add(preFixTxt, bagConstraints);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        panel.add(preFixBtn, bagConstraints); // row 2
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 3;
        panel.add(postFixLbl, bagConstraints); // row 3
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 3;
        panel.add(postFixTxt, bagConstraints);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 4;
        panel.add(postFixBtn, bagConstraints);   // row 4
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 5;
        panel.add(solutionLbl, bagConstraints);  // row 5
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 6;
        panel.add(solutionTxt, bagConstraints);

        add(panel, BorderLayout.CENTER);
    }

    // Method for Click and action listeners. Set to throw error message in new window pane.
    private void setClickEventListeners() {
        preFixBtn.addActionListener(e -> {

            postFixTxt.setText("");
            String postfix = null;
            try {

                postfix = Calculations.preToPostFix(preFixTxt.getText());

            } catch (ErrorHandle syntaxError) {
                JOptionPane.showMessageDialog(CalculatorGUI.this, syntaxError.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);

            }
            solutionTxt.setText("Converted to a Postfix Expression:  " + postfix);
        });

        postFixBtn.addActionListener(e -> {

            preFixTxt.setText("");
            String prefix = null;
            try {

                prefix = Calculations.postToPreFix(postFixTxt.getText());

            } catch (ErrorHandle syntaxError) {

                JOptionPane.showMessageDialog(CalculatorGUI.this, syntaxError.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);    

            }

            solutionTxt.setText("Converted to a Prefix Expression:  " + prefix);
        });
    }

    // Main method it run GUI application.
    public static void main(String[] args) {

        new CalculatorGUI();
    }
}
