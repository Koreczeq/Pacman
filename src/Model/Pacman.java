package Model;

public class Pacman {
    private Direction direction;
    private Direction newDirection;
    private boolean[][] board;
    private int posY, posX;

    public Pacman (boolean[][] board) {
        this.board = board;
        direction = Direction.NORTH;
        newDirection = Direction.NORTH;
    }

    public void move() {
        if(moveIfPossible(newDirection)) {
            direction = newDirection;
            }
        else if(moveIfPossible(direction));
        else
            System.out.println("cant move");

    }

    public void setPosition(int posY, int posX) {
        this.posY = posY;
        this.posX = posX;
    }
    public int[] getPosition() {
        int[] positon = {posY, posX};
        return positon;
    }

    private boolean moveIfPossible(Direction direct) {
        switch (direct) {
            case NORTH:
                if((posY > 0) && (!board[posY -1][posX] )) {
                    setPosition(posY - 1, posX);
                    return true;
                }
                else
                    return false;
            case EAST:
                if((posX + 1 < board[0].length) && (!board[posY][posX + 1] )) {
                    setPosition(posY, posX + 1);
                    return true;
                }
                else
                    return false;
            case SOUTH:
                if((posY + 1 < board.length) && (!board[posY + 1][posX] )) {
                    setPosition(posY + 1, posX);
                    return true;
                }
                else
                    return false;
            case WEST:
                if((posX > 0) && (!board[posY][posX - 1] )) {
                    setPosition(posY, posX - 1);
                    return true;
                }
                else
                    return false;
            default:
                System.out.println("Invalid direction");
                return false;

        }
    }


    public void setDirection(Direction direct) {
        newDirection = direct;
    }
}
