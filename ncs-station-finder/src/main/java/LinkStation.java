
public class LinkStation extends Coordinate {

    private int reach;

    public LinkStation(int x, int y, int reach) {
        super(x, y);
        this.reach = reach;
    }

    public int getReach() {
        return reach;
    }

    public Double getPowerAtCoordinate(Coordinate coordinate) {
        Double distanceFromCoordinate = this.getDistanceFromCoordinate(coordinate);
        if (distanceFromCoordinate > reach) {
            return Double.valueOf(0);
        } else {
            return (this.reach - this.getDistanceFromCoordinate(coordinate)) * (this.reach - this.getDistanceFromCoordinate(coordinate));
        }
    }

    @Override
    public String toString() {
        return "x,y is : " + this.getX() + "," + this.getY() + "\n" + " Reach is :" + this.getReach();
    }
}
