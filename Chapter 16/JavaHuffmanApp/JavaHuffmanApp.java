/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahuffmanapp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ziping
 */
public class JavaHuffmanApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Test of Huffman Decoding Tree Class.");

        String filename = "codefile-0.txt";
        File codestream = new File(filename);

        Huffman h = new Huffman();
        h.BuildDecodingTree(codestream);
        System.out.println("Display Huffman decoding tree below:\n");        
        h.DisplayDecodingTree();
        System.out.println("\n");

        filename = "Messagefile-0.txt";          
        FileReader message = new FileReader(filename); 
        System.out.println("Decoding a message file and the message is:");
        h.Decode(message);

        System.out.println("\n\nTest of Huffman decoding complete.");
    }
    
}
