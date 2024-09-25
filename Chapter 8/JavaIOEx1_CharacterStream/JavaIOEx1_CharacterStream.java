import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class JavaIOEx1_CharacterStream {

    public static void main(String[] args) {
        String str = readFile("files/jack-be-nimble.txt", 'e');
        writeFile("files/jack-be-nimble-edited.txt", str);
        
        // Invoke your Knowledge Check 1 method here.
        
//        long totalElapsed = 0;
//        for (int i = 0; i < 100; i++) {
//            long start = System.nanoTime();
//            String str = readFile("files/alice.txt", 'e');
//            writeFile("files/alice-edited.txt", str);
//            long end = System.nanoTime();
//            totalElapsed += end - start;
//        }
//        System.out.printf("Time elapsed (ms) for character stream: %f", totalElapsed/1000000.0);
    }
    
    /**
     * Reads a text file, character-by-character using a character stream.
     * Removes all occurrences of the target character.
     * @param filename path to the text file
     * @param tgt target character to remove
     * @return original text file with target character removed
     */
    public static String readFile(String filename, char tgt) {
        Reader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new FileReader(filename);
            int curr;
            while ((curr = reader.read()) != -1) {
                if (curr != tgt) {
                    builder.append((char) curr);
                } else {
                    builder.append("[]");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException occurred when reading file");
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("IOException occurred when "
                            + "attempting to close reader");
                }
            }
        }
        return builder.toString();
    }
    
    /**
     * Writes a given String to the specified file path using a character stream.
     * @param filename the file path
     * @param data the String to write to the file
     */
    public static void writeFile(String filename, String data) {
        Writer writer = null;
        try {
            writer = new FileWriter(filename);
            char[] charactersToWrite = data.toCharArray();
            for (char c: charactersToWrite) {
                writer.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException occurred when writing to file");
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    System.out.println("IOException occurred when "
                            + "attempting to flush and close writer");
                }
            }
        }
    }
    
    // Knowledge Check 1:
    /*
     * Write a method that reads a text file and returns a String in which all 
     * uppercase letters are made lowercase and all lowercase letters made uppercase. 
     * If a character is not a letter, do not modify it and add it to the String as 
     * is. Your method should not throw any Exceptions, nor should it have any resource 
     * leaks. Invoke your method in main() and test it out with some files.
     */

}
