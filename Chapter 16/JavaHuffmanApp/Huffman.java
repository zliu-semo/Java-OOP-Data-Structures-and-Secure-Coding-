/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahuffmanapp;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author ziping
 */
public class Huffman {
    private static class BinNode{
        private char data;
        private BinNode left, right;
        
        public BinNode(char item){
            data = item;
            left = null;
            right = null;
        }
    }
    
    private BinNode root;
    
    /* Constructor
    *  Precondition:  A Huffman object has been declared.
    *  Postcondition: One-node binary tree with root node
    *                 pointed to by root has been created.
    ******************************************************************/
    public Huffman(){
        root = new BinNode('*');
    }
    
    /* Build the Huffman decoding tree.
    *  Receive:       Huffman object containing this function (implicitly)
    *                 fstream in
    *  Input:         Characters and their codes via in.
    *                 Last line of code file must contain *. 
    *  Postcondition: Huffman decoding tree has been created with root
    *                 node pointed to by root.
    ******************************************************************/
    public void BuildDecodingTree(File CodeFile) throws IOException{
        char ch;          // a character
        String code;      // its code
        Scanner scanner = new Scanner(CodeFile);
        while(scanner.hasNext()){
             ch = scanner.next().charAt(0);             
             if(ch == '*')
                 return;
             code = scanner.next();
             Insert(ch, code);
        }
    }
    
    /* Insert a node for a character in Huffman decoding tree.
    *  Receive:       char c and code, a bit string
    *  Postcondition: Node containing c has been inserted into
    *                 Huffman tree with root pointed to by root.
    ******************************************************************/
    public void Insert(char ch, String code) throws IllegalArgumentException{
        BinNode p = root;

        for(int i = 0; i < code.length(); i++){
            switch (code.charAt(i))
            {
                case '0' :           // descend left
                    if (p.left == null)  // create node along path
                        p.left = new BinNode('*');
                    p = p.left;
                break;
                case '1' :           // descend right
                    if (p.right == null) // create node along path
                        p.right = new BinNode('*');
                    p = p.right;
                break;
                default:
                    System.out.println("*** Illegal character in code ***");
                    throw new IllegalArgumentException();
            }
        }
        p.data = ch;        
    }
    
    //--- Definition of Decode()
    public void Decode(FileReader CodeFile)throws IOException{
        char bit;                  // next message bit
        BinNode p; // pointer to trace path in decoding tree
        
        for(;;){
            p = root;
            while (p.left != null || p.right != null){
                int i;
                if((i = CodeFile.read()) == -1)
                    return;                
                bit = (char)i;
                if (bit == '*') return;
                if (bit == '0')
                    p = p.left;
                else if (bit == '1')
                    p = p.right;
                else
                    System.out.println("Illegal bit: " + bit + " -- ignored\n");
            }
            System.out.print(p.data + " ");
        }    
    }
    
    //--- Definition of PrintTree()
    public void PrintTree(BinNode root, int indent){
        if (root != null){
            PrintTree(root.right, indent + 8);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < indent + 8; i++)
                sb.append(" ");
            String s = sb.toString();
            System.out.println(s + " " + root.data);
            PrintTree(root.left, indent + 8);
        }
    }
    
    //--- Definition of DisplayDecodingTree()
    public void DisplayDecodingTree(){ 
        PrintTree(root, 0); 
    }
}
