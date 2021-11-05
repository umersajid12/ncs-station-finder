import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class LinkStationTest {

    Coordinate coordinate1 = new Coordinate(0,0);
    // Distance between coordinates is 4
    LinkStation station1 = new LinkStation(4,0,3);
    LinkStation station2 = new LinkStation(4,0,8);
    @Test
    void distanceIsGreaterThanReach() {
        assertTrue("Power must be zero",Double.compare(Double.valueOf(0),station1.getPowerAtCoordinate(coordinate1))==0);
    }

    @Test
    void distanceIsLesserThanReach() {
        assertTrue("Power is 16",Double.compare(Double.valueOf(16),station2.getPowerAtCoordinate(coordinate1))==0);
    }
}