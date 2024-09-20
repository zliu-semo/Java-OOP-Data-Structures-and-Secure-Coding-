package animal;

public class Pet extends Animal {
    private String mOwner;
    private int mID;
    private static int mNum = 0;

    public Pet() {
        super();
        mOwner = "pet shop";
        mNum++;
        mID = mNum;
    }

    public Pet(String name, double weight, double height,
               double maxSpeed, String owner) {
        super(name, weight, height, maxSpeed);
        mOwner = owner;
        mNum++;
        mID = mNum;
    }

    // can cause security issue, since subclass constructor calls it
    @Override
    public void setName(String pName) {
        System.out.println("in subclass - Pet, its owner is: " + mOwner);
    }

    String getOwner() {
        return mOwner;
    }

    int getID() {
        return mID;
    }

    public static int getNum() {
        return mNum;
    }

    void setOwner(String owner) {
        mOwner = owner;
    }

    @Override
    public void eat() {
        System.out.printf("%s%.2f%s\n", "My owner fed me ",
                mWeight / (mHeight * mHeight) *0.06, "kg food");

    }

    // MET04-J. Do not increase the accessibility of overridden or hidden methods
    // change accessibility from protected to public
    // expose proteced behavior to the outside
    @Override
    public void doSomething() {
        System.out.println("Do something in the back, but now exposed");
    }

    @Override
    public String toString() {
        return String.format("%s: %d\n", "Pet ID", mID) +
                super.toString() + String.format("\n%s: %s", "owner", mOwner);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
//        if (o instanceof Pet) {
        if (getClass() == o.getClass()) {
            Pet other = (Pet) o;
            return super.equals(other) &&
                    this.mOwner.equals(other.mOwner);
        }
        return false;
    }

    // For secure coding guideline on overriding (Section 6.3), used in train().
    private boolean isTrainingValid(double intensity) {
        if (intensity < 0) {
            return false;
        }
        if (intensity > mMaxSpeed) {
            return false;
        }
        return true;
    }

    // For secure coding guideline on overriding (Section 6.3), override train().
    // The subclass performs an additional input validation check before training the Pet.
    @Override
    public void train(double intensity) {
        if (isTrainingValid(intensity)) {
            setMaxSpeed(mMaxSpeed += intensity);
        }
    }

    @Override
    public boolean setMaxSpeed(double pMaxSpeed) {
        System.out.println("Max speed can only be changed by owner who is also a trainer");
        if(!isTrainer()){
            System.out.println("You are not a trainer and are not allowed to change speed");
            return false;
        }
        else
            return super.setMaxSpeed(pMaxSpeed);
    }

     private final boolean isTrainer(){
        if(mOwner.matches(".+Trainer"))
            return true;
        else
            return false;
    }

    /*
    @Override
    public boolean gainPerformance(){
        System.out.println("Max speed can only be changed by owner who is also a trainer");
        if(!isTrainer()){
            System.out.println("You are not a trainer and are not allowed to change speed");
            return false;
        }
        else
            return super.gainPerformance();
    }
    */

    // MET07-J. can cause security issue, hide super class's static method
    public static void showHidden(){
        System.out.println("Show in Pet");
    }

    // https://wiki.sei.cmu.edu/confluence/pages/viewpage.action?pageId=88487921
    // MET06-J. Do not invoke overridable methods in clone()
    public Object clone() throws CloneNotSupportedException {
        final Pet clone = (Pet) super.clone();
        clone.updateGuests(); // Invokes overridable method
        return clone;
    }

    // overridable method edits instance variable
    public void updateGuests(){
        for(Person p: guests){
            p.setName("Updating guests in subclass");
        }
    }
}

