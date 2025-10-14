/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaavltree;

import java.util.ArrayList;
import java.util.Queue; 
import java.util.LinkedList; 
/**
 *
 * @author ziping
 */
public class AVLTree <T extends Comparable<T>>{
    private static class BinNode<T>{ //cannot access AVLTree outer class's members
        private T data;
        private BinNode<T> left, right;
        private int height;      // height of the subtree       
        
        public BinNode(){
            left = null;
            right = null;
            height = 0;
        }

        public BinNode(T data, int height){
            this.data = data;
            this.height = height;
        }
    }     
    
    private BinNode<T> root;
    
    public AVLTree(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
     
    public int height() {
        return height(root);
    }
    
    private int height(BinNode<T> node) {
        return node == null? -1 : node.height;
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
    
    private int balanceFactor(BinNode<T> node) {
        return height(node.left) - height(node.right);
    }
    
    private BinNode<T> rotateRight(BinNode<T> A) {
        BinNode<T> B = A.left;
        A.left = B.right;
        B.right = A;
        A.height = 1 + (height(A.left) > height(A.right)? height(A.left) : height(A.right));
        B.height = 1 + (height(B.left) > height(B.right)? height(B.left) : height(B.right));
        if(root == A)
            root = B;
        return B;
    }
    
    private BinNode<T> rotateLeft(BinNode<T> A) {
        BinNode<T> B = A.right;
        A.right = B.left;
        B.left = A;
        A.height = 1 + (height(A.left) > height(A.right)? height(A.left) : height(A.right));
        B.height = 1 + (height(B.left) > height(B.right)? height(B.left) : height(B.right));
        if(root == A)
            root = B;
        return B;
    }
    
    private BinNode<T> balance(BinNode<T> A) {
        if (balanceFactor(A) < -1) {
            if (balanceFactor(A.right) > 0) {
                A.right = rotateRight(A.right);
            }
            A = rotateLeft(A);
        }
        else if (balanceFactor(A) > 1) {
            if (balanceFactor(A.left) < 0) {
                A.left = rotateLeft(A.left);
            }
            A = rotateRight(A);
        }
        return A;
    }
    
    private void updatePathHeight(ArrayList<BinNode<T>> path, int k){
        for(int i = k; i >= 0; i--){
            BinNode<T> x = path.get(i);
            x.height = 1 + (height(x.left) > height(x.right)? height(x.left) : height(x.right));
        }
    }
    
    private void balancePath(ArrayList<BinNode<T>> path){
        for(int i = path.size()-1; i >= 0; i--){
            BinNode<T> x = path.get(i);
            boolean left = true;
            if(i > 0){
                BinNode<T> y = path.get(i-1);
                if(y.left != x)
                    left = false;
                BinNode<T> preX = x;
                x = balance(x);
                if(preX != x){
                    System.out.println("after balance: " + preX.data + ", " + x.data);
                    if(left)
                        y.left = x;
                    else
                        y.right = x;
                    // update the heights from y to root
                    updatePathHeight(path, i - 1);
                }
            }
            else{
                BinNode<T> preX = x;
                x= balance(x);
                if(preX != x)
                    System.out.println("after balance: " + preX.data + ", " + x.data);
            }
        }
    }

    public void Insert(T item){
        boolean inList = false;
        BinNode<T> cursor = root;
        BinNode<T> parent = null; // root has no parent
        ArrayList<BinNode<T>> path = new ArrayList<>();
        while (cursor != null && !inList){
            parent = cursor;
            path.add(parent); //record the path for insertion
            if (item.equals(cursor.data))
                inList = true;
            else if (item.compareTo(cursor.data) < 0)
                cursor = cursor.left;
            else
                cursor = cursor.right;
        }

        if (inList)
            return;  // not successful; already in tree

        BinNode<T> newNode = new BinNode(item, 0);
        if (parent == null)
            root = newNode;
        else if (item.compareTo(parent.data) < 0)
            parent.left = newNode;	
        else
            parent.right = newNode;

        // update all nodes' heights along the path
        updatePathHeight(path, path.size() - 1);
        
        // rebalance the tree
        balancePath(path);        

        return; // successful insert        
    }
    
    public void Insert2(T item){
        root = InsertNode(root, item);
    }
    
    private BinNode<T> InsertNode(BinNode<T> node, T item){
        if (node == null) 
            return new BinNode(item, 0);
        if (item.equals(node.data))
            return node;
        else if (item.compareTo(node.data) < 0)
            node.left = InsertNode(node.left, item);
        else
            node.right = InsertNode(node.right, item);

        node.height = 1 + (height(node.left) > height(node.right)? height(node.left) : height(node.right));
        return balance(node);
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
	BinNode<T> childPtr;
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
	
        // after deleting the node, update all nodes' heights along the path
        ArrayList<BinNode<T>> path;
        if(childPtr != null)
            path = getPath(childPtr);
        else
            path = getPath(parent);
        if(path.size() > 0)
            updatePathHeight(path, path.size() - 1);
        // re-balance the tree
        balancePath(path);
	return true;  // successfully deleted
    } // end delete    
    
    private ArrayList<BinNode<T>> getPath(BinNode<T> node){
        ArrayList<BinNode<T>> path = new ArrayList<BinNode<T>>();
	BinNode<T> cursor = root;
	boolean found = false;
	
	while (cursor != null && !found)   
	{
            path.add(cursor);
            if (node.data.equals(cursor.data))
		return path;
            else if (node.data.compareTo(cursor.data) < 0)
		cursor = cursor.left;
            else
		cursor = cursor.right;
	}		
	return path;
    }    
    
    public void Delete2(T item){
        root = deleteNode(root, item);
    } // end Delete
    
    private BinNode<T> deleteNode(BinNode<T> node, T item){   
        if (item.compareTo(node.data) < 0) {
            node.left = deleteNode(node.left, item);
        }
        else if (item.compareTo(node.data) > 0) {
            node.right = deleteNode(node.right, item);
        }
        else {
            if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            else {
                BinNode y = node;
                node = nextInOrder(y.right);
                node.right = deleteNextInOrder(y.right);
                node.left = y.left;
            }
        }
        node.height = 1 + (height(node.left) > height(node.right)? height(node.left) : height(node.right));
        return balance(node);
    }
    
    private BinNode<T> nextInOrder(BinNode<T> x) {
        if (x.left == null) return x;
        return nextInOrder(x.left);
    }
    
    private BinNode<T> deleteNextInOrder(BinNode<T> x) {
        if (x.left == null) return x.right;
        x.left = deleteNextInOrder(x.left);
        x.height = 1 + (height(x.left) > height(x.right)? height(x.left) : height(x.right));
        return balance(x);
    }
        
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
        if(root == null){
            System.out.println("the tree is empty, cannot be printed");
            return;
        }
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
