import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaIOEx4_DataStream {

    public static void main(String[] args) {
        String filename = "files/students.txt";
        String[] studentNames = {"Ann", "Mark", "Larry", "Jane", "Pat"};
        String[] studentMajors = {"BIOL", "ENGL", "CS", "CS", "CS"};
        int[] studentGrades = {89, 92, 83, 99, 95};
        char[] studentLetterGrades = {'B', 'A', 'B', 'A', 'A'};
        boolean[] studentIsPassing = {true, true, true, true, true};
        
        writeData(filename, 
                studentNames, studentMajors, studentGrades, 
                studentLetterGrades, studentIsPassing);
        
        System.out.println(readData(filename));
    }
    
    /**
     * Writes structured data to specified file path using DataOutputStream
     * @param filename the specified file path
     * @param studentNames array of names
     * @param studentMajors array of majors
     * @param studentGrades array of numerical grades
     * @param studentLetterGrades array of letter grades
     * @param studentIsPassing indicates whether each student is passing
     */
    public static void writeData(String filename, 
            String[] studentNames, String[] studentMajors,
            int[] studentGrades, char[] studentLetterGrades, 
            boolean[] studentIsPassing) {
        
        OutputStream outFile = null;
        DataOutputStream outData = null;
        try {
            outFile = new FileOutputStream(filename);
            outData = new DataOutputStream(outFile); 
            
            int numStudents = studentNames.length;
            for (int i = 0; i < numStudents; i++) {
                outData.writeUTF(studentNames[i]);
                outData.writeUTF(studentMajors[i]);
                outData.writeInt(studentGrades[i]);
                outData.writeChar(studentLetterGrades[i]);
                outData.writeBoolean(studentIsPassing[i]);
                outData.writeChar('\n');
            }
        } catch (FileNotFoundException e) {
            System.out.println("Problem opening file for writing");
        } catch (IOException e) {
            System.out.println("Problem writing to file");
        } finally {
            if (outFile != null) {
                try {
                    outFile.close();
                } catch (IOException e) {
                    System.out.println("Problem closing OutputStream");
                }
            }
            if (outData != null) {
                try {
                    outData.close();
                } catch (IOException e) {
                    System.out.println("Problem closing DataOutputStream");
                }
            }
            System.out.println("Finished writing data");
        }
    }
    
    /**
     * Converts structured data file into a String for humans to read
     * @param filename the specified file path
     * @return String version of the file
     */
    public static String readData(String filename) {
        InputStream inFile = null;
        DataInputStream inData = null;
        StringBuilder builder = new StringBuilder();
        
        try {
            inFile = new FileInputStream(filename);
            inData = new DataInputStream(inFile);
            
            String name, major;
            int grade;
            char letterGrade;
            boolean passing;
            
            while (true) {
                name = inData.readUTF();
                major = inData.readUTF();
                grade = inData.readInt();
                letterGrade = inData.readChar();
                passing = inData.readBoolean();
                builder.append(String.format("%s (%s): %d (%c), Passing: %b\n", 
                        name, major, grade, letterGrade, passing));
                inData.readChar(); // consume newline character
            }
        } catch (EOFException e) {
            System.out.println("End of file");
        } catch (FileNotFoundException e) {
            System.out.println("Problem opening file for reading");
        } catch (IOException e) {
            System.out.println("Problem writing to file");
        } finally {
            if (inFile != null) {
                try {
                    inFile.close();
                } catch (IOException e) {
                    System.out.println("Problem closing InputStream");
                }
            }
            if (inData != null) {
                try {
                    inData.close();
                } catch (IOException e) {
                    System.out.println("Problem closing DataInputStream");
                }
            }
            System.out.println("Finished reading data");
        }
        return builder.toString();
    }
    
    // [InputStream/OutputStream] Knowledge Check 1:
    /*
     * Write a method that reads a structured data file of the same format as students.txt.
     * 
     * Each record contains:
     * [name][major][grade][letter grade][passing]
     * 
     * Each record has the types:
     * [String][String][int][char][boolean]
     * 
     * The method should extract the name, major, and numerical grade of the student with the 
     * highest grade in the file. The method should return the student’s name, major, and 
     * numerical grade as a sentence. Your method should not throw any Exceptions, nor should 
     * it have any resource leaks. Invoke your method in main() and test it out with some files. 
     */
}
