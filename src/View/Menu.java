package View;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    public Menu() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        Font font = new Font(Font.SERIF,Font.BOLD,40);
        JButton startButton = new JButton("Start");
        startButton.setFont(font);
        JButton resultsButton = new JButton("Results");
        resultsButton.setFont(font);
        JButton exitButton = new JButton(("Exit"));
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
        add(panel);
        setSize(800, 800);
        setTitle("Pacman");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
