package resources;

public enum Month {
    /*JAN,
    FEB,
    MAR,
    APR,
    MAY,
    JUN,
    JULY,
    AUG,
    SEPT,
    OCT,
    NOV,
    DEC  */

    /*
     * Knowledge check 1:
     * Re-write the Month enum so that the Month name is captured within
     * each of the Month constants. You may have to define additional fields
     * and/or methods here.
     */
    JAN(1, "January"),
    FEB(2, "February"),
    MAR(3, "March"),
    APR(4, "April"),
    MAY(5, "May"),
    JUN(6, "June"),
    JULY(7, "July"),
    AUG(8, "August"),
    SEPT(9, "September"),
    OCT(10, "October"),
    NOV(11, "November"),
    DEC(12, "December");

    private final int monthInt;
    private final String monthStr;

    Month(int num, String name) {
        monthInt = num;
        monthStr = name;
    }
}

