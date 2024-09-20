/**
 *
 * @author ziping
 */
public class Person {
    //define person's name, age, weight and height as private instance variables
    private String mName;
    private int mAge;
    private double mWeight, mHeight;

    //constructor without parameters(default constructor)
    public Person(){
        mName = "default";
        mAge = 1;
        mWeight = 7.5;
        mHeight = 1.05;
    }

    //constructor with parameters(explicit-value constructor)
    public Person(String pName, int pAge, double pWeight, double pHeight){
        mName = pName;
        mAge = pAge;
        mWeight = pWeight;
        mHeight = pHeight;
    }

    //public accessor or get method to retrieve person's name
    public String getName(){
        return mName;
    }

    //public accessor or get method to retrieve person's age
    public int getAge(){
        return mAge;
    }

    public double getWeight(){
        return mWeight;
    }

    public double getHeight(){
        return mHeight;
    }

    public void setName(String pName) {
        if (pName != null && pName.length() != 0) {
            mName = pName;
        } else {
            System.out.println("please use a non-null, non-empty name");
        }
    }

    public double addLoad(double w){
        mWeight += 5.0; // backpack weight
        try{
            if (w < 0.0 || w > 90.0)
                throw new IllegalArgumentException();
            return mWeight + w;
        }catch(IllegalArgumentException ex){
            System.out.println("added weight should be between 0-90");
            return -1.0;
        }
    }

    public void setHeight(double h){
        if (h > 0.0 && h <= 10.0)
            mHeight += h;
        else
            System.out.println("added height should be between 0-10");
    }

    //public mutator or set method to assign a person's name, age, weight and height
    //to the given name, age, weight and height via parameters
    public void setPerson(String pName, int pAge, double pWeight, double pHeight){
        setName(pName);
        mAge = pAge;
        mWeight = pWeight;
        mHeight = pHeight;
    }

    //public instance method to return a person's information as a string
    @Override
    public String toString() {
        return "Name: " + mName + "\n" +
                "Age: " + mAge + "\n" +
                "Weight: " + mWeight + "\n" +
                "Height: " + mHeight + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Person) {
            Person other = (Person) o;
            return (this.mName.equals(other.getName()) &&
                    this.mAge == other.getAge() &&
                    this.mWeight == other.mWeight &&
                    this.mHeight == other.mHeight);
        }
        return false;
    }
}

