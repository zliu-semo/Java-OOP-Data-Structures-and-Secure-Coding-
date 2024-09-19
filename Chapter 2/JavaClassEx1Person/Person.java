/**
 * Define a Person class which has the properties of a person's name, age, weight and height
 * @author ziping
 */
public class Person {
    //define person's name, age, weight and height as private instance variables
    private String mName;
    private int mAge;
    private double mWeight, mHeight;

    /**
     * Person class's constructor without parameters(default constructor)
     *
     */
    public Person(){
        mName = "default";
        mAge = 1;
        mWeight = 7.5;
        mHeight = 1.05;
    }

    /**
     * Person class's constructor with parameters(explicit-value constructor)
     * @param pName     a String type parameter to be assigned to instance variable mName
     * @param pAge      an int type parameter to be assigned to instance variable mAge
     * @param pWeight   a double type parameter to be assigned to instance variable mWeight
     * @param pHeight   a double type parameter to be assigned to instance variable mHeight
     */
    public Person(String pName, int pAge, double pWeight, double pHeight){
        mName = pName;
        mAge = pAge;
        mWeight = pWeight;
        mHeight = pHeight;
    }

    /**
     * public accessor/get method to retrieve a person's name
     * @return      the name of the person
     */
    public String getName(){
        return mName;
    }

    /**
     * public accessor or get method to retrieve person's age
     * @return      the age of the person
     */
    public int getAge(){
        return mAge;
    }

    // Knowledge check 1:
    // add accessors or get methods for weight and height
    // testing your newly added instance methods in main()
    public double getWeight(){
        return mWeight;
    }

    public double getHeight(){
        return mHeight;
    }

    /**
     * public mutator or set method to assign a person's name to the given name via parameter     *
     * @param pName     A String to be assigned to the person's name
     */
    public void setName(String pName) {
        if (pName != null && pName.length() != 0) {
            mName = pName;
        } else {
            System.out.println("please use a non-null, non-empty name");
        }
    }

    // Knowledge check 2:
    // add mutators or set methods for age, weight and height
    // testing your newly added instance methods in main()
    public void setAge(int age){
        if(age > 0 && age < 200)
            mAge = age;
    }

    public void setWeight(double weight){
        if(weight > 0 && weight < 500)
            mWeight = weight;
    }

    public void setHeight(double height){
        if(height > 0 && height < 8)
            mHeight = height;
    }

    //public mutator or set method to assign a person's name, age, weight and height
    //to the given name, age, weight and height via parameters
    /**
     * public mutator or set method to assign a person's name, age, weight and height
     * to the given name, age, weight and height via parameters
     * @param pName     a String type parameter to be assigned to instance variable mName
     * @param pAge      an int type parameter to be assigned to instance variable mAge
     * @param pWeight   a double type parameter to be assigned to instance variable mWeight
     * @param pHeight   a double type parameter to be assigned to instance variable mHeight
     */
    public void setPerson(String pName, int pAge, double pWeight, double pHeight){
        setName(pName);
        mAge = pAge;
        mWeight = pWeight;
        mHeight = pHeight;
    }

    /**
     * public mutator or set method to assign a person's name, keyword "this" refers to object itself
     * @param mName     A String type parameter to be assigned to instance variable mName
     */
    public void setName2(String mName){
        if (mName != null && mName.length() != 0) {
            this.mName = mName;
        } else {
            System.out.println("please use a non-null, non-empty name");
        }
    }

    /**
     * public accessor to retrieve object itself
     * @return      object itself
     */
    public Person getSelf() {
        return this;
    }

    /**
     * public accessor to get a deep copy of the object
     * @return      the deep copy of the person
     */
    public Person getClone() {
        Person clonePerson = new Person(this.mName, this.mAge, this.mWeight, this.mHeight);
        return clonePerson;
    }

    /**
     * public instance method to output a string as person's talk
     * @param msg       a String message to be output
     */
    public void talk(String msg) {
        System.out.println(this.mName + ">> " + msg);
    }

    /**
     * public instance method to return a person's information as a string
     * @return      person's name, age, weight and height as specified format
     */
    @Override
    public String toString() {
        return "Name: " + mName + "\n" +
                "Age: " + mAge + "\n" +
                "Weight: " + mWeight + "\n" +
                "Height: " + mHeight + "\n";
    }

    /**
     * public instance method to output a person's name, age, weight and height
     */
    public void introduceSelf(){
        System.out.println("let me introduce myself");
        System.out.println(this.toString());
    }

    /**
     * public instance method to compare two person objects
     * @param o     another person object
     * @return      true if two person objects have the same name, age, weight and height; O/W, return false
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Person) {
            Person other = (Person) o;
            return (this.mName.equals(other.getName()) &&
                    this.mAge == other.getAge() &&
                    this.mWeight == other.getWeight() &&
                    this.mHeight == other.getHeight());
        }
        return false;
    }

    // Knowledge check 4:
    // write a public instance method called eat() which will describe a person's
    // favorite food
    // testing your newly added instance methods in main()
    public void eat(String food){
        System.out.println("My favorite food is: " + food);
    }
}
