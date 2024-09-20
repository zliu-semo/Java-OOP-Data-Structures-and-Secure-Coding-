package my.pkg;

/**
 * Define a "good" superclass.
 * @author ziping
 *
 */
public class DatabaseMember implements Cloneable {
    // Uncomment for secure coding: final class
//public final class DatabaseMember implements Cloneable {
    // N is at least 1.
    private static final int N = 3;

    // Reference to array object in heap cannot be changed.
    private final int[] data = new int[N];

    // Flag
    private boolean shared = false;

    public DatabaseMember() {
        for (int i = 0; i < N; i++) {
            data[i] = 10 * (i + 1);
        }
    }

    /**
     * Fills in as many elements of {@code this.data} as possible, until
     * either the input parameter runs out of elements or {@code this.data}
     * runs out of spots.
     * @param data The input integer array.
     */
    public DatabaseMember(int[] data) {
        this();
        if (data != null && data.length >= 1) {
            int cap = Math.min(data.length, N);
            for (int i = 0; i < cap; i++) {
                this.data[i] = data[i];
            }
        }
    }

    @Override
    public final String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("data: ");
        for (int i = 0; i < N; i++) {
            builder.append(data[i]);
            builder.append(", ");
        }
        // Remove last comma and space before returning as a String.
        return builder.substring(0, builder.length() - 2);
    }

    public final void toggleShared() {
        if (!shared) {  // set to "shared" to prevent updating.
            shared = true;
        }
    }

    public final void updateContents() {
        if (!shared) {
            for (int i = 0; i < N; i++) {
                data[i] = -data[i];  // only negate data if NOT "shared"
            }
        }
    }

    /**
     * @return Deep copy of the {@code data} array.
     */
    final int[] getData() {
        /*
         * Java array's clone() method makes a copy up to one level.
         * The resulting array is a copy of the original, but the elements
         * may be aliases if the elements are reference-type objects.
         * In our case, the array holds primitives, so the shallow copy
         * that results from Java array's clone() method is equivalent to
         * a deep copy of an int[].
         */
        return data.clone();
    }
}

