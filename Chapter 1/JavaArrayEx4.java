/**
 * This example demonstrates how to work with Strings as array of characters
 * @author ziping
 */
public class JavaArrayEx4 {

    public static void main(String[] args) {
        String sentence = "hello world world olleh";
        char[] arrD = new char[sentence.length()];

        int len = sentence.length();
        for(int i = 0; i < len; i++)
            arrD[i] = sentence.charAt(i);

        System.out.println(reverseArray(arrD));

        // [Call your Knowledge check 1 method here.]
        System.out.println("The sentence is palindrome: " + checkPalindrome(arrD));

        String[] arrWord = sentence.split(" ");
        capEveryOther(arrWord);
        for(String s: arrWord)
            System.out.println(s);

        // [Call your Knowledge check 2 method here.]
        System.out.println("\nPrint trio set: ");
        convertTrioSet(arrWord);
        for(int i = 0; i < arrWord.length; i = i + 3) {
            System.out.printf("%s", arrWord[i]);
            if (i + 1 < arrWord.length)
                System.out.printf("   %s", arrWord[i + 1]);
            if (i + 2 < arrWord.length)
                System.out.printf("   %s", arrWord[i + 2]);
            System.out.println();
        }
        // [Call your Knowledge check 3 method here.]
        System.out.println("\nreplace word: ");
        updateOccurrence(arrWord, "HELLO", "welcome");
        for(String s: arrWord)
            System.out.println(s);
    }

    /**
     * reverse an array of chars and returns it
     * @param arr   an array of chars
     * @return      a reversed array of chars for arr
     */
    public static char[] reverseArray(char[] arr) {
        int len = arr.length;
        char[] result = new char[len];
        for (int i = 0; i < len; i++){
            result[len - i - 1] = arr[i];
        }

        return result;
    }

    // Knowlegde check 1:
    // Write a method that determines if a char array is a palindrome.
    // Call this method in main() method and output the result.
    public static boolean checkPalindrome(char[] arr) {
        int len = arr.length;
        for (int i = 0; i < len/2; i++)
            if(arr[i] != arr[len - 1 - i])
                return false;

        return true;
    }

    /**
     * Capitalize all odd position String and lower case all even position String in a String array
     * @param arr   an array of String
     */
    public static void capEveryOther(String[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++)
            if(i%2 != 0)
                arr[i] = arr[i].toUpperCase();
            else
                arr[i] = arr[i].toLowerCase();
    }

    // Knowlegde check 2:
    // Write a method that will do the following for each set of three string elements in an array:
    // 1. convert the first element of the set to uppercase
    // 2. keep the second element of the set unchanged
    // 3. convert the third element of the set to lowercase
    // Call this method in main() method and output the result.
    public static void convertTrioSet(String[] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            if(i % 3 == 0)
                arr[i] = arr[i].toUpperCase();
            if(i % 3 == 2)
                arr[i] = arr[i].toLowerCase();
        }
    }

    /**
     * find the first occurrence of a String in an array of String
     * @param arr   an array of String
     * @param str   a String
     * @return      the position of the first occurrence of str in arr
     */
    public static int findFirstOccurrence(String[] arr, String str) {
        int len = arr.length;
        for(int i = 0; i < len; i++)
            if(arr[i].equals(str))
                return i;

        return -1;
    }

    // Knowlegde check 3:
    // Write a method that, when given a String array, “target” String, and “replacement” String,
    // tries to replace all occurrences of the “target” String with the “replacement” String.
    // Call this method in main() method and output the result.
    public static void updateOccurrence(String[] arr, String target, String replacement) {
        int len = arr.length;
        for(int i = 0; i < len; i++)
            if(arr[i].equals(target))
                arr[i] = replacement;
    }

}
