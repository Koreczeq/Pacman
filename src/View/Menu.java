package View;

import Controller.MenuButtonsActionListener;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    JPanel panel = new JPanel();
    SpringLayout layout = new SpringLayout();

    JButton startButton = new JButton("Start");
    JButton resultsButton = new JButton("Results");
    JButton exitButton = new JButton(("Exit"));


    MenuButtonsActionListener buttonsListener = new MenuButtonsActionListener();
    public Menu() {
        setMenuLayout();
        attachListenerToButtons();
        add(panel);
        setSize(800, 800);
        setTitle("Pacman");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setMenuLayout() {
        panel.setLayout(layout);
        Font font = new Font(Font.SERIF,Font.BOLD,40);
        startButton.setFont(font);
        resultsButton.setFont(font);
        exitButton.setFont(font);

        panel.add(startButton);
        panel.add(resultsButton);
        panel.add(exitButton);

        layout.putConstraint(SpringLayout.NORTH, startButton, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, startButton, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, resultsButton, 200, SpringLayout.SOUTH, startButton);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, resultsButton, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, exitButton, 200, SpringLayout.SOUTH, resultsButton);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, exitButton, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        panel.setBackground(Color.BLACK);
    }

    private void attachListenerToButtons() {
        startButton.addActionListener(buttonsListener);
        resultsButton.addActionListener(buttonsListener);
        exitButton.addActionListener(buttonsListener);
    }
}
