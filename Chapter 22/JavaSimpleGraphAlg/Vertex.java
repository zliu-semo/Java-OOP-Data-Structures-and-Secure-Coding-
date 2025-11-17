/******************************************************************************
 * vertex definition for graph data type
 * 
 *****************************************************************************/
package javasimplegraphalg;

import java.util.Objects;

/**
 * The Vertex class represents a vertex identified by its id and label.  
 * @author Ziping Liu
 */
public class Vertex {
    public int id;
    public String label;
    public boolean visited; // if the vertex is visited or not for graph traversal
    public VertexFlag flag; // vertex status for checking cycle and topological ordering
    public int num;         // topological order number for vertex

    /**
     * Initialize a vertex with a specified id and label
     * 
     * @param id
     * @param label 
     */    
    Vertex(int id, String label) {
        this.id = id;
        this.label = label;
        this.visited = false;
        this.flag = VertexFlag.UNVISITED; // unvisited
    }
 
    /**
     * Return the vertex as a string formatted as "id: label"
     * 
     * @return the vertex as a string formatted as "id: label"
     */    
    @Override
    public String toString(){
        return id + ": " + label;
    }

    /**
     * Return boolean value on whether or not if two vertices have the same id
     * 
     * @param  o Another vertex object
     * @return boolean value on whether or not if two vertices have the same id
     */   
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Vertex)) {
            return false;
        }   
        
        Vertex v = (Vertex)o;
        return (id == v.id);
    }

    /**
     * Return the hash code for the vertex using its id
     * 
     * @return the hash code for the vertex using its id
     */   
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }   
}

// enumeration for three different vertex status
enum VertexFlag{
    UNVISITED,
    INPROGRESS,
    DONE
}
