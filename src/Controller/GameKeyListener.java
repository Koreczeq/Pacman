package Controller;

import Model.Direction;
import Model.GameModel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    GameModel model;
    public GameKeyListener(GameModel model) {
        this.model = model;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                model.getPacman().setDirection(Direction.NORTH);
                break;
            case KeyEvent.VK_RIGHT:
                model.getPacman().setDirection(Direction.EAST);
                break;
            case KeyEvent.VK_DOWN:
                model.getPacman().setDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                model.getPacman().setDirection(Direction.WEST);
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
