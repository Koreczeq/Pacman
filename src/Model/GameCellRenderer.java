package Model;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class GameCellRenderer extends JLabel implements TableCellRenderer {

    Icon pointIcon = new ImageIcon("resources/point3.png");
    public GameCellRenderer() {
        this.setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        GameModel model = (GameModel) table.getModel();
        this.setText("");
        if((boolean) value)
            this.setBackground(Color.BLUE);
        else
            this.setBackground(Color.BLACK);
        if(model.checkIfPoint(row,column)) {
            this.setIcon(pointIcon);
        } else {
            this.setIcon(null);
        }

        return this;
    }
}
