package res;

import java.io.Serializable;

public class NestingDoll implements Serializable {

    private static final long serialVersionUID = 6008L;
    
    private String pattern;
    private NestingDoll innerDoll;
    
    public NestingDoll() {
        pattern = "solid";
        innerDoll = null;
    }
    
    public NestingDoll(String pattern, NestingDoll innerDoll) {
        this.pattern = pattern;
        this.innerDoll = innerDoll;
    }
    
    public String getPattern() {
        return pattern;
    }
    
    public NestingDoll getInnerDoll() {
        return innerDoll;
    }
    
    public NestingDoll clone() {
        if (innerDoll != null) {
            return new NestingDoll(pattern, innerDoll.clone()); 
        } 
        return new NestingDoll(pattern, null);   
    }
    
    public boolean isBabyDoll() {
        if (innerDoll == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("Nesting doll with pattern: %s", pattern);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } 
        if (getClass() != o.getClass()) {
            return false;
        }
        NestingDoll otherDoll = (NestingDoll) o;
        if (!pattern.equals(otherDoll.pattern)) {
            return false;
        }
        if (innerDoll != null) {
            if (innerDoll.equals(otherDoll.innerDoll)) {
                return true;
            }
        } else {
            if (otherDoll.getInnerDoll() == null) {
                return true;
            }
        }
        return false;
    }
}
