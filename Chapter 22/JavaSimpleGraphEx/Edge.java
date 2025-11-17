/******************************************************************************
 * edge definition for graph data type
 * 
 *****************************************************************************/

package javasimplegraphex;

import java.util.Objects;

public class Edge {
    public Vertex u, v;
    
    public Edge(Vertex u, Vertex v){
        this.u = u;
        this.v = v;
    }
    
    @Override
    public String toString(){
        return u.toString() + "---" + v.toString();
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Edge)) {
            return false;
        }   
        
        Edge e = (Edge)o;
        return (u.equals(e.u) && v.equals(e.v));
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(u, v);
    }       
}

