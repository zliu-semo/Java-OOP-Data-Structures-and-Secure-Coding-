package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import res.*;

public class Main {
    private static final String OUTPUT_POSTFIX_FILE = "files/output_postfix.txt";

    public static void main(String[] args) {
        System.out.println("Welcome to RPN Processor.");
        
        int choice;
        String filename;
        System.out.println("What would you like to do?\n"
                + "[1] Evaluate postfix expressions\n"
                + "[2] Convert infix to postfix");
        Scanner in = new Scanner(System.in);
        choice = Integer.parseInt(in.nextLine().trim());
        System.out.println("Enter a filename:");
        filename = in.nextLine().trim();
        PostfixProcessor processor = new PostfixProcessor();
        
        Scanner tokens = null;
        FileWriter out = null;
        try {
            tokens = new Scanner(new File(filename));
            out =  new FileWriter(OUTPUT_POSTFIX_FILE);
            String expression = null;
            while (tokens.hasNextLine()) {
                expression = tokens.nextLine().trim();
                switch (choice) {
                    case 1:
                        double answer = processor.evalPostfixExpression(expression);
                        System.out.println("Answer: " + answer);
                        System.out.println();
                        break;
                    case 2:
                        String postfix = processor.convertToPostfix(expression);
                        System.out.println("Postfix: " + postfix);
                        System.out.println();
                        out.write(postfix + "\n");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename + " not found");
        } catch (IOException e) {
            System.out.println("Error in writing file.");
        } finally {
            if (tokens != null) {
                tokens.close();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing writer.");
            }
        }
        
        in.close();
    }
}