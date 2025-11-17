/******************************************************************************
 * vertex definition for graph data type
 * 
 *****************************************************************************/

package javaundirectedgraphex;

import java.util.Objects;

/**
 * The Vertex class represents a vertex identified by its id and label.
 * @author Ziping Liu
 */
public class Vertex {
    public int id;          // an integer number for vertex's id
    public String label;    // a string for vertex's label or name
    
    /**
     * Initialize a vertex with a specified id and label
     * 
     * @param id
     * @param label 
     */
    Vertex(int id, String label){
        this.id = id;
        this.label = label;
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

