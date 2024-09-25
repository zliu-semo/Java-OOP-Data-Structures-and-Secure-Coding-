import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaIOEx2_BufferedStream {

    public static void main(String[] args) {
        String str = readFile("files/jack-be-nimble.txt", 'e');
        writeFile("files/jack-be-nimble-edited.txt", str);
//        long totalElapsed = 0;
//        for (int i = 0; i < 100; i++) {
//            long start = System.nanoTime();
//            String str = readFile("files/alice.txt", 'e');
//            writeFile("files/alice-edited.txt", str);
//            long end = System.nanoTime();
//            totalElapsed += end - start;
//        }
//        System.out.printf("Time elapsed (ms) for buffered stream: %f", totalElapsed/1000000.0);
    }
    
    /**
     * Reads a text file, line-by-line using a buffered stream.
     * Removes all occurrences of the target character.
     * @param filename path to the text file
     * @param tgt target character to remove
     * @return original text file with target character removed
     */
    public static String readFile(String filename, char tgt) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line.replaceAll(Character.toString(tgt), "[]"));
                builder.append("\n");
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
     * Writes a given String to the specified file path using a buffered stream.
     * @param filename the file path
     * @param data the String to write to the file
     */
    public static void writeFile(String filename, String data) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write(data);
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
    
    // Knowledge Check 2:
    /*
     * Write a method that reads a text file and returns a String that contains 
     * only the lines that end with a target character. Your method should not 
     * throw any Exceptions, nor should it have any resource leaks. Invoke your 
     * method in main() and test it out with some files.
     */
    
    public static String readFile2(String filename, char tgt) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.endsWith(Character.toString(tgt))) {
                    builder.append(line);
                    builder.append("\n");
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

}
