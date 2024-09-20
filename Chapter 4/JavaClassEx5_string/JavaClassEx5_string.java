import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ziping
 */
public class JavaClassEx5_string {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String s1 = "Hello World";
        concat1(s1);  // s1 is not changed
        System.out.println("check if string is immutable: " + s1);

        System.out.println(s1.concat(", welcome to Java!"));
        System.out.println("check if s1 is updated: " + s1);

        System.out.println("is s1 before Kello World? " + s1.compareTo("Kello World"));

        String formats = String.format("%s\t%d\t%.2f", s1, 100, 1.98999);
        System.out.println(formats);

        String replacedStr = "Java,Python?JavaScript,TypeScript".replaceAll("Java", "Lama");
        System.out.println(replacedStr);

        replacedStr = "Java,Python?JavaScript,TypeScript".toUpperCase();
        System.out.println(replacedStr);

        StringBuilder s2 = new StringBuilder("Hello World"); // String converted to StringBuilder
        concat2(s2); // s2 is changed
        System.out.println("check if StringBuilder is immutable: " + s2);
        String s;
        s = s2.toString(); // StringBuilder converted to String
        System.out.println("check StringBuilder convert to String: " + s instanceof String);

        StringBuffer s3 = new StringBuffer("Hello World"); // String converted to StringBuffer
        concat3(s3); // s3 is changed
        System.out.println("StringBuffer: " + s3);

    }

    public static void concat1(String s1) {
        s1 = s1 + " Welcome";
    }

    // Concatenates to StringBuilder
    public static void concat2(StringBuilder s2) {
        s2.append(" Welcome");
    }

    // Concatenates to StringBuffer
    public static void concat3(StringBuffer s3) {
        s3.append(" Welcome");
    }

}

