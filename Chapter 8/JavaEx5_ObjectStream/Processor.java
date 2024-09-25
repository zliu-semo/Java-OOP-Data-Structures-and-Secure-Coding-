package res;
import java.io.*;

/**
 * Conducts reading/writing operations for object stream data
 */
public class Processor {
    
    /**
     * Writes objects to file using object streams (a version of byte streams)
     * @param filename the specified file path
     * @param objects an array of objects to write to file
     */
    public static void writeObjects(String filename, Object[] objects) {
        ObjectOutputStream out = null;
        
        try {
            out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(filename)));
            for (Object o: objects) {
                out.writeObject(o);
                out.writeChar('\n');
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File not found: %s\n", filename);
        } catch (IOException e) {
            System.out.println("IOException occurred during writing");
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    System.out.println("IOException occurred during closing");
                }
            }
            System.out.println("Done writing objects to file");
        }
    }
    
    /**
     * Reads a file of object data using object stream
     * @param filename the specified file path
     */
    public static void readObjects(String filename) {
        ObjectInputStream in = null;
        
        try {
            in = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(filename)));
            NestingDoll curr = null;
            NestingDoll currInner = null;
            while (true) {
                curr = (NestingDoll) in.readObject();
                if (curr == currInner) {
                    System.out.println("Same reference as inner doll of previous");
                } else if (curr.equals(currInner)) {
                    System.out.println("Structurally equal to inner doll of previous");
                } else {
                    System.out.println("Not == or .equals() inner doll of previous");
                }
                System.out.println(curr.toString() + "\n");
                currInner = curr.getInnerDoll();
                in.readChar(); // consume new line
            }
        } catch (EOFException e) {
            System.out.println("End of file");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.printf("File not found: %s\n", filename);
        } catch (IOException e) {
            System.out.println("IOException occurred during reading");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("IOException occurred during closing");
                }
            }
            System.out.println("Done reading objects from file");
        }
    }
    
    // [InputStream/OutputStream] Knowledge Check 2:
    /*
     * Write a method that takes in an array of NestingDoll objects and writes each 
     * object’s fields to a specified file path. Specifically, record the following 
     * information:
     * •   the doll’s pattern
     * •   the doll’s inner doll
     * •   the count of which position in the input array this doll came from
     * 
     * The exact format of the binary file this method produces is up to you. 
     * Your method should not throw any Exceptions, nor should it have any resource leaks. 
     * Invoke your method in main() and test it out with some files. (You will need to 
     * align this method with the method in Knowledge Check 3.)
     */
    
    // [InputStream/OutputStream] Knowledge Check 3:
    /*
     * Write a method that reads the following NestingDoll information from a binary file:
     * •   the doll’s pattern
     * •   the doll’s inner doll
     * •   the count of which position in the input array this doll came from
     * 
     * After reading in the objects, print the doll objects that had come from user-specified 
     * array indices. Your method should not throw any Exceptions, nor should it have any 
     * resource leaks. Invoke your method in main() and test it out with some files.
     */
}
