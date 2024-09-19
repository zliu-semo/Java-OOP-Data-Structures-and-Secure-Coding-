/**
 *
 * @author ziping
 */
public class JavaClassEx8_final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        finalInstanceVar var1 = new finalInstanceVar();
        System.out.println(var1.toString());
        System.out.println(finalInstanceVar.output());

        var1.updateContents();
        finalInstanceVar.updateContents2();
        System.out.println(var1.toString());
        System.out.println(finalInstanceVar.output());

        int[] mCpy = var1.getCopyofFinalInstance();
        mCpy[1] = -101;
        for(int i:mCpy)
            System.out.print(i+" ");
        System.out.println();
        int[] mCpy2 = finalInstanceVar.getCopyofFinalClassInstance();
        mCpy2[1] = -901;
        for(int i:mCpy2)
            System.out.print(i+" ");
    }

    public static void updateFinalParam(final StringBuilder sb){
        //    sb = new StringBuilder("try to modify");
    }
}

class finalInstanceVar {
    private final int[] mArray; //= new int[3];
    private static final int[] cArray;

    //initialize instance final variable in initializer block
    /*{   mArray = new int[3];
        for(int i = 0; i < 3; i++)
            mArray[i] = 100 + i;
    }*/

    //initialize class final variable in static block
    static {
        cArray = new int[3];
        for(int i = 0; i < 3; i++)
            cArray[i] = 900 + i;
    }
    /*private static final int[] cArray = new int[3];
    static {
        for(int i = 0; i < 3; i++)
            cArray[i] = 900 + i;
    }*/

    //initialize final instance variable in constructor
    public finalInstanceVar() {
        mArray = new int[3];
        for(int i = 0; i < 3; i++)
            mArray[i] = 100 + i;
    }

    public void updateContents(){
        mArray[0] = -100;
    }

    public static void updateContents2(){
        cArray[0] = -900;
    }

    public void setFinalInstanceVar(int[] pArr){
        //mArray = pArr;  //compilation error: cannot assign a value to a final variable
    }

    public static void setFinalInstanceVar2(int[] pArr){
        //cArray = pArr;  //compilation error: cannot assign a value to a final variable
    }

    public int[] getCopyofFinalInstance(){
        return mArray.clone();
    }

    public static int[] getCopyofFinalClassInstance(){
        return cArray.clone();
    }

    public String toString(){
        String ret = "";
        for(int i: mArray)
            ret = ret + i + " ";
        return ret;
    }

    public static String output(){
        String ret = "";
        for(int i: cArray)
            ret = ret + i + " ";
        return ret;
    }
}

