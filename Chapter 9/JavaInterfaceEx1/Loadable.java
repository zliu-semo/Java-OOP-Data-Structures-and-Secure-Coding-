/**
 * Package that provides interfaces for uploading and downloading information
 */
package processing;

/**
 * Example of an interface with method signatures, constants, static, and default methods
 */
public interface Loadable {
    // Method signatures; option to include public and abstract keywords
    /* public abstract */ String upload();
    /* public abstract */ void download(String s);
    
    // Constants; option to include public, static, and final keywords
    /* public static final */ int K = 1;
    
    // Static utility methods; option to include public keyword
    /* public */ static String getFileType(String filename) {
        String fileEnding = filename.substring(filename.indexOf('.') + 1, filename.length());
        return fileEnding;
    }
    
    // Default method to ease interface updates; option to include public keyword
    /* public */ default String uploadJSON() {
        return "JSON\n" + upload();
    }
}