package res;

/**
 * Example of outer/inner classes
 */
public class Counter {
    private int count1;
    private int count2;
    private static int totalCounters;
    private int numSmallCounters;
    
    /*
     * Knowledge Check 2 for Nested Classes:
     * Create an aggregation relationship between Counter and its inner class.
     * Increment the aggregated object's fields whenever the Counter object's
     * fields are incremented. Examine the behavior of this modified class
     * definition in the client program.
     */
    
    private static StaticSmallCounter staticSmallCounter1 = 
            new StaticSmallCounter(0, "increment1 counter");
    private static StaticSmallCounter staticSmallCounter2 = 
            new StaticSmallCounter(0, "increment2 counter");
    
    public Counter() {
        count1 = 1;
        count2 = 1;
        numSmallCounters = 0;
        totalCounters++;
    }
    
    public Counter(int x, int y) {
        count1 = x;
        count2 = y;
        numSmallCounters = 0;
        totalCounters++;
    }
    
    public int getCount1() {
        return count1;
    }
    
    public int getCount2() {
        return count2;
    }
    
    public static int getTotalCounters() {
        return totalCounters;
    }
    
    public int getNumSmallCounters() {
        return numSmallCounters;
    }
    
    public void incrementCount1() {
        count1++;
        staticSmallCounter1.num++;
    }
    
    public void incrementCount2() {
        count2++;
        staticSmallCounter2.num++;
    }
    
    @Override
    public String toString() {
        return String.format("Count 1: %d; Count 2: %d", count1, count2);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (o.getClass() == getClass()) {
            Counter other = (Counter) o;
            return (other.count1 == count1 && 
                    other.count2 == count2);
        }
        return false;
    }
    
    public static String getStaticSmallCounterStrings() {
        return String.format("staticSmallCounter1---> %s\n"
                + "staticSmallCounter2---> %s", 
                staticSmallCounter1.toString(), staticSmallCounter2.toString());
    }
    
    public int[][] createTapestry(String str) {
        class Tapestry {
            static final int MIN = 0;
            static final int MAX = 25;
            String name;
            int delta;
            int[][] data;
            int dim;
            
            Tapestry(String name) {
                this.name = name;
                delta = Math.abs(Counter.this.count1) + Math.abs(Counter.this.count2);
                dim = MAX / delta;
                data = new int[dim][dim];
            }
            
            void printBasicInfo() {
                System.out.println("Tapestry name: " + name);
                System.out.println("Dimension: " + dim);
            }
            
            void populateData() {
                for (int j = 0; j < dim; j++) {
                    int curr = delta * j;
                    if (curr < MIN) curr = MIN;
                    if (curr > MAX) curr = MAX;
                    data[0][j] = curr;
                    for (int i = 0; i < dim; i++) {
                        data[i][j] = curr * i;
                    }
                }
            }
        }
        Tapestry t = new Tapestry(str);
        t.printBasicInfo();
        t.populateData();
        return t.data;
    }
    
    /**
     * Non-static inner class
     */
    public class SmallCounter {
        private int smallCount1;
        private int smallCount2;
        // Cannot add static member to non-static inner class.
        // private static int variableName;
        
        public SmallCounter() {
            smallCount1 = 0;
            smallCount2 = 0;
            // Counter.this.numSmallCounters++;
            numSmallCounters++;
        }
        
        public SmallCounter(int x, int y) {
            smallCount1 = x;
            smallCount2 = y;
            // Counter.this.numSmallCounters++;
            numSmallCounters++;
        }
        
        public int getSmallCount1() {
            return smallCount1;
        }
        
        public int getSmallCount2() {
            return smallCount2;
        }
        
        public void incrementSmallCount1() {
            // smallCount1 += count1;
            smallCount1 += Counter.this.count1;
            staticSmallCounter1.num++;
        }
        
        public void incrementSmallCount2() {
            // smallCount2 += count2;
            smallCount2 += Counter.this.count2;
            staticSmallCounter2.num++;
        }
        
        @Override
        public String toString() {
            return String.format("Outer: %s\n"
                    + "Small Count 1: %d; Small Count 2: %d", 
                    Counter.this.toString(), smallCount1, smallCount2);
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            
            if (o.getClass() == getClass()) {
                SmallCounter other = (SmallCounter) o;
                return (other.smallCount1 == smallCount1 &&
                        other.smallCount2 == smallCount2); 
            }
            return false;
        }
    }
    
    /**
     * Static nested class
     */
    public static class StaticSmallCounter {
        private int num;
        private String name;
        private static int totalStaticSmallCounters;
        
        public StaticSmallCounter() {
            num = 0;
            name = "Default";
            totalStaticSmallCounters++;
            // Cannot access non-static members of outer class.
            // numSmallCounters++;
        }
        
        public StaticSmallCounter(int x, String s) {
            num = x;
            name = s;
            totalStaticSmallCounters++;
            // Cannot access non-static members of outer class.
            // numSmallCounters++;
        }
        
        public int getNum() {
            return num;
        }
        
        public String getName() {
            return name;
        }
        
        public static int getTotalStaticSmallCounters() {
            return totalStaticSmallCounters;
        }
        
        public void incrementNum() {
            num++;
        }
        
        @Override
        public String toString() {
            return String.format("Num: %d; Name: %s", num, name);
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            
            if (o.getClass() == getClass()) {
                StaticSmallCounter other = (StaticSmallCounter) o;
                return (other.num == num &&
                        other.name.equals(name));
            }
            return false;
        }
    }
}
