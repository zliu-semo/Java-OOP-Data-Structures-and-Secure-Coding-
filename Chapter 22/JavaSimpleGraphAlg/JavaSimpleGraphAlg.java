/******************************************************************************
 * Unit test on graph related algorithms of depth-first traversal, breadth-first 
 * traversal, cycle detection of a vertex, path between two vertices, and 
 * topological numbering of vertices for the following two cases:
 * a friendship graph for five persons
 * a computer network with six routers
 * 
 *****************************************************************************/
package javasimplegraphalg;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Ziping Liu
 */
public class JavaSimpleGraphAlg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleGraph g1 = new SimpleGraph(5, 9);
        Vertex[] vtx = new Vertex[5];
        vtx[0] = new Vertex(0, "A");
        vtx[1] = new Vertex(1, "B");
        vtx[2] = new Vertex(2, "C");
        vtx[3] = new Vertex(3, "D");
        vtx[4] = new Vertex(4, "E");
        for(Vertex v : vtx)
            g1.addVertex(v);

        g1.addEdge(0, vtx[0], vtx[1]);
        g1.addEdge(1, vtx[0], vtx[2]);        
        g1.addEdge(2, vtx[0], vtx[3]);
        
        g1.addEdge(0, vtx[1], vtx[0]);
        g1.addEdge(3, vtx[1], vtx[2]);  
        g1.addEdge(4, vtx[1], vtx[3]);
        g1.addEdge(5, vtx[1], vtx[4]);   
        
        g1.addEdge(1, vtx[2], vtx[0]);
        g1.addEdge(3, vtx[2], vtx[1]);  
        g1.addEdge(6, vtx[2], vtx[3]);
        g1.addEdge(7, vtx[2], vtx[4]);  
        
        g1.addEdge(2, vtx[3], vtx[0]);
        g1.addEdge(4, vtx[3], vtx[1]);  
        g1.addEdge(6, vtx[3], vtx[2]);
        g1.addEdge(8, vtx[3], vtx[4]);  
        
        g1.addEdge(5, vtx[4], vtx[1]);
        g1.addEdge(7, vtx[4], vtx[2]);  
        g1.addEdge(8, vtx[4], vtx[3]);  
        g1.addEdge(0, vtx[0], vtx[1]); //will not be allowed to be added to the graph

        System.out.println("Initial graph g1 for friendship");
        System.out.println(g1);
        System.out.println("Are two vertices B and D are neighbour? " + g1.adjacent(vtx[1], vtx[3]));
        System.out.println("Vertex C's neighbours: " + g1.neighbours(vtx[2]));        

        System.out.println("DFS for E " + g1.depthFirstTraversal(vtx[4]));
        g1.resetVisited();
        System.out.print("DFS for B [");
        g1.dfs(vtx[1]);  
        System.out.print("]\n");   
        g1.resetVisited();        
        System.out.println("BFS for C: "+g1.breadthFirstTraversal(vtx[2]));  
        
        ArrayList<Vertex> path0 = new ArrayList<>();
        //find path from source to destination
        //reset flags in vertices
        g1.resetVisited();
        boolean pathExists = false;
        pathExists = g1.hasPath(vtx[1], vtx[4], path0);
        System.out.print("***Is there a path between B and E? ");                
        if(pathExists){
            System.out.print("true " + vtx[4] + ", ");
            Vertex v = g1.getPredecessors().get(vtx[4]);
            while(v != null && !v.equals(vtx[1])){
                System.out.print(v + ", ");
                v = g1.getPredecessors().get(v);
            }
            System.out.print(v + "\n");
        }
        else{
            System.out.print("false\n");
        }  
        System.out.println("vertices visited between B and E: " + path0); 
        
        g1.resetVisited();        
        path0.clear();
        System.out.print("***Vertex a has cycle? ");                
        if(g1.hasCycle(vtx[4], path0, null)){
            System.out.print("true " + vtx[4] + ", ");
            Vertex v = g1.getPredecessors().get(vtx[4]);
            while(v!=null && !v.equals(vtx[4])){
                System.out.print(v + ", ");
                v = g1.getPredecessors().get(v);
            }
            System.out.print(v + "\n");
        }
        else{
            System.out.print("false\n");
        }
        System.out.println("vertices visited for cyclic path checking on C: " + path0);        
        
        SimpleGraph g2 = new SimpleGraph(6, 10);
        Vertex[] vtx2 = new Vertex[6];
        vtx2[0] = new Vertex(0, "A");
        vtx2[1] = new Vertex(1, "B");
        vtx2[2] = new Vertex(2, "C");
        vtx2[3] = new Vertex(3, "D");
        vtx2[4] = new Vertex(4, "E");
        vtx2[5] = new Vertex(5, "F"); 
        for(Vertex v : vtx2)
            g2.addVertex(v); 
        
        g2.addEdge(0, vtx2[0], vtx2[1]);   
        g2.addEdge(1, vtx2[0], vtx2[2]); 
        g2.addEdge(2, vtx2[0], vtx2[3]);    
       
        g2.addEdge(3, vtx2[1], vtx2[2]); 
        g2.addEdge(4, vtx2[1], vtx2[3]);

        g2.addEdge(5, vtx2[2], vtx2[3]);   
        g2.addEdge(6, vtx2[2], vtx2[4]); 
        g2.addEdge(7, vtx2[2], vtx2[5]);           

        g2.addEdge(8, vtx2[3], vtx2[4]);         

        g2.addEdge(9, vtx2[4], vtx2[5]);   
        
        System.out.println("\nInitial network router relationships in graph g2:");
        System.out.println(g2);
        System.out.println("Are two vertices A and F are neighbour? " + g2.adjacent(vtx2[0], vtx2[5]) + "\n");
        System.out.println("Vertex B's neighbours: " + g2.neighbours(vtx2[1]) + "\n");        
        System.out.println("DFS for A " + g2.depthFirstTraversal(vtx2[0]));  
        g2.resetVisited();        
        System.out.print("DFS for A [");
        g2.dfs(vtx2[0]);        
        System.out.print("]\n"); 
        g2.resetVisited();        
        System.out.println("BFS for A: " + g2.breadthFirstTraversal(vtx2[0]));    
        
        ArrayList<Vertex> path = new ArrayList<>();
        //find path from source to destination
        //reset flags in vertices
        g2.resetVisited();
        boolean pathExists2 = false;
        pathExists2 = g2.hasPath(vtx2[0], vtx2[5], path);
        System.out.print("***Is there a path between A and F? ");                
        if(pathExists2){
            System.out.print("true " + vtx2[5] + ", ");
            Vertex v = g2.getPredecessors().get(vtx2[5]);
            while(v != null && !v.equals(vtx2[0])){
                System.out.print(v + ", ");
                v = g2.getPredecessors().get(v);
            }
            System.out.print(v + "\n");
        }
        else{
            System.out.print("false\n");
        }  
        System.out.println("vertices visited between A and F: " + path);        
    }
}
