/**
 *
 * @author ziping
 */
public class Outfit {
    public static final int SMALL = 0;
    public static final int MEDIUM = 1;
    public static final int LARGE = 2;
    public static final String[] TYPES = {"Vest", "Shirt", "Polo", "Jacket", "Coat"};
    private String mType;
    private String mColor;
    private int mSize;

    public Outfit(){
        mType = TYPES[0];
        mColor = "red";
        mSize = SMALL;
    }

    public Outfit(String pType, String pColor, int pSize){
        this.mType = pType;
        this.mColor = pColor;
        this.mSize = pSize;
    }

    public String getType(){
        return mType;
    }

    public String getColor(){
        return mColor;
    }

    public int getSize(){
        return mSize;
    }

    public void setOutfit(String pType, String pColor, int pSize){
        this.mType = pType;
        this.mColor = pColor;
        this.mSize = pSize;
    }

    @Override
    public String toString(){
        return "The " + mType + " is " + mColor + " and its size is " + mSize;
    }

    @Override
    public boolean equals(Object o){
        Outfit other = (Outfit)o;
        return (this.mType.equals(other.mType) &&
                this.mColor.equals(other.mColor) &&
                this.mSize == other.mSize);
    }
}

