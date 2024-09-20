package animal;

public class Wildlife extends Animal {
    private String mHabitat;
    private int mID;
    private static int mNum = 0;

    public Wildlife() {
        super();
        mHabitat = "nature";
        mNum++;
        mID = mNum;
    }

    public Wildlife(String name, double weight, double height,
                    double maxSpeed, String habitat) {
        super(name, weight, height, maxSpeed);
        mHabitat = habitat;
        mNum++;
        mID = mNum;
    }

    String getHabitat() {
        return mHabitat;
    }

    int getID() {
        return mID;
    }

    public static int getNum() {
        return mNum;
    }

    void setHabitat(String habitat) {
        mHabitat = habitat;
    }

    @Override
    public void eat() {
        System.out.printf("%s%.2f%s\n",
                "I searched the whole day in the wild and found ",
                mWeight / (mHeight * mHeight) *0.03, "kg food");

    }

    @Override
    public String toString() {
        return String.format("%s: %d\n", "Wildlife ID", mID) +
                super.toString() + String.format("\n%s: %s", "habitat", mHabitat);
    }

    @Override
    public boolean equals(Object o) {
        // TODO: Fix the Wildlife equals() method for Knowledge check 4.
        if (o == null) {
            return false;
        }
        if (o instanceof Wildlife) {
            Wildlife other = (Wildlife) o;
            return super.equals(other) &&
                    this.mHabitat.equals(other.mHabitat);
        }
        return false;
    }
}

