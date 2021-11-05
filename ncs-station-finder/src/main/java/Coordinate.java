public class Coordinate {
    /* Examples show only integer values */
    private int x;
    private int y;

    private Coordinate() {
    }

    protected Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Double getDistanceFromCoordinate(Coordinate coordinate) {
        return Math.sqrt((coordinate.getX() - this.x) * (coordinate.getX() - this.x) + (coordinate.getY() - this.y) * (coordinate.getY() - this.y));
    }

    public String toString() {
        return x + "," + y;
    }

}
