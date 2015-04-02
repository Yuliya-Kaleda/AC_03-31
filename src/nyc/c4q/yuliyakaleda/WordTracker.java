package nyc.c4q.yuliyakaleda;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Yuliya Kaleda on 3/31/15.
 */
public class WordTracker {

    public static void main (String[] args) {
        HashMap<String, Integer> words = new HashMap<String, Integer>();

        Scanner scanner = new Scanner (System.in);
        System.out.println("Please give me some words: ");

        boolean addMode = true;
        while(true) {
            String input = scanner.next();
            if (!input.equalsIgnoreCase("stop")) {
                if (input.equalsIgnoreCase("clr")) {
                  words.clear();
                }
                else if (input.equalsIgnoreCase("add")) {
                    addMode = true;
                }
                else if (input.equalsIgnoreCase("rm")) {
                    addMode = false;
                }
                else {
                    if (addMode) {
                        if (!words.containsKey(input)) {
                            words.put(input, 1);
                        }
                        else {
                            int value = words.get(input);
                            words.put(input, value + 1);
                        }
                    }
                    else {
                        words.remove(input);
                    }
                }
            }
            else {
                System.out.println("Thanks! You have given me " + words.size() + " word(s)!");
                if (words.isEmpty()) {
                    System.out.println("Words is empty!");
                }
                else {
                    System.out.println("Here they are: ");
                    for (String key : words.keySet()) {
                        System.out.println(key + ": " + words.get(key));
                    }
                }
                break;
            }
        }
   }
}
