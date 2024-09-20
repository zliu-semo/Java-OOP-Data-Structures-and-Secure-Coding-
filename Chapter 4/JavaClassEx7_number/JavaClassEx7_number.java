import java.lang.Integer;
/**
 *
 * @author ziping
 */
public class JavaClassEx7_number {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creating Integers:
        // Option 1: explicit-value constructor
        Integer x = new Integer(100);
        // Option 2: autoboxing
        // Integer x = 100;

        int xp = x.intValue();
        System.out.println("x + 190 = " + (xp + 190));
        // System.out.println("x + 190 = " + (x + 190));

        modifyI(x); // x won't be changed because Integer is immutable
        System.out.println("Integer is immutable, x = " + x.toString());

        Integer x2 = Integer.valueOf("200"); // convert String to integer
        int x3 = Integer.parseInt("300"); // convert String to int
        System.out.println("x2 + 290 = " + (x2 + 290));
        System.out.println("x3 + 390 = " + (x3 + 390));

        // array element's value changed
        int[] arr = new int[1];
        arr[0] = 200;
        modifyarr(arr);
        System.out.println("check if int array element modified: " + arr[0]);

        // array element's reference changed
        Integer[] arrI = new Integer[1];
        arrI[0] = x2;
        modifyIntegerArr(arrI);
        System.out.println("check if Integer array element modified: " + arrI[0]);
    }

    public static void modifyI(Integer I) {
        I = -100;
    }

    public static void modifyarr(int[] parr) {
        parr[0] = 999;
    }

    public static void modifyIntegerArr(Integer[] IArr) {
        IArr[0] = -999;
    }
}

