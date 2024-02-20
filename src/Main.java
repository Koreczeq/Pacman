import View.Game;
import View.Menu;
import View.SizeBoardSetting;

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        SwingUtilities.invokeLater(()->new Menu());
        //SwingUtilities.invokeLater(()->new Game(100, 100));
        //SwingUtilities.invokeLater(()->new SizeBoardSetting());
    }
}