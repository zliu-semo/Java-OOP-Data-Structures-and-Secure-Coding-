package resources;

public enum Day {
    // define a list of constants which hold values from 0 to 6
    // num and name are passed to the constructor when constants are created
    MON(0, "Monday"),
    TUE(1, "Tuesday"),
    WED(2, "Wednesday"),
    THUR(3, "Thursday"),
    FRI(4, "Friday"),
    SAT(5, "Saturday"),
    SUN(6, "Sunday");

    // properties of enum Day
    private final int dayInt;
    private final String dayName;

    // constructor of enum Day
    private Day(int num, String name) {
        dayInt = num;
        dayName = name;
    }

    // methods of enum Day
    public int getDayInt() {
        return dayInt;
    }

    public String getDayName() {
        return dayName;
    }
}

