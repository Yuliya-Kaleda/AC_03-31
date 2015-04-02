package nyc.c4q.yuliyakaleda;

/**
 * Created by July on 3/31/15.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RestaurantFacts {

    public static void main(String[] args) {
        // Step 1. Use FileParser's static method getLines() to get a nested
        //         ArrayList representing the CSV file.
        //
        //         For now, use "nyc-restaurants-small.csv".
        //
        //         Use a parameter to specify which column you're interested
        //         in. For now, use the int 14, which will give you the
        //         restaurant's grade.

        ArrayList<ArrayList<String>> data = FileParser.getLines("nyc-restaurants-small.csv", 14);
        System.out.println(data);
        // Step 2. Build a HashMap named "restaurants".
        //         Loop over every line and add the appropriate data to your
        //         HashMap.
        HashMap<String, Character> restMap = new HashMap<String, Character>();
        for (ArrayList<String> s : data) {
            String key = s.get(1);
            String value = s.get(14);
            Character newValue = value.charAt(0);
            restMap.put(key, newValue);
        }

        // Step 3. Create a Scanner and prompt the user for a restaurant.
        //         If the restaurant has a relevant fact, print it. Otherwise
        //         print "Restaurant not found.".
        Scanner in = new Scanner(System.in);
        System.out.println("Type in the name of the restaurant: ");
        String userIn = in.nextLine().toUpperCase();
        if (restMap.containsKey(userIn)) {
            System.out.println(restMap.get(userIn));
        } else {
            System.out.println("Sorry the restaurant is not in our database!");
        }
    }
}