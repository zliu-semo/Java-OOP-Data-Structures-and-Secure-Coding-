/******************************************************************************
 * vertex definition for graph data type
 * 
 *****************************************************************************/

package javasimplegraphex;

import java.util.Objects;

public class Vertex {
    public int id;
    public String label;
    public boolean visited;
    public VertexFlag flag; 
    public int num;
    
    Vertex(int id, String label) {
        this.id = id;
        this.label = label;
        this.visited = false;
        this.flag = VertexFlag.UNVISITED; // unvisited
    }
    
    @Override
    public String toString(){
        return id + ": " + label;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Vertex)) {
            return false;
        }   
        
        Vertex v = (Vertex)o;
        return (id == v.id);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }   
}

enum VertexFlag{
    UNVISITED,
    INPROGRESS,
    DONE
}


