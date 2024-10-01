package client;

import java.util.Scanner;
import res.Processor;

/**
 * Client driver for JavaNestedClassEx2 example.
 */
public class JavaNestedClassEx2 {
    
    /*
     * Knowledge Check 9 for Nested Classes:
     * Add some code to the project JavaNestedClassEx2 so that the user can remove 
     * any of the items of Movable Farm with a specific name. You may have to modify 
     * more than one file, so think carefully about how you would need to design the 
     * code modifications! Test out your new program in the client driver.
     */
    
    /*
     * Knowledge Check 10 for Nested Classes:
     * Add some code to the project JavaNestedClassEx2 so that the user can add “default” 
     * Movable objects to the Movable Farm. You may have to modify more than one file, 
     * so think carefully about how you would need to design the code modifications! 
     * Test out your new program in the client driver.
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Movable Farm!");
        System.out.println("Menu options:\n"
                //+ "  [0] Remove Movable\n"
                + "  [1] Create Movable\n"
                + "  [2] Let farm wander\n"
                + "  [3] Move farm\n"
                + "  [4] Quit");
        
        String line = "";
        while (!line.equals("4")) {
            System.out.println("What would you like to do?");
            line = in.nextLine().trim();
            int choice = Integer.parseInt(line);
            switch (choice) {
                /*case 0:
                    System.out.println("Enter a name to remove:");
                    String nameToRemove = in.nextLine().trim();
                    Processor.removeElementsWithName(nameToRemove);
                    break;*/
                case 1:
                    System.out.println("Enter [name] <space> [verb]:");
                    //System.out.println("Enter [name] <space> [verb] or \"default\"");
                    line = in.nextLine().trim();
                    /*if (line.equals("default")) {
                        Processor.addElement();
                        break;
                    }*/
                    String[] inputs = line.split(" ");
                    if (inputs.length != 2) {
                        System.out.println("Please follow the format.");
                        break;
                    }
                    String name = inputs[0];
                    String verb = inputs[1];
                    Processor.addElement(name, verb);
                    break;
                case 2:
                    Processor.wanderAll();
                    break;
                case 3:
                    System.out.println("Enter a location:");
                    String location = in.nextLine().trim();
                    Processor.moveAllTo(location);
                    break;
            }
        }
        System.out.println("Thank you for visiting Movable Farm!");
        in.close();
    }
}