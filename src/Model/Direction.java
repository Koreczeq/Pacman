package Model;

public enum Direction {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    public int value;
    private Direction(int value) {
        this.value = value;
    }
}
