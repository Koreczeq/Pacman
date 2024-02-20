package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizeBoardSetting extends JFrame {
    JPanel panel = new JPanel();
    JSlider widthSetting = new JSlider(JSlider.HORIZONTAL,10,100,20);
    JSlider heightSetting = new JSlider(JSlider.VERTICAL,10,100,20);
    JButton okButton = new JButton("Ok!");
    JButton cancelButton = new JButton("Cancel!");

    public SizeBoardSetting() {
        genereteWindow();
        settingActionListener();

    }

    private void genereteWindow() {
        widthSetting.setMajorTickSpacing(30);
        widthSetting.setMinorTickSpacing(10);
        widthSetting.setPaintTicks(true);
        widthSetting.setPaintLabels(true);

        heightSetting.setMajorTickSpacing(30);
        heightSetting.setMinorTickSpacing(10);
        heightSetting.setPaintTicks(true);
        heightSetting.setPaintLabels(true);

        GridLayout gridLayout = new GridLayout(2,2);
        panel.setLayout(gridLayout);
        panel.add(widthSetting);
        panel.add(heightSetting);
        panel.add(okButton);
        panel.add(cancelButton);
        add(panel);
        pack();
        setResizable(false);
        setTitle("Pacman");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void settingActionListener() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()->new Game(heightSetting.getValue(), widthSetting.getValue()));
                SizeBoardSetting.super.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SizeBoardSetting.super.dispose();
            }
        });
    }

}
