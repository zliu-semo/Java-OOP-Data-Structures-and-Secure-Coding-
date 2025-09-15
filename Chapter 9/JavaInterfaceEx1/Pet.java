package animal;

/**
 * Provide a full implementation of the Loadable interface by implementing the
 * abstract methods inherited from the Animal superclass.
 */
public class Pet extends Animal {
    private String mOwner;
    private int mID;
    private static int mNum = 0;
    
    /**
     * default constructor
     */
    public Pet() {
        super();
        mOwner = "pet shop";
        mNum++;
        mID = mNum;
    }
    
    /**
     * Explicit value constructor
     * @param name 
     * @param weight
     * @param height
     * @param maxSpeed Maximum running speed
     * @param owner Name of Pet's owner
     */
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
    
    
    @Override
    public String upload() {
        String s = String.format("%s\n", "{") + 
                String.format("\t%s: %s,\n", "name", mName) + 
                String.format("\t%s: %d,\n", "id", mID) +
                String.format("\t%s: %s,\n", "owner", mOwner) +        
                String.format("\t%s: %.2f,\n", "weight", mWeight) + 
                String.format("\t%s: %.2f,\n", "height", mHeight) + 
                String.format("\t%s: %.2f\n", "max speed", mMaxSpeed) + 
                String.format("%s\n", "}");
        return s;
    }

    @Override
    public void download(String s) {
        String[] lines = s.split("\n");
        mName = lines[1].substring(7, lines[1].length()-1);
        mID = Integer.parseInt(lines[2].substring(5, lines[2].length()-1));
        mOwner = lines[3].substring(8, lines[3].length()-1);
        mWeight = Double.parseDouble(lines[4].substring(9, lines[4].length()-1));
        mHeight = Double.parseDouble(lines[5].substring(9, lines[5].length()-1)); 
        mMaxSpeed = Double.parseDouble(lines[6].substring(12, lines[6].length()));
    }
}