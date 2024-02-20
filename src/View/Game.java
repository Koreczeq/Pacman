package View;

import Model.GameCellRenderer;
import Model.GameModel;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    JTable board;
    GameModel model;
    GameCellRenderer cellRenderer;
    public Game(int height, int width) {
        board = new JTable(height, width);
        model = new GameModel(height, width);
        cellRenderer = new GameCellRenderer();

        board.setModel(model);
        board.setDefaultRenderer(Object.class,cellRenderer);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(board);
        add(scrollPane);

        setSize(width*15, height*15);
        setTitle("Pacman");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return board.getPreferredSize();
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        int cellWidth = (int)(width/ board.getColumnCount());
        int cellHeight = (int)(height/ board.getRowCount());
        board.setRowHeight(cellHeight);
        for(int i = 0; i < board.getColumnCount(); ++i){
            board.getColumnModel().getColumn(i).setPreferredWidth(cellWidth);
        }
    }

    @Override
    public void setSize(Dimension d) {
        super.setSize(d);
        board.setSize(d);
    }
}
