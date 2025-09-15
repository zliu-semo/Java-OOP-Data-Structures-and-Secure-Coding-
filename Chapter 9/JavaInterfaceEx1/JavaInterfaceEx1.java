import animal.*;
import processing.*;
import apparel.*;

/**
 * Client driver for our interface example.
 */
public class JavaInterfaceEx1 {

    public static void main(String[] args) {
        // Use the Loadable interface as the static type for an array.
        Loadable[] loadableItems = new Loadable[4];
        loadableItems[0] = new Outfit();        
        loadableItems[1] = new Outfit(Outfit.TYPES[2], "blue", Outfit.LARGE); 
        loadableItems[2] = new Pet(); 
        loadableItems[3] = new Pet("tabby", 9.9, 0.59, 10.5, "Jenny");
        
        // Process Outfit and Pet objects as Loadables, leveraging polymorphism.
        for (Loadable ele: loadableItems)
            System.out.println(ele.upload());
        
        System.out.println();
        
        // Change the fields of Loadable-type objects by invoking download().
        String s = "{\n" +
                "\ttype: Trench Coat,\n" + 
                "\tcolor: Olive,\n" + 
                "\tsize: 8\n" +
                "}";
        loadableItems[0].download(s);
        s = "{\n" +
                "\tname: Rufus,\n" + 
                "\tid: 60,\n" + 
                "\towner: Mary,\n" +
                "\tweight: 25.90,\n" +
                "\theight: 0.89,\n" +
                "\tmax speed: 50.50\n" +
                "}";
        loadableItems[2].download(s);
        System.out.println(loadableItems[0]);
        System.out.println();
        System.out.println(loadableItems[2]);
        
        System.out.println();
        
        // Illustrate the use of Loadable static constants and methods.
        System.out.println("Addition: " + (Loadable.K + Loadable.K));
        System.out.println("File type of JavaInterfaceEx1.java: " + 
            Loadable.getFileType("JavaInterfaceEx1.java"));
        
        // Illustrate the use of the Loadable default method.
        System.out.println(loadableItems[0].uploadJSON());
        
        System.out.println();
        
        // Demonstrate the use of the MoreLoadable interface.
        MoreLoadable m = new Outfit();
        System.out.println(m.upload());
        s = "JSON\n{\n" +
                "\ttype: Pea Coat,\n" + 
                "\tcolor: Navy,\n" + 
                "\tsize: 12\n" +
                "}";
        m.downloadJSON(s);
        System.out.println(m.upload());
    }
}