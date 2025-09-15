package res;

import java.util.Comparator;

/**
 * Example of implementing Comparator interface
 */
public class LivableAreaComparator implements Comparator<House> {
    @Override
    public int compare(House first, House second) {
        double firstArea = first.getLivableArea();
        double secondArea = second.getLivableArea();
        if (firstArea < secondArea) 
            return -1;
        else if (firstArea > secondArea) 
            return 1;
        else
            return first.compareTo(second);
    }
}
