package res;

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
    
    public String getHabitat() {
        return mHabitat;
    }
    
    public int getID() {
        return mID;
    }
    
    public static int getNum() {
        return mNum;
    }
   
    public void setHabitat(String habitat) {
        mHabitat = habitat;
    }
    
    @Override
    public void eat() {
        System.out.printf("%s%.2f%s\n", 
                "I searched and found ", 
                getWeight() / (getHeight() * getHeight()) * 0.03, "kg food");
       
    }
    
    @Override
    public String toString() {
        return String.format("%s: %d\n", "Wildlife ID", mID) + 
               super.toString() + String.format("\n%s: %s", "habitat", mHabitat);
    }   

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() == o.getClass()) {
            Wildlife other = (Wildlife) o;
            return super.equals(other) && 
                   this.mHabitat.equals(other.mHabitat);
        } 
        return false;
    }
}
