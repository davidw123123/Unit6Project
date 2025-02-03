import java.io.File;
import java.io.FileNotFoundException;
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
            System.out.println(Arrays.toString(stringNumbers));
            //part one
            System.out.println(cards.hands(stringNumbers));
            //part two
            cards.setHandArrayList(fileData);
            System.out.println(cards.getFourCard());
        }
        catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }
    }
}
