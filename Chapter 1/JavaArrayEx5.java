/**
 * demonstrate how to use 2-D array
 * @author ziping
 */
public class JavaArrayEx5 {
    public static void main(String[] args) {
        int[][] arrE = new int[2][3];

        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 3; j++)
                arrE[i][j] = i + j;

        System.out.println("the average of arrE is: " + avg(arrE));

        int jLen = arrE[0].length;
        int[] colSumArr = new int[jLen];
        colSumArr = sumOfColumn(arrE);
        System.out.println("\nThe column Sum is: ");
        for(int j = 0; j < jLen; j++){
            System.out.printf("%7d", colSumArr[j]);
        }
        System.out.print("\n\nThe number of occurrence of sea is: ");

        // [Call your Knowledge check 1 method here.]

        String poem = "Sally sells sea shells by the sea shore\n" +
                "She sells sea shells on the sea shell shore\n" +
                "The sea shells she sells are sea shore shells\n" +
                "Of that I'm sure.";
        String[] lines = poem.split("\n");
        String[][] words = new String[lines.length][];
        int row = 0;
        for(String line: lines){
            words[row] = line.split(" ");
            row++;
        }

        System.out.println(countOccurrence(words, "sea"));

        // [Call your Knowledge check 2 method here.]
        System.out.println("\nThe rewritten poem:");
        replaceOccurrenceWord(words, "sea", "ocean");
        for(String[] line: words) {
            for (String s : line)
                System.out.print(s + " ");
            System.out.println();
        }

    }

    // can handle jagged array

    /**
     * calculate the average for a 2-D array
     * @param arr   a 2-D array
     * @return      the average of the 2-D array arr
     */
    public static double avg(int[][] arr) {
        double sum = 0.0;
        int count = 0;
        int ilen = arr.length;
        for (int i = 0; i < ilen; i++) {
            int jlen = arr[i].length;
            for (int j = 0; j < jlen; j++) {
                sum += arr[i][j];
                count++;
            }
        }
        return sum / count;
    }

    // Knowlegde check 1:
    // Write a method to calculate the sum of a given column.
    // Call this method in main() method and output the result.
    public static int[] sumOfColumn(int[][] arr) {
        int jLen = arr[0].length;
        int iLen = arr.length;
        int[] sumCol = new int[jLen];
        for(int j = 0; j < jLen; j++)
            for(int i = 0; i < iLen; i++ )
                sumCol[j] += arr[i][j];

        return sumCol;
    }

    /**
     * find the number of occurrence of a word in a 2-D String array
     * @param arr   a 2-D String array
     * @param word  the word to be found in arr
     * @return      the number of occurrence of word in arr
     */
    public static int countOccurrence(String[][] arr, String word){
        int count = 0;
        for(String[] line: arr) {
            for(String s: line)
                if(s.equals(word))
                    count++;
        }

        return count;
    }

    // Knowlegde check 2:
    // Write a method to replace a given word in a 2D string array with another word.
    // Call this method in main() method and output the result.
    public static void replaceOccurrenceWord(String[][] arr, String target, String replacement){
        int iLen = arr.length;
        for(int i = 0; i < iLen; i++)
            for(int j = 0; j < arr[i].length; j++)
                if(arr[i][j].equals(target))
                    arr[i][j] = replacement;
    }
}
