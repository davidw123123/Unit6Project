import java.io.File;
import java.io.FileNotFoundException;
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
            String[] fileArray = fileData.split("\n");
            String[] stringNumbers = new String[fileArray.length];

            for (int i=0; i < fileArray.length; i++) {
                // removes |
                stringNumbers[i] = Arrays.toString(fileArray[i].split(" "));
            }

            for (int i=0; i < fileArray.length; i++) {
                // split by space, now we have a list of String numbers
                stringNumbers[i] =  fileArray[i].substring(0,  fileArray[i].indexOf("|"));
            }
            //part one
            System.out.println(cards.hands(stringNumbers));
        }
        catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }




    }
}
