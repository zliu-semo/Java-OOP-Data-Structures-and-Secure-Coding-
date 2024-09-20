import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaExceptionEx2 {

    public static void main(String[] args) {
        // Modify the main() program to invoke your Knowledge Check 3 method.
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a filename to process:");
        String filename = in.nextLine().trim();
        System.out.println("Please enter a target word to look for:");
        String tgt = in.nextLine().trim();
        try {
            File file = readFile(filename);
            System.out.printf("Number of occurrences of %s: %d\n", tgt, countOccurrences(file, tgt));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.printf("File not found: %s\n", filename);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            in.close();
            System.out.println("Ready for another task.");
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
    public static int countOccurrences(File file, String tgt) throws FileNotFoundException {
        if (file == null || tgt == null) {
            throw new IllegalArgumentException("File or target String provided is null.");
        }
        if (tgt.length() == 0) {
            throw new IllegalArgumentException("Target String provided is empty.");
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

    // [EXCEPTIONS] Knowledge Check 3:
    /*
     * Write a method that counts the number of words in a file that begin with a given letter
     * (either lowercase words or uppercase words should count).
     *
     * If the file is null, throw an IllegalArgumentException with an
     * informative error message.
     *
     * If the target letter provided is empty, longer than a single letter, or not an alphabet
     * letter, throw an IllegalArgumentException with an informative error message.
     *
     * Invoke your method in main() and test it out on some inputs. What's the proportion of
     * the name "Alice" among all words beginning with 'a'?
     */
}

