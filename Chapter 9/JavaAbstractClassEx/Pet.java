package res;

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
                getWeight() / (getHeight() * getHeight()) * 0.06, "kg food");
       
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
        if (getClass() == o.getClass()) {
            Pet other = (Pet) o;
            return super.equals(other) && 
                   this.mOwner.equals(other.mOwner);
        } 
        return false;
    }        
}
