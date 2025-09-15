package apparel;

import processing.MoreLoadable;

/**
 * Provide a full implementation of the MoreLoadable interface by implementing the
 * all method signatures contained within MoreLoadable and its parent interface.
 */
public class Outfit implements MoreLoadable {
    public static final int SMALL = 0;
    public static final int MEDIUM = 1;
    public static final int LARGE = 2;
    public static final String[] TYPES = {"Vest", "Shirt", "Polo", "Jacket", "Coat"};
    private String mType;
    private String mColor;
    private int mSize;
    
    /**
     * default constructor
     */
    public Outfit() {
        mType = TYPES[0];
        mColor = "red";
        mSize = SMALL;
    }
    
    /**
     * explicit-value constructor
     * @param pType One of the choices from {@code TYPES}
     * @param pColor Color of the outfit object
     * @param pSize Either one of {@code SMALL, MEDIUM, LARGE}
     */
    public Outfit(String pType, String pColor, int pSize) {
        this.mType = pType;
        this.mColor = pColor;
        this.mSize = pSize;
    }
    
    public String getType() {
        return mType;
    }
    
    public String getColor() {
        return mColor;
    } 
   
    public int getSize() {
        return mSize;
    }

    public void setOutfit(String pType, String pColor, int pSize) {
        this.mType = pType;
        this.mColor = pColor;
        this.mSize = pSize;
    }    
    
    @Override
    public String toString() {
        return "The " + mType + " is " + mColor + " and its size is " + mSize;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() == o.getClass()) {
            Outfit other = (Outfit) o;
            return (this.mType.equals(other.mType) && 
                    this.mColor.equals(other.mColor) &&
                    this.mSize == other.mSize);
        }
        return false;
    }
    
    @Override
    public String upload() {
        String s = String.format("%s\n", "{") + 
                String.format("\t%s: %s,\n", "type", mType) + 
                String.format("\t%s: %s,\n", "color", mColor) +
                String.format("\t%s: %d\n", "size", mSize) +        
                String.format("%s\n", "}");
        return s;
    }

    @Override
    public void download(String s) {
        String[] lines = s.split("\n");        
        mType = lines[1].substring(7, lines[1].length()-1);
        mColor = lines[2].substring(8, lines[2].length()-1);
        mSize = Integer.parseInt(lines[3].substring(7, lines[3].length()));
    }

    @Override
    public void downloadJSON(String json) {
        String[] lines = json.split("\n"); 
        // lines[1] is the String "JSON"
        mType = lines[2].substring(7, lines[2].length()-1);
        mColor = lines[3].substring(8, lines[3].length()-1);
        mSize = Integer.parseInt(lines[4].substring(7, lines[4].length()));
    }
}