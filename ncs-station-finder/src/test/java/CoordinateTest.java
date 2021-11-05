
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class CoordinateTest {

    Coordinate coordinate1 = new Coordinate(0,0);
    Coordinate coordinate2 = new Coordinate(3,4);
    Coordinate coordinate3 = new Coordinate(0,3);
    Coordinate coordinate4 = new Coordinate(0,-3);

    @Test
    void distanceIsFive() {
        assertTrue("Expected Distance must be 5",Double.compare(Double.valueOf(5),coordinate1.getDistanceFromCoordinate(coordinate2))==0);
    }
    @Test
    void distanceIsThree() {
        assertTrue("Expected Distance must be 3",Double.compare(Double.valueOf(3),coordinate1.getDistanceFromCoordinate(coordinate3))==0);
    }
    @Test
    void negativeYCoordinateMustAlsoGiveDistanceThree() {
        assertTrue("Expected Distance must be 3",Double.compare(Double.valueOf(3),coordinate1.getDistanceFromCoordinate(coordinate4))==0);
    }
}
