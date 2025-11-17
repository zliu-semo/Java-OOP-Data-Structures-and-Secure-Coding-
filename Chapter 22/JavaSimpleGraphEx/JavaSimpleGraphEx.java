/******************************************************************************
 * Unit test for the SimpleGraph class with the following two cases:
 * a friendship graph for five persons
 * a computer network with six routers
 * 
 *****************************************************************************/

package javasimplegraphex;

public class JavaSimpleGraphEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Store friendships in a graph g1
        the relationship among friends are as Person->[List of Friends]:
            A -> B C D
            B -> A C D E
            C -> A B D E
            D -> A B C 
            E -> B C D
        */
        SimpleGraph g1 = new SimpleGraph();
        Vertex[] vtx = new Vertex[5];
        vtx[0] = new Vertex(1, "A");
        vtx[1] = new Vertex(2, "B");
        vtx[2] = new Vertex(3, "C");
        vtx[3] = new Vertex(4, "D");
        vtx[4] = new Vertex(5, "E");
        for(Vertex v : vtx)
            g1.addVertex(v);

        g1.addEdge(vtx[0], vtx[1]);
        g1.addEdge(vtx[0], vtx[2]);        
        g1.addEdge(vtx[0], vtx[3]);
        
        g1.addEdge(vtx[1], vtx[0]);
        g1.addEdge(vtx[1], vtx[2]);  
        g1.addEdge(vtx[1], vtx[3]);
        g1.addEdge(vtx[1], vtx[4]);   
        
        g1.addEdge(vtx[2], vtx[0]);
        g1.addEdge(vtx[2], vtx[1]);  
        g1.addEdge(vtx[2], vtx[3]);
        g1.addEdge(vtx[2], vtx[4]);  
        
        g1.addEdge(vtx[3], vtx[0]);
        g1.addEdge(vtx[3], vtx[1]);  
        g1.addEdge(vtx[3], vtx[2]);
        g1.addEdge(vtx[3], vtx[1]);  
        
        g1.addEdge(vtx[4], vtx[1]);
        g1.addEdge(vtx[4], vtx[2]);  
        g1.addEdge(vtx[4], vtx[3]);  
        g1.addEdge(vtx[0], vtx[1]); //will not be allowed to be added to the graph

        System.out.println("Initial graph g1 for friendship");
        System.out.println(g1);
        System.out.println("two vertices B and D are neighbour? " + g1.adjacent(vtx[1], vtx[3]));
        System.out.println("Vertex B's neighbours: " + g1.neighbours(vtx[1]));
        
        g1.removeEdge(vtx[1], vtx[2]);
        g1.removeEdge(vtx[2], vtx[1]);
        System.out.println("\nAfter removing friendship between B and C");        
        System.out.println(g1);
        System.out.println("two vertices B and D are neighbour? " + g1.adjacent(vtx[1], vtx[3]));
        System.out.println("Vertex B's neighbours: " + g1.neighbours(vtx[1])); 
        System.out.println("All vertices in g1 " + g1.getVertices());
        g1.removeVertex(vtx[1]);
        System.out.println("\nAfter removing B from the friendship graph");        
        System.out.println(g1);   
        System.out.println("two vertices B and D are neighbour? " + g1.adjacent(vtx[1], vtx[3]));
        System.out.println("Vertex C's neighbours: " + g1.neighbours(vtx[2]));  
        System.out.println("All vertices in g1 " + g1.getVertices());        
        
        /* Store network router relationships in graph g2, textbook figure 22.3
             1,B-------->2,C
            /  |       /  | \
           /   |      /   |  \
        0,A    |    /     |   5,F
           \   |   /      |  /
            \  |  /       | /
             3,D-------->4,E               
        */
        SimpleGraph g2 = new SimpleGraph();
        Vertex[] vtx2 = new Vertex[6];
        vtx2[0] = new Vertex(0, "A");
        vtx2[1] = new Vertex(1, "B");
        vtx2[2] = new Vertex(2, "C");
        vtx2[3] = new Vertex(3, "D");
        vtx2[4] = new Vertex(4, "E");
        vtx2[5] = new Vertex(5, "F"); 
        for(Vertex v : vtx2)
            g2.addVertex(v); 
        
        g2.addEdge(vtx2[0], vtx2[1]);   
        g2.addEdge(vtx2[0], vtx2[2]); 
        g2.addEdge(vtx2[0], vtx2[3]);    
        g2.addEdge(vtx2[1], vtx2[0]); 
        g2.addEdge(vtx2[1], vtx2[2]); 
        g2.addEdge(vtx2[1], vtx2[3]);
        g2.addEdge(vtx2[2], vtx2[0]);   
        g2.addEdge(vtx2[2], vtx2[1]);   
        g2.addEdge(vtx2[2], vtx2[3]);   
        g2.addEdge(vtx2[2], vtx2[4]); 
        g2.addEdge(vtx2[2], vtx2[5]);           
        g2.addEdge(vtx2[3], vtx2[0]);         
        g2.addEdge(vtx2[3], vtx2[1]);
        g2.addEdge(vtx2[3], vtx2[2]);   
        g2.addEdge(vtx2[3], vtx2[4]);         
        g2.addEdge(vtx2[4], vtx2[2]); 
        g2.addEdge(vtx2[4], vtx2[3]);
        g2.addEdge(vtx2[4], vtx2[5]);        
        g2.addEdge(vtx2[5], vtx2[2]);   
        g2.addEdge(vtx2[5], vtx2[4]);          
        
        System.out.println("\nInitial network router relationships in graph g2");
        System.out.println(g2);
        System.out.println("two vertices A and F are neighbour? " + g2.adjacent(vtx2[0], vtx2[5]) + "\n");
        System.out.println("Vertex B's neighbours: " + g2.neighbours(vtx2[1]) + "\n");
        
        g2.removeEdge(vtx2[1], vtx2[2]);
        System.out.println("After removing routing from B to C");         
        System.out.println(g2);
        g2.removeVertex(vtx2[1]);
        System.out.println("After removing B from the network graph");         
        System.out.println(g2);  
    }    
}
