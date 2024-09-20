import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ziping
 */
public class JavaException_SecuredEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fruitFile;
        Scanner input = new Scanner(System.in);

        /*try{
            System.out.println("please enter a correct file name:");
            fruitFile = input.next();//"fruits.txt";
            File f = new File(fruitFile);
            Scanner contents = new Scanner(f);
            contents.nextLine();//skip the first line
            String[] words = contents.nextLine().split(" ");
            contents.close();
            int aFruit = Integer.parseInt(words[3]);
            System.out.println("the number of fruit is: " + aFruit);
        }
        catch(FileNotFoundException ex){
            System.out.println(ex);
            ex.printStackTrace();
        }  */


        /*boolean validFile = false;
        for(int i = 0; i < 3; i++){
            try{
                System.out.println("please enter a correct file name:");
                fruitFile = input.next();//"fruits.txt";
                File f = new File(fruitFile);
                Scanner contents = new Scanner(f);
                contents.nextLine();//skip the first line
                String[] words = contents.nextLine().split(" ");
                contents.close();
                int aFruit = Integer.parseInt(words[3]);
                System.out.println("the number of fruit is: " + aFruit);
                validFile = true;
                if(validFile)
                    break;
            }
            catch(FileNotFoundException ex){
                System.out.println("wrong file name!");
                if(i == 2)
                    System.out.println("Three wrong entries. Program ends.");
            }
        } */

        doDivisionAndDisplay(input);
    }

    // ERR04-J. Do not complete abruptly from a finally block
    // https://wiki.sei.cmu.edu/confluence/display/java/ERR04-J.+Do+not+complete+abruptly+from+a+finally+block
    public static void doDivisionAndDisplay(Scanner input) {
        try {
            System.out.println("Enter two integers for division: A/B");
            System.out.println("A = ");
            int a = input.nextInt();
            System.out.println("B = ");
            int b = input.nextInt();
            System.out.println(a + " / " + b + " is " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Catch ArithmeticException: "
                    + "Divisor cannot be zero ");
        } /*finally {
            System.out.println("Ready to do another task");
            return;
        }*/

        //return; //place the return statement here instead
    }

    public static void addInfantryLoad(Person p, double load){

    }
}

