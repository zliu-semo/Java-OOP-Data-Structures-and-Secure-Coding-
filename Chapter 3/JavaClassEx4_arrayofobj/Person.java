/**
 *
 * @author ziping
 */
public class Person {
    //define person's name, age, weight and height as private instance variables
    private String mName;
    private int mAge;
    private double mWeight, mHeight;
    //define class variable for counting of person instances and initialize it to zero
    private static int mCount = 0;

    private Outfit mOutfit;
    //define a constant instance variable which can be initialized in constructor
    private final String mParents;

    //constructor without parameters(default constructor)
    public Person(){
        mName = "default";
        mAge = 1;
        mWeight = 7.5;
        mHeight = 1.05;

        mOutfit = new Outfit();

        mCount++;

        mParents = "Mr. and Mrs. default";
    }

    //constructor with parameters(explicit-value constructor)
    public Person(String pName, int pAge, double pWeight, double pHeight, Outfit pOutfit, String pParents){
        mName = pName;
        mAge = pAge;
        mWeight = pWeight;
        mHeight = pHeight;

        Outfit cloneOutfit = new Outfit(pOutfit.getType(), pOutfit.getColor(), pOutfit.getSize());
        mOutfit = cloneOutfit; //be careful of shallow copy issue

        mCount++;

        mParents = "Mr. and Mrs. " + pParents;
    }

    //public accessor or get method to retrieve person's name
    public String getName(){
        return mName;
    }

    //public accessor or get method to retrieve person's age
    public int getAge(){
        return mAge;
    }

    //for knowledge check 8
    public double getHeight(){
        return mHeight;
    }

    //be careful of exposing private instance variable reference issue
    public Outfit getOutfit(){
        //return mOutfit;
        Outfit temp = new Outfit(mOutfit.getType(), mOutfit.getColor(), mOutfit.getSize());
        return temp;
    }

    //public mutator or set method to assign a person's name to the given name
    //via parameter
    public void setName(String pName){
        mName = pName;
    }

    //be careful of shallow copy vs deep copy issue
    public void setOutfit(Outfit pOutfit){
        Outfit cloneOutfit = new Outfit(pOutfit.getType(), pOutfit.getColor(), pOutfit.getSize());
        mOutfit = cloneOutfit;
    }

    //public mutator or set method to assign a person's name, age, weight, height and outfit
    //to the given name, age, weight, height and outfitvia parameters
    public void setPerson(String pName, int pAge, double pWeight, double pHeight, Outfit pOutfit){
        mName = pName;
        mAge = pAge;
        mWeight = pWeight;
        mHeight = pHeight;
        Outfit cloneOutfit = new Outfit(pOutfit.getType(), pOutfit.getColor(), pOutfit.getSize());
        mOutfit = cloneOutfit; //be careful of shallow copy issue
        //m_parents = "xxx";  //uncomment this statement will give error: cannot assign value to a final variable
    }

    // keyword "this" refers to object itself
    public void setName2(String m_name){
        this.mName = m_name;
    }

    public void introduceSelf(){
        System.out.println("let me introduce myself");
        System.out.println(this.toString());
    }

    public Person getSelf(){
        return this;
    }

    public Person getClone(){
        Person clonePerson = new Person(this.mName, this.mAge, this.mWeight, this.mHeight, this.mOutfit, this.mParents);
        return clonePerson;
    }

    public void talk(String msg){
        System.out.println(msg);
    }

    //public instance method to return a person's information as a string
    @Override
    public String toString(){
        return "Name: " + mName + "\n" +
                "Age: " + mAge + "\n" +
                "Weight: " + mWeight + "\n" +
                "Height: " + mHeight + "\n" +
                "Outfit: " + mOutfit + "\n" +
                "Parents: " + mParents + "\n";
    }

    @Override
    public boolean equals(Object o){
        Person other = (Person)o;
        return (this.mName.equals(other.mName) && this.mAge == other.mAge &&
                this.mWeight == other.mWeight && this.mHeight == other.mHeight &&
                this.mOutfit.equals(other.mOutfit));
    }

    // class method to retrieve the number of objectes created
    public static int getCount()
    {
        return mCount;
    }

}

