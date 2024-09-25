import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class JavaIOEx6_URL {

    public static void main(String[] args) {
        String address = "https://en.wikipedia.org/wiki/Java_(programming_language)";
    
        ArrayList<String> links = readURLForLinks(address);
        writeLinksToFile("files/urls.txt", links);
        
        int num = (int) links.stream()
                .filter(item -> item.startsWith("https:"))
                .count();
        System.out.println(num);
        
        ArrayList<String> listOfHttps = new ArrayList<>();
        links.stream()
             .filter(item -> item.startsWith("https:"))
             .forEach(item -> listOfHttps.add(item));
           //.forEach((item) -> {System.out.println(item);});
                            
        listOfHttps.stream()
                .forEach((item) -> {System.out.println(item);});
        System.out.println(listOfHttps.size());
        
        BufferedImage img = null;
        try {
            URL url = new URL("http://clipart-library.com/data_images/379246.png");
            img = ImageIO.read(url);
            ImageIO.write(img, "png", new File("files/snail.png")); 
        } catch(IOException e){
            e.printStackTrace();
        }
        
        try {  
            File file = new File("files/snail.png");   
            if(!file.exists())
                throw new FileNotFoundException("File not found");
            System.out.println("Does the file exist? " + file.exists());
            System.out.println("The file name is: " + file.getName());
            System.out.println("The path is: " + file.getPath());
            System.out.println("The parent is: " + file.getParent());
            System.out.println("The file has " + file.length() + " bytes");
            System.out.println("Can the file be read? " + file.canRead());
            System.out.println("Can the file be written? " + file.canWrite());
            System.out.println("File can be executed? " + file.canExecute());
            System.out.println("Absolute path is " + file.getAbsolutePath());
            System.out.println("Last modified on " + new java.util.Date(file.lastModified()));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }        

    }
    
    /**
     * Reads an HTML webpage and scrapes the webpage for all links.
     * @param address the specified URL address
     * @return list of links on the specified webpage
     */
    public static ArrayList<String> readURLForLinks(String address) {  
        BufferedReader in = null;
        ArrayList<String> links = new ArrayList<String>();
        try {
            URL url = new URL(address); 
            in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String line;
            String regex = "<a href\\s*=\\s*\"(.*?)\".*?>";
            Pattern pattern = Pattern.compile(regex);            
            while ((line = in.readLine()) !=  null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String link = matcher.group(1); // extract just the link with a group
                    links.add(link); // add link to the ArrayList
                }  
            } 
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println("Problem closing reader");
            }
        }
        return links;
    }
    
    /**
     * Writes a list of links to the specified file
     * @param filename the specified file path
     * @param links the list of links to write
     */
    public static void writeLinksToFile(String filename, ArrayList<String> links) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(filename));
            for (String link: links) {
                out.write(link); 
                out.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException ex) {
                    System.out.println("Problem closing writer");
                }
            }
        }
    }
}
