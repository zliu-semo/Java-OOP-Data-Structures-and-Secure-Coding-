package animal;

/**
 *
 * @author ziping
 */
public class Animal implements Cloneable{
    String mName;
    double mWeight, mHeight;
    double mMaxSpeed;
    private static int mCount = 0;
    public Person[] guests = new Person[3];

    // https://wiki.sei.cmu.edu/confluence/display/java/MET05-J.+Ensure+that+constructors+do+not+call+overridable+methods
    // MET05-J. Ensure that constructors do not call overridable methods
    public Animal() {
        //mName = "default animal";
        setName("default animal");
        mWeight = 1.0;
        mHeight = 1.0;
        mMaxSpeed = 0.0;
        mCount++;
        for(int i = 0; i < 3; i++)
            guests[i] = new Person();
    }

    public Animal(String name, double weight, double height, double maxSpeed) {
        mName = name;
        mWeight = weight;
        mHeight = height;
        mMaxSpeed = maxSpeed;
        mCount++;
        for(int i = 0; i < 3; i++)
            guests[i] = new Person();
    }

    // MET07-J. Change visibility to public
    public String getName() {
        return mName;
    }

    double getWeight() {
        return mWeight;
    }

    double getHeight() {
        return mHeight;
    }

    // For secure coding guideline on overriding (Section 6.3), comment out.
    /*
     * public double getMaxSpeed() { return mMaxSpeed; }
     */

    public static int getCount() {
        return mCount;
    }

    /* commented out for MET05-J
    void setName(String pName) {
        mName = pName;
    }*/

    // MET05-J. security issue: constructor calls it
    public void setName(String pName) {
        System.out.println("in super class - Animal");
        mName = pName;
    }

    /* since constructor calls this method, make it non-overridable
    public final void setName(String pName) {
        System.out.println("in super class - Animal");
        mName = pName;
    }
    */

    void setWeight(double pWeight) {
        mWeight = pWeight;
    }

    void setHeight(double pHeight) {
        mHeight = pHeight;
    }

    // For secure coding guideline on overriding (Section 6.3), comment out.
    /*  void setMaxSpeed(double pMaxSpeed) {
        mMaxSpeed = pMaxSpeed;
    }
    */

    // commented out to change visibility
    /*    public void eat() {
        System.out.println("I am eating " + mWeight / (mHeight * mHeight) + " kg of food");
    }
    */

    // changed to add invocation of doSomething( ) protected method
    public void eat() {
        doSomething();
        System.out.printf("I am eating %.2f %s", mWeight / (mHeight * mHeight), " kg of food\n");
    }

    // MET04-J. Do not increase the accessibility of overridden or hidden methods
    protected void doSomething() {
        System.out.println("Do something in super class");
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f",
                "animal name", mName,
                "weight", mWeight,
                "height", mHeight,
                "max running speed", mMaxSpeed);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() == o.getClass()) {
            Animal other = (Animal) o;
            return this.mName.equals(other.mName) &&
                    this.mWeight == other.mWeight &&
                    this.mHeight == other.mHeight &&
                    this.mMaxSpeed == other.mMaxSpeed;
        }
        return false;
    }

    // For secure coding guideline on overriding (Section 6.3), make public.
    public double getMaxSpeed() {
        return mMaxSpeed;
    }

    // For secure coding guideline on overriding (Section 6.3), make setMaxSpeed() public.
//    public void setMaxSpeed(double pMaxSpeed) {
//        mMaxSpeed = pMaxSpeed;
//    }


    // For secure coding guideline on overriding (Section 6.3), add train().
    public void train(double intensity) {
        setMaxSpeed(mMaxSpeed += intensity);
    }

    // change the method return type to boolean
    public boolean setMaxSpeed(double pMaxSpeed) {
        if(pMaxSpeed > 0 && pMaxSpeed < 350.0){
            mMaxSpeed = pMaxSpeed;
            return true;
        }
        else
            return false;
    }

    // https://wiki.sei.cmu.edu/confluence/display/java/OBJ02-J.+Preserve+dependencies+in+subclasses+when+changing+superclasses
    // OBJ02-J. Preserve dependencies in subclasses when changing superclasses
    // newly added method in super class
    // Pet subclass didn't override it, hence violate the rule:
    // only when Pet's owner is also trainer, its speed can be changed
    public boolean gainPerformance(){
        mMaxSpeed += 10.0;
        System.out.println("Max speed increased by 10. And the gained performance is " + mMaxSpeed);
        return true;
    }

    // https://wiki.sei.cmu.edu/confluence/display/java/MET07-J.+Never+declare+a+class+method+that+hides+a+method+declared+in+a+superclass+or+superinterface
    // MET07-J. Never declare a class method that hides a method declared in a superclass or superinterface
    public static void showHidden(){
        System.out.println("Show In Animal");
    }

    // https://wiki.sei.cmu.edu/confluence/pages/viewpage.action?pageId=88487921
    // MET06-J. Do not invoke overridable methods in clone()
    public Object clone() throws CloneNotSupportedException {
        final Animal clone = (Animal) super.clone();
        clone.updateGuests(); // Invokes overridable method
        clone.guests = clone.getGuestsClone();
        return clone;
    }

    public void updateGuests(){
        for(Person p: guests){
            p.setName("Updating guests in superclass");
            p.setAge(99);
        }
    }

    public Animal getClone() {
        Animal clone = new Animal(this.mName, this.mWeight, this.mHeight, this.mMaxSpeed);
        return clone;
    }

    public Person[] getGuestsClone(){
        Person[] clone = new Person[3];
        for(int i = 0; i < 3; i++)
            clone[i] = new Person(guests[i].getName(), guests[i].getAge());
        return clone;
    }
}


