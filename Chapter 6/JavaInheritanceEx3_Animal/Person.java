package animal;

/**
 *
 * @author ziping
 */
public class Person {
    //define person's name, age as private instance variables
    private String mName;
    private int mAge;

    //constructor without parameters(default constructor)
    public Person(){
        mName = "default";
        mAge = 1;
    }

    //constructor with parameters(explicit-value constructor)
    public Person(String pName, int pAge){
        mName = pName;
        mAge = pAge;
    }

    //public accessor or get method to retrieve person's name
    public String getName(){
        return mName;
    }

    //public accessor or get method to retrieve person's age
    public int getAge(){
        return mAge;
    }

    // public mutator or set method to change a person's name to the given
    // name via user input parameter
    public void setName(String pName) {
        if (pName != null && pName.length() != 0) {
            mName = pName;
        } else {
            System.out.println("please use a non-null, non-empty name");
        }
    }

    public void setAge(int pAge){
        mAge = pAge;
    }

    //public instance method to return a person's information as a string
    @Override
    public String toString() {
        return "Name: " + mName + "\n" +
                "Age: " + mAge + "\n" ;
    }
}

