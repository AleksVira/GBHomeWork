package ru.virarnd.hw08;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SelectPlayer extends JPanel {
    private JPanel rootPanel;
    private JRadioButton firstHumanRadioButton;
    private JRadioButton firstAiRadioButton;
    private JRadioButton secondHumanRadioButton;
    private JRadioButton secondAiRadioButton;

    private JButton playButton;
    private JTextField textField1;
    private JTextField textField2;

    private JLabel labelField;
    private JLabel firstName;
    private JLabel secondName;

    JPanel getRootPanel() {
        return rootPanel;
    }

    JTextField getTextField1() {
        return textField1;
    }

    JTextField getTextField2() {
        return textField2;
    }

    SelectPlayer(Player playerOne, Player playerTwo) {
        firstHumanRadioButton.setSelected(true);
        secondAiRadioButton.setSelected(true);
        textField2.setEnabled(false);

        firstHumanRadioButton.setActionCommand(GameControl.FIRST_HUMAN);
        firstAiRadioButton.setActionCommand(GameControl.FIRST_AI);
        secondHumanRadioButton.setActionCommand(GameControl.SECOND_HUMAN);
        secondAiRadioButton.setActionCommand(GameControl.SECOND_AI);
        playButton.setActionCommand(GameControl.START);

        ButtonGroup bgFirst = new ButtonGroup();
        bgFirst.add(firstHumanRadioButton);
        bgFirst.add(firstAiRadioButton);

        ButtonGroup bgSecond = new ButtonGroup();
        bgSecond.add(secondHumanRadioButton);
        bgSecond.add(secondAiRadioButton);

        textField1.setText(playerOne.getName());
        textField2.setText(playerTwo.getName());

    }

    public void addButtonsListener(ActionListener actionListener) {
        playButton.addActionListener(actionListener);
        firstHumanRadioButton.addActionListener(actionListener);
        firstAiRadioButton.addActionListener(actionListener);
        secondHumanRadioButton.addActionListener(actionListener);
        secondAiRadioButton.addActionListener(actionListener);
    }

}
