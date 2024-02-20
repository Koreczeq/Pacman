package Model;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Random;

public class GameModel extends AbstractTableModel{
    private boolean[][] board;
    private boolean[][] points;
    private int pointsLeftCounter;
    private int score;
    private int height;
    private int width;

    private Pacman pacman;


    public GameModel(int height, int width) {
        board = new boolean[height][width];
        points = new boolean[height][width];
        this.height = height;
        this.width = width;

        generateMaze();
        setPoints();
    }



    @Override
    public int getRowCount() {
        return board.length;
    }

    @Override
    public int getColumnCount() {
        return board[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return board[rowIndex][columnIndex];
    }
    private void generateMaze() {
        for(int i  = 0;  i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                if(!board[i][j]) {
                    int possibleWays = countPossibleWays(i, j);
                    if(possibleWays > 2) {
                        int direction = (int)(Math.random()*2);
                        if(direction == 0 && (i < (height - 1)))
                            board[i+1][j] = true;
                        else if(direction == 1 && (j < (width - 1)))
                            board[i][j+1] = true;
                    }
                }
            }
        }
        createBase();
        clearCLoseWays();
    }

    private int countPossibleWays(int posY, int posX) {
        int counter = 0;
        if(posY > 0) {
            if(!board[posY-1][posX])
                counter++;
        }
        if(posY < height-1) {
            if(!board[posY+1][posX])
                counter++;
        }
        if(posX > 0) {
            if(!board[posY][posX-1])
                counter++;
        }
        if(posX < width-1) {
            if(!board[posY][posX+1])
                counter++;
        }
        return counter;
    }

    private void clearCLoseWays() {
        for(int i  = 0;  i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                if(!board[i][j]) {
                    if(countPossibleWays(i,j) < 2) {
                        if(i > 0 && board[i-1][j])
                                board[i-1][j] = false;
                        else if(i < height-1 && board[i+1][j])
                                board[i+1][j] = false;
                        else if(j > 0 && board[i][j-1])
                                board[i][j-1] = false;
                        if(j < width-1 && board[i][j+1])
                                board[i][+1] = false;
                    }
                }
            }
        }
        return;
    }

    private void createBase() {
        int distXFromBorder = (int)((width - 4)/2);
        int distYFromBorder = (int)((height - 3)/2);
        for(int i = distYFromBorder - 1; i < (height - distYFromBorder + 1); i++) {
            for(int j = distXFromBorder - 1; j < (width - distXFromBorder + 1); j++)
                board[i][j] = false;
        }
        for(int i = distXFromBorder; i < (width - distXFromBorder); ++i) {
            board[height - distYFromBorder-1][i] = true;
        }
        for(int i = distYFromBorder; i < (height - distYFromBorder); ++i) {
            board[i][distXFromBorder] = true;
            board[i][width - distXFromBorder-1] = true;
        }
    }

    private void setPoints() {
        for(int i  = 0;  i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (!board[i][j]) {
                    points[i][j] = true;
                    pointsLeftCounter++;
                }
                else {
                    points[i][j] = false;
                }
            }
        }
    }

    public void showBoard() {
        for(int i  = 0;  i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void showPoints() {
        for(int i  = 0;  i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(points[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean checkIfPoint(int row, int column) {
        return points[row][column];
    }

    public Pacman getPacman() {
        return this.pacman;
    }
}
