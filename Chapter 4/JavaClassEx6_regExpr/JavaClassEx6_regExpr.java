import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ziping
 */
public class JavaClassEx6_regExpr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String Regular Expression: regex
        System.out.println("Java".matches("Java"));
        System.out.println("Java".equals("Java"));
        System.out.println();

        System.out.println("Java vs Python".matches("Java.*"));
        System.out.println("Java is Object Oriented".matches("Java.*"));
        System.out.println();

        System.out.println("xxx Java is popular".matches(".*Java.*"));
        System.out.println("xxx Java is popular".matches("Java.*"));
        System.out.println();

        System.out.println("no lemon no melon".matches("^no.*"));
        System.out.println("no lemon no melon".matches(".*lon$"));
        System.out.println("no lemon no melon".matches(".*\\slemon\\s.*"));
        System.out.println();

        String query = "Java,Python?JavaScript,TypeScript";
        String[] tokens = query.split("[.,:;?]");
        for (int i = 0; i < tokens.length; i++)
            System.out.println(tokens[i]);
        System.out.println();

        String s5 = "Hello +=* World 9 8 ";
        System.out.println(filter(s5));
        System.out.println();

        s5 = filter("no lemon, no melon");
        String s6 = reverse(s5);
        System.out.println("palindrome: " + s6.equals(s5));
        System.out.println("both String instances are the same object: " + (s5 == s6));
        System.out.println();

        //use Pattern and Matcher to check
        String stringToSearch = "xxx JaVa is popular";
        Pattern p = Pattern.compile("Java.*", Pattern.CASE_INSENSITIVE);   // the pattern to search for
        Matcher m = p.matcher(stringToSearch);
        System.out.println("Pattern and Matcher checking: " + m.find());
        System.out.println();

        // digit character
        stringToSearch = "xxx JaVa8 is popular";
        p = Pattern.compile("Java\\d", Pattern.CASE_INSENSITIVE);
        m = p.matcher(stringToSearch);
        System.out.println("Pattern and Matcher, digit character: " + m.find());
        System.out.println();

        p = Pattern.compile("\\bJava\\b", Pattern.CASE_INSENSITIVE);
        m = p.matcher(stringToSearch);
        System.out.println("Pattern and Matcher; \\b, \\b: " + m.find());

        p = Pattern.compile("\\bJava\\B", Pattern.CASE_INSENSITIVE);
        m = p.matcher(stringToSearch);
        System.out.println("Pattern and Matcher; \\b, \\B:  " + m.find());

        p = Pattern.compile("\\BJava\\b", Pattern.CASE_INSENSITIVE);
        m = p.matcher(stringToSearch);
        System.out.println("Pattern and Matcher; \\B, \\b:  " + m.find());
        System.out.println();

        // Knowledge check 1: Regular expression to check
        // whether “Java” appeared in the middle of another standalone
        // word in the query String?
        p = Pattern.compile("\\BJava\\B", Pattern.CASE_INSENSITIVE);
        String stringToSearch2 = "xxx 8JaVa8 is popular";
        m = p.matcher(stringToSearch2);
        System.out.println("Pattern and Matcher; \\B, \\B:  " + m.find());
        System.out.println();

        // Knowledge check 1 solution:
        //p = Pattern.compile("\\BJava\\B", Pattern.CASE_INSENSITIVE);

        stringToSearch = "on- no lemon24 no melon10001";
        //p = Pattern.compile("on\\d*", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile("on\\d+", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile("on\\d?", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile("on\\d{3}", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile("on\\d{10}", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile("on\\d{2,}", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile("on\\d{0,4}", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile("on\\d{2,4}", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile(".{1}on.*?", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile(".{1}on.*", Pattern.CASE_INSENSITIVE);
        //p = Pattern.compile(".{1}on.*+", Pattern.CASE_INSENSITIVE);
        p = Pattern.compile(".{1}on.*\\B", Pattern.CASE_INSENSITIVE);
        m = p.matcher(stringToSearch);
        while (m.find()) {
            System.out.printf("\"%s\": start index %d; end index %d.\n",
                    m.group(), m.start(), m.end());
        }
        System.out.println("No more matches\n");

        // Knowledge check 2: Regular expression would you use to
        // represent a pattern (of any length, including zero length)
        // that consists only of letters and numbers?
        // Write it once using range and union. Write it again using
        // subtraction. CHALLENGE: Use only negation.

        // Knowledge check 2 solution:
        // Range: "[a-z[A-Z[0-9]]]*"
        // Subtraction: "[\\w[^_]]*"
        // Negation: "[^\W_]"

        // Matcher group(int) example
        stringToSearch = "Dandelions ARE yellow, and I have 10.\n"
                + "Daffodils are yellow, and I have 8.\n"
                + "Roses are red--have 16.\n"
                + "Violets are blue. I have 1.\n"
                + "MagNOlias are white, and I have 3.\n"
                + "Cherry BLOssoms are pink, and I have 22.\n"
                + "Irises are purple, and I have 6.\n"
                + "Camellias are pink; I hAve 5.\n"
                + "Bluebells are blue and I havE 2.";
        p = Pattern.compile("\\b([a-z[A-Z[ ]]]+?)\\b are \\b([a-z[A-Z]]+?)\\b.*?\\bhave\\b (\\d+)\\b",
                Pattern.CASE_INSENSITIVE);
        m = p.matcher(stringToSearch);
        while (m.find()) {
            System.out.println(m.group(0));
            System.out.printf("FLOWER: %s; COLOR: %s; OWNED: %s\n\n",
                    m.group(1).toLowerCase(), m.group(2).toLowerCase(), m.group(3));
        }
        System.out.println("No more matches\n");

        // Knowledge check 3: Delete exactly one character from query
        // so that the program will skip the DANDELIONS output.

        // Knowledge check 3 solution:
        // any of the letters in "are"
        // any of the letters in "have"
        // any of the spaces before/after "are" or "have"

        // Simple lookahead example:
        p = Pattern.compile("\\b[a-z[A-Z[ ]]]+?\\b(?= are yellow)", Pattern.CASE_INSENSITIVE);
        m = p.matcher(stringToSearch);
        while (m.find())
            System.out.println(m.group().toLowerCase());
        System.out.println("No more matches\n");

        // Knowledge check 4: Use a regular expression to extract only the names of the flowers
        // whose color ends with an “e”. Then, output the result.

        // Knowledge check 4 solution:
        //p = Pattern.compile("\\b[a-z[A-Z[ ]]]+?\\b(?= are [a-z[A-Z]]+?e\\b)", Pattern.CASE_INSENSITIVE);
        /*
         * Output:
         * violets
         * magnolias
         * irises
         * bluebells
         * No more matches
         */

        // Another lookahead example:
        stringToSearch = "Hey, diddle, diddle,\n" +
                "The cat and the fiddle,\n" +
                "The cow jumped over the moon;\n" +
                "The little dog laughed\n" +
                "To see such sport,\n" +
                "And the dish ran away with the spoon.";
        String[] lines = stringToSearch.split("\n");
        p = Pattern.compile("^(?=.*[,;.])(?=.*\\bthe\\b).*$");
        for (String s: lines) {
            m = p.matcher(s);
            if (m.find())
                System.out.println(m.group());
        }
        System.out.println("No more matches\n");

        // Knowledge check 5: Use a regular expression to pick out lines that:
        // (1) contain 'o'
        // (2) are more than twenty characters long
        // Output your result.

        // Knowledge check 5 solution:
        //p = Pattern.compile("^(?=.*o).{21,}$");
        /*
         * Output:
         * The cow jumped over the moon;
         * The little dog laughed
         * And the dish ran away with the spoon.
         * No more matches
         */

    }

    /** Create a new string by eliminating non-alphanumeric chars */
    public static String filter(String s) {
        s = s.replaceAll("[^a-z&&[^A-Z]&&[^0-9]]", "");
        return s;
    }

    /** Create a new string by reversing a specified string */
    public static String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse(); // Invoke reverse in StringBuilder
        return stringBuilder.toString();
    }
}

