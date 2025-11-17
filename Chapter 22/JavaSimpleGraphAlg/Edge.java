/******************************************************************************
 * edge definition for graph data type
 * 
 *****************************************************************************/

package javasimplegraphalg;

import java.util.Objects;

/**
 * The Edge class represents the connection between two vertices.
 * @author Ziping Liu
 */
public class Edge {
    // u: starting vertex of an edge
    // v: ending vertex of an edge
    public Vertex u, v;
    public int id;
    
    /**
     * Initialize an edge with a starting vertex u and an ending vertex v
     * 
     * @param u
     * @param v 
     */
    public Edge(int id, Vertex u, Vertex v){
        this.id = id;
        this.u = u;
        this.v = v;
    }
    
    /**
     * Return the edge as a string formatted as "u.id: u.label---v.id: v.label"
     * 
     * @return the edge as a string formatted as "u.id: u.label---v.id: v.label"
     */
    @Override
    public String toString(){
        return u.toString() + "---" + v.toString();
    }

    /**
     * Return boolean value on whether or not if two edges have the same 
     * starting and ending vertices
     * 
     * @param  o Another edge object
     * @return boolean value on whether or not if two edges have the same 
     *         starting and ending vertices
     */
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Edge)) {
            return false;
        }   
        
        Edge e = (Edge)o;
        return (id == e.id && u.equals(e.u) && v.equals(e.v));
    }
    
    /**
     * Return the hash code for the edge using both of its vertices
     * 
     * @return the hash code for the vertex both of its vertices
     */
    @Override
    public int hashCode(){
        return Objects.hash(id, u, v);
    }  
    
    public Vertex another(Vertex u){
        if(this.u.equals(u))
            return this.v;
        else if(this.v.equals(u))
            return this.u;
        else 
            return null;
    }
}