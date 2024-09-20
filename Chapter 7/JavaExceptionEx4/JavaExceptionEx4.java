package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import resources.*;

public class JavaExceptionEx4 {

    public static void main(String[] args) {
        try {
            getInputsAndDisplay();
        } catch (IllegalArgumentException e) {
            System.out.printf("IllegalArgumentException occurred: \n"
                            + "Name: %s\n"
                            + "Message: %s\n"
                            + "Cause: %s\n",
                    e.toString(), e.getMessage(), e.getCause());
        } finally {
            System.out.println("Ready for another task");
        }

    }

    /**
     * Creates a {@code File} object from a provided file path
     * @param filename the file path
     * @return the {@code File} object representing the file at that path
     * @throws FileNotFoundException if the file path does not exist
     * @throws IllegalArgumentException if the provided {@code filename} is {@code null}
     */
    public static File readFile(String filename) throws FileNotFoundException {
        if (filename == null) {
            throw new IllegalArgumentException("Filename provided is null.");
        }
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("Filename provided cannot be found.");
        }
        return file;
    }

    /**
     * Counts the number of times a target word appears in a given file. This method only counts
     * exact matches.
     * @param file the given {@code File} object
     * @param tgt the target word
     * @return the number of times the target word appeared in the file
     * @throws FileNotFoundException if the {@code file} parameter does not exist
     * @throws IllegalArgumentException if the target String is empty
     */
    public static int countOccurrences(File file, String tgt)
            throws FileNotFoundException, NotAWordException {
        if (file == null || tgt == null) {
            throw new IllegalArgumentException("File or target String provided is null.");
        }
        if (tgt.length() == 0) {
            throw new IllegalArgumentException("Target String provided is empty.");
        }
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        Matcher m = p.matcher(tgt);
        if (!m.find()) {
            throw new NotAWordException("Target String provided is not a word");
        }
        Scanner in = new Scanner(file);
        String line;
        String[] words;
        int count = 0;
        while (in.hasNextLine()) {
            line = in.nextLine().trim();
            line = line.replaceAll("[.?!'-,;:\"*]", "");
            words = line.split(" ");
            for (String word: words) {
                word = word.trim();
                if (word.equals(tgt)) {
                    count++;
                }
            }
        }
        in.close();
        return count;
    }

    /**
     * Performs the bulk of the original function of main().
     * @throws IllegalArgumentException if the file does not exist or the user
     * does not input a word.
     */
    public static void getInputsAndDisplay() throws IllegalArgumentException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a filename to process:");
        String filename = in.nextLine().trim();
        System.out.println("Please enter a target word to look for:");
        String tgt = in.nextLine().trim();
        try {
            File file = readFile(filename);
            System.out.printf("Number of occurrences of %s: %d\n", tgt, countOccurrences(file, tgt));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(String.format("File not found: %s", filename),
                    e);
        } catch (NotAWordException e) {
            throw new IllegalArgumentException(e.getMessage(),
                    e);
        } finally {
            in.close();
            System.out.println("Finished getInputsAndDisplay().");
        }
    }
}


