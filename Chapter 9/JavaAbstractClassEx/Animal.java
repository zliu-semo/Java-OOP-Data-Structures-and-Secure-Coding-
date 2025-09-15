package res;

public abstract class Animal {
    private String mName;
    private double mWeight, mHeight;
    private double mMaxSpeed;
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
    
    public String getName() {
        return mName;
    }
    
    public double getWeight() {
        return mWeight;
    }
    
    public double getHeight() {
        return mHeight;
    } 
    
    public double getMaxSpeed() {
        return mMaxSpeed;
    }
    
    public static int getCount() {
        return mCount;
    }
    
    public void setName(String pName) {
        mName = pName;
    }
    
    public void setWeight(double pWeight) {
        mWeight = pWeight;
    }
    
    public void setHeight(double pHeight) {
        mHeight = pHeight;
    } 
    
    public void setMaxSpeed(double pMaxSpeed) {
        mMaxSpeed = pMaxSpeed;
    } 
    
    public abstract void eat();
    
    // Removed the getClone() method
    
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
}
