/**
 *
 * @author ziping
 */
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

    public String getOwner() {
        return mOwner;
    }

    public int getID() {
        return mID;
    }

    public static int getNum() {
        return mNum;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    @Override
    public void eat() {
        System.out.printf("%s%.2f%s\n", "My owner fed me ",
                mWeight / (mHeight * mHeight) *0.06, "kg food");

    }

    /*
    @Override
    public String toString() {
        return String.format("%s: %d\n", "Pet ID", mID) +
                super.toString() + String.format("\n%s: %s", "owner", mOwner);
    }
    */

    // knowledge check 2 solution
    @Override
    public String toString() {
        return String.format("%s %d\n", "Pet ID", mID) +
                String.format("%s: %s\n", "Pet Name", super.mName) +
                String.format("%s: %.2f\n", "Pet Weight", super.mWeight) +
                String.format("%s: %.2f\n", "Pet Height", super.mHeight) +
                String.format("%s: %.2f\n", "Pet MaxSpeed", super.mMaxSpeed) +
                String.format("%s: %s", "Pet owner", mOwner);

    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Pet) {
        //if (getClass() == o.getClass()) {
            Pet other = (Pet) o;
            return super.equals(other) &&
                    this.mOwner.equals(other.mOwner);
        }
        return false;
    }

    // knowledge check 3c: cast a to access Pet's instance variables or methods
    public void tryToAccess() {
        Animal a = new Pet();
        System.out.println(((Pet)a).getID());
    }

}
