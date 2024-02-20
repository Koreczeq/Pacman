package Controller;

import View.SizeBoardSetting;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MenuButtonsActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(Objects.equals(button.getText(), "Start")) {
            SizeBoardSetting sizeBoardSetting = new SizeBoardSetting();
            System.out.println("Starttttt!");
        }
        else if(Objects.equals(button.getText(), "Results")) {
            System.out.println("Resssssultas!");
        }
        else if(Objects.equals(button.getText(), "Exit")) {
            System.exit(0);
        }
    }
}
