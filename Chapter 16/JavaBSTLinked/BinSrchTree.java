/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabstlinked;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Queue; 
import java.util.LinkedList; 
/**
 *
 * @author ziping
 */
public class BinSrchTree<T extends Comparable<T>>{
    private static class BinNode<T>{ //cannot access BinSrchTree outer class's members
        private T data;
        private BinNode<T> left, right;
        
        public BinNode(){
            left = null;
            right = null;
        }

        public BinNode(T data, BinNode<T> left, BinNode<T> right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }     
    
    private BinNode<T> root;
    
    public BinSrchTree(){
        root = null;
    }
    
    public BinSrchTree(T item){
        root = new BinNode(item, null, null);
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public boolean Search (T item){
	BinNode<T> cursor = root;
	boolean found = false;
	
	while (cursor != null && !found)   
	{
            if (item.equals(cursor.data))
		found = true;
            else if (item.compareTo(cursor.data) < 0)
		cursor = cursor.left;
            else
		cursor = cursor.right;
	}		
	return found;
    } 

    public boolean Insert(T item){
        boolean inList = false;
        BinNode<T> cursor = root;
        BinNode<T> parent = null; // root has no parent

        while (cursor != null && !inList){
            parent = cursor;
            if (item.equals(cursor.data))
                inList = true;
            else if (item.compareTo(cursor.data) < 0)
                cursor = cursor.left;
            else
                cursor = cursor.right;
        }

        if (inList)
            return false;  // not successful; already in tree

        if (parent == null)
            root = new BinNode(item, null, null);
        else if (item.compareTo(parent.data) < 0)
            parent.left = new BinNode(item, null, null);	
        else
            parent.right = new BinNode(item, null, null);

        return true; // successful insert
    }  
    
    /*  Private utility function called by Delete member function.
	Returns true iff item found in tree;
        if found, nodes[0] = node containing item; 
        nodes[1] = parent of node containing item;
    */
    private boolean Search2(T item, BinNode<T>[] nodes){
	nodes[0] = root;
	nodes[1] = null;
	boolean found = false;
	
	while (nodes[0] != null && !found){
            if (item.equals(nodes[0].data))
		found = true;
            else if (item.compareTo(nodes[0].data) < 0){
                nodes[1] = nodes[0];
                nodes[0] = nodes[0].left;
            }
            else{
                nodes[1] = nodes[0];
                nodes[0] = nodes[0].right;    
            }
	}		
	return found;  
    }  
    
    boolean Delete(T item){
        BinNode[] nodes = new BinNode[2];
	
	if (!Search2(item, nodes))
            return false;
	BinNode location = nodes[0], parent = nodes[1];
	/* In case the node to be deleted has two children, adjust location and parent
       to a node with only one child. */    
	if (location.left != null && location.right != null){
            // Find node with data which comes next in order
            BinNode nextInOrder = location.right;  // go to the right subtree
            parent = location; // let the parent follow
            while (nextInOrder.left != null)  // go left till dead end
            {
		parent = nextInOrder;
		nextInOrder = nextInOrder.left;
            }
		
            // Copy data which comes next into location of data to be deleted
            location.data = nextInOrder.data;
		
            // Now the node to be deleted is the old copy; change location to point there
            location = nextInOrder;  // Note that parent has already been adjusted.
	}
	
	/* Adjust parent's left or parent's right to point to child of node to be deleted
	   Note that in case above, left subtree is empty, so node has at most 1 child; 
	   in all other cases, the node to be deleted has 0 or 1 children.
	*/
	
	// Set a pointer to the child or to NULL
	BinNode childPtr;
	if (location.left != null)
            childPtr = location.left;
	else if (location.right != null)
            childPtr = location.right;
	else
            childPtr = null;
		
	// Set parent to point to the child
	// In case the root is being deleted, set the root to the child
	if (location == root)
            root = childPtr;
	// otherwise determine if the left or right child of the parent is being deleted
	else if (location == parent.left)
            parent.left = childPtr;
	else // it is the right child
            parent.right = childPtr;
	
	return true;  // successfully deleted
    } // end Delete
    
    public void Inorder(){ 
        InorderAux(root); 
    }

    public void InorderAux(BinNode node){   
        if (node != null){
           InorderAux(node.left);
           System.out.print(node.data + " ");
           InorderAux(node.right);
        }
    }    
    
    public void Preorder(){ 
        PreorderAux(root); 
    }

    public void PreorderAux(BinNode node){   
        if (node != null){
           System.out.print(node.data + " "); 
           PreorderAux(node.left);           
           PreorderAux(node.right);
        }
    }   
    
    public void Postorder(){ 
        PostorderAux(root); 
    }

    public void PostorderAux(BinNode node){   
        if (node != null){           
           PostorderAux(node.left);           
           PostorderAux(node.right);
           System.out.print(node.data + " "); 
        }
    }     
    
    public String traversePreOrder(BinNode root){ 
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);

        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }
    
    //traversing via recursive approach
    public void traverseNodes(StringBuilder sb, String padding, 
                        String pointer, BinNode node, boolean hasRightSibling){
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }
    
    public void print(){
        StringBuilder sb = new StringBuilder();        
        System.out.println(traversePreOrder(root));
    }
    
    public void printLevelOrder(){ 
        Queue<BinNode> queue = new LinkedList< >(); 
        queue.add(root); 
        while (!queue.isEmpty()){ //outer loop is for levels
            int size = queue.size();
                        
            for(int i = 0; i < size; i++){ //inner loop is for nodes in one level
                BinNode tempNode = queue.poll(); 
                System.out.print(tempNode.data + " "); 

                /*Enqueue left child */
                if (tempNode.left != null) { 
                    queue.add(tempNode.left); 
                } 

                /*Enqueue right child */
                if (tempNode.right != null) { 
                    queue.add(tempNode.right); 
                } 
            }
            System.out.println();
        } 
    }         
}
