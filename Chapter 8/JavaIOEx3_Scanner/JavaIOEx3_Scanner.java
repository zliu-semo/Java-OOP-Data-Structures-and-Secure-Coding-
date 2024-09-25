import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class JavaIOEx3_Scanner {

    public static void main(String[] args) {
        System.out.println(readFileForName("files/contact-space.txt", "PQR"));
        //System.out.println(readFileForName("files/contact-space-missing.txt", "PQR"));
        
        System.out.println("AGE: NAME");
        ArrayList<String> list = readFileAndSortByAge("files/contact-comma.txt");
        //ArrayList<String> list = readFileAndSortByAge("files/contact-comma-missing-ages.txt");
        Collections.sort(list);
        for (String str: list)
            System.out.println(str);
    }
    
    public static File openFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists() || !file.canRead()) {
            throw new FileNotFoundException("Cannot open file: " + filename);
        }
        return file;
    }
    
    public static String readFileForName(String filename, String name) {
        Scanner scanner = null;
        try {
            File file = openFile(filename);
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String currName = scanner.next();
                if (currName.equals(name)) {
                    String currCity = scanner.next();
                    String currEmail = scanner.next();
                    int currAge = scanner.nextInt();
                    return (String.format("Info for %s:\n"
                            + "City: %s\n"
                            + "Email: %s\n"
                            + "Age: %d", 
                            currName, currCity, currEmail, currAge));
                }
            }
            return String.format("%s not found", name);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("File format is incorrect");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return "Problem reading file";
    }
    
    // [Scanner] Knowledge Check 1:
    /*
     * Write a method that reads a data file in which each line is formatted as:
     * [name] [city] [email] [age]
     * The method should search the data file for a target city and return a String 
     * containing all the names of the people who live in that city. Your method 
     * should not throw any Exceptions, nor should it have any resource leaks. Invoke 
     * your method in main() and test it out with some files. 
     */
    
    public static ArrayList<String> readFileAndSortByAge(String filename) {
        Scanner scanner = null;
        BufferedReader reader = null;
        ArrayList<String> result = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(filename));
            scanner = new Scanner(reader);
            scanner.useDelimiter("\\s*,\\s*");
            while (scanner.hasNext()) {
                String currName = "N/A";
                int currAge = 0;
                currName = scanner.next();
                if (scanner.hasNext()) {
                    scanner.next();    // consume the city
                }
                if (scanner.hasNext()) {
                    scanner.next();    // consume the email
                }
                if (scanner.hasNextInt()) {
                    currAge = scanner.nextInt();
                }
                String pair = String.format("%d: %s", currAge, currName);
                result.add(pair);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Problem closing BufferedReader");
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }
        return result;
    }
    
    // [Scanner] Knowledge Check 2:
    /*
     * Write a method that reads a data file in which each line is formatted as:
     * [name] , [city] , [email] , [age]
     * The separating commas may or may not have whitespaces before and after.
     * 
     * The method should extract the name and email of each person, sort the people 
     * by their names, and output each person’s name and email on a separate line. 
     * Your method should not throw any Exceptions, nor should it have any resource 
     * leaks. Invoke your method in main() and test it out with some files. 
     */
}
