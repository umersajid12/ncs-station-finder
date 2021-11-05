import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StationFinder {

    private static LinkStation linkStation1 = new LinkStation(0, 0, 10);
    private static LinkStation linkStation2 = new LinkStation(20, 20, 5);
    private static LinkStation linkStation3 = new LinkStation(10, 0, 12);
    // using Stream so that the collection can be expanded.
    private static List<LinkStation> stations = Stream.of(linkStation1, linkStation2, linkStation3).collect(Collectors.toList());

    // SortedMap to help with fetching the highest power value in key
    static SortedMap sortedMap = new TreeMap<Double, ArrayList<LinkStation>>();

    // Sample data
    private static Coordinate coordinate1 = new Coordinate(0, 0);
    private static Coordinate coordinate2 = new Coordinate(100, 100);
    private static Coordinate coordinate3 = new Coordinate(15, 10);
    private static Coordinate coordinate4 = new Coordinate(18, 18);
    private static List<Coordinate> sampleCoordinates = Stream.of(coordinate1, coordinate2, coordinate3, coordinate4).collect(Collectors.toList());

    public static void main(String args[])  //static method
    {
        Scanner myInput = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Station check Main Menu\n");
            System.out.print("1.) Add your own X and Y coordinates \n");
            System.out.print("2.) Use and print the sample data.\n");
            System.out.print("3.) Exit.\n");
            System.out.println("Enter choice \"1\", \"2\" or \"3\"");
            choice = myInput.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter X coordinate of a location to find best LinkStation for it.");
                    int x = myInput.nextInt();
                    System.out.println("Enter Y coordinate of a location to find best LinkStation for it.");
                    int y = myInput.nextInt();
                    Coordinate coordinateAdded = new Coordinate(x, y);
                    System.out.println(coordinateAdded.toString());
                    findBestLinkStation(coordinateAdded);
                    break;
                case 2:
                    for (Coordinate coordinate : sampleCoordinates) {
                        System.out.println("Testing sample coordinate1. \n" + coordinate.toString());
                        findBestLinkStation(coordinate);
                    }
                    break;
                case 3:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;
            }
        }


    }

    private static void findBestLinkStation(Coordinate coordinate) {
        List<LinkStation> list;
        for (LinkStation station : stations) {
            Double power = station.getPowerAtCoordinate(coordinate);
            if (sortedMap.containsKey(power)) {
                list = (ArrayList<LinkStation>) sortedMap.get(station.getPowerAtCoordinate(coordinate));
                list.add(station);
            } else {
                list = new ArrayList<LinkStation>();
                list.add(station);
                sortedMap.put(power, list);

            }
        }
        /* Adding Stations to tree Map so that the complexity is O(n+k)
           given that there can be a situation where more than one Station can have the highest power to a location.
           in those cases it is more efficient to use treeMap as the key is ordered and we avoid multiple iterations.
           The other approach is to iterate once to get the maximum value and then iterate again to collect the number of times the maximum occurs.
           I find the treeMap approach to be more efficient.
         */
        Double highestPower = (Double) sortedMap.lastKey();
        List<LinkStation> allUseFullStations = (ArrayList<LinkStation>) sortedMap.get(highestPower);
        if (highestPower > 0) {
            if (allUseFullStations.size() == 1) {
                System.out.println("Best station is : " + allUseFullStations.get(0).toString() + " with power" + highestPower.toString());
            } else if (allUseFullStations.size() > 1) {
                for (LinkStation bestStation : allUseFullStations) {
                    System.out.println("Best station is : " + bestStation.toString() + " with power " + highestPower.toString());
                }
            }
        } else {
            System.out.println("No link station within reach for point x,y " + coordinate.toString());
        }

    }
}
