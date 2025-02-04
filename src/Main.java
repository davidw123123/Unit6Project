import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;




public class Main {
    public static void main(String[] args) {
        Cards cards = new Cards();
        // step 1: create a file object
        File f = new File("src/input_file");
        String fileData = "";
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                fileData += currentLine + "\n";
            }

            // a String array where every item in the array is a line from the file
            String[] stringNumbers = cards.setHand(fileData);
            System.out.println(cards.strongerDeck(stringNumbers[0], stringNumbers[1]));
            System.out.println(Arrays.toString(stringNumbers));
            //part one
            System.out.println(cards.hands(stringNumbers));
            //part two
            cards.setBidValue(fileData);
            cards.setHandArrayList(fileData);
            cards.sortHand(cards.twoPair, cards.twoPairBidValue);
            System.out.println(cards.twoPair);
            System.out.println(Arrays.toString(cards.bidValue));
        }
        catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }
    }
}
