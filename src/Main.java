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
            System.out.println(Arrays.toString(stringNumbers));
            for (int i=0; i < fileArray.length; i++) {
                // split by space, now we have a list of String numbers
                stringNumbers[i] =  fileArray[i].substring(0,  fileArray[i].indexOf("|"));
            }
            System.out.println(Arrays.toString(stringNumbers));
            String [] test = stringNumbers[0].split(",");
            System.out.println(Arrays.toString(test));
            System.out.println(Arrays.toString(cards.duplicates(test)));
//            String[] stringNumber = new String[stringNumbers.length];
//            for (int i=0; i < stringNumbers.length; i++) {
//                stringNumber[i] = Arrays.toString(stringNumbers[i].split(" "));
//            }
//            System.out.println(Arrays.toString(stringNumber));
//            System.out.println(stringNumber[0]);
        }
        catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }


    }
}

