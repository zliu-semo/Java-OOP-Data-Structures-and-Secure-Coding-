package animal;

/**
 *
 * @author ziping
 */
public class Animal {
    String mName;
    double mWeight, mHeight;
    double mMaxSpeed;
    private static int mCount = 0;

    public Animal() {
        mName = "default animal";
        mWeight = 1.0;
        mHeight = 1.0;
        mMaxSpeed = 0.0;
        mCount++;
    }

    public Animal(String name, double weight, double height, double maxSpeed) {
        mName = name;
        mWeight = weight;
        mHeight = height;
        mMaxSpeed = maxSpeed;
        mCount++;
    }

    String getName() {
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

    void setName(String pName) {
        mName = pName;
    }

    void setWeight(double pWeight) {
        mWeight = pWeight;
    }

    void setHeight(double pHeight) {
        mHeight = pHeight;
    }

    // For secure coding guideline on overriding (Section 6.3), comment out.
    /* void setMaxSpeed(double pMaxSpeed) {
        mMaxSpeed = pMaxSpeed;
    }   */


    public void eat() {
        System.out.println("I am eating " + mWeight / (mHeight * mHeight) + " kg of food");
    }

    public Animal getClone() {
        Animal clone = new Animal(this.mName, this.mWeight, this.mHeight, this.mMaxSpeed);
        return clone;
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

    // knowledge check 1 solution: make the method package-private and final
    final void setMaxSpeed(double pMaxSpeed) {
        mMaxSpeed = pMaxSpeed;
    }

    // For secure coding guideline on overriding (Section 6.3), add train().
    public void train(double intensity) {
        setMaxSpeed(mMaxSpeed += intensity);
    }
}
