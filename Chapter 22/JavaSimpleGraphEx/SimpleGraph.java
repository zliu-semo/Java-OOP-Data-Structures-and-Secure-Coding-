/******************************************************************************
 * A simple graph ADT definition implemented with Java Map. All vertices are 
 * the keys of the map, and adjacent edges are stored in Java List as values 
 * of the map.
 * 
 *****************************************************************************/

package javasimplegraphex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleGraph {
    private Map<Vertex, List<Edge>> vertices;
    
    public SimpleGraph(){
        vertices = new HashMap<>();
    }
    
    public boolean adjacent(Vertex u, Vertex v){
        if(!vertices.containsKey(u) || !vertices.containsKey(v)){
            System.out.println("vertex doesn't exist");
            return false;
        }
        return (vertices.get(u).stream().filter(e->e.v.equals(v)).count() != 0 || 
                vertices.get(v).stream().filter(e->e.u.equals(u)).count() != 0); //check edge uv and edge vu
    }
    
    public Set<Vertex> neighbours(Vertex u){
        Set<Vertex> neighbourset = new HashSet<>();
        if(vertices.containsKey(u)){
            vertices.get(u).stream().forEach(e->neighbourset.add(e.v)); //add all v from edges u->v
        }
        for(Vertex v : getVertices()){
            vertices.get(v).stream().filter(e->e.v.equals(u)).forEach(e->neighbourset.add(v));  // add all v from edges v->u
        }
        return neighbourset;
    }
    
    public void addVertex(Vertex v){
        vertices.putIfAbsent(v, new ArrayList<Edge>());
    }
    
    public void removeVertex(Vertex u){
        if(vertices.get(u) != null)
            vertices.remove(u); // remove u for all u->v edges
        for(Vertex v : getVertices()){
            for(Edge e : vertices.get(v))
                if(e.v.equals(u)){
                    removeEdge(e.u, e.v); // remove u for all v->u edges
                    break;
                }
        }        
    }
    
    // edge direction is from u to v: each edge only allows one direction
    public void addEdge(Vertex u, Vertex v){
        if(vertices.containsKey(u)){
            for(Edge e : vertices.get(u))
                if(e.v.equals(v))
                    return;
            
            Edge e1 = new Edge(u, v);
            vertices.get(u).add(e1);
        }
        else{
            Edge e1 = new Edge(u, v);
            vertices.putIfAbsent(u, new ArrayList<Edge>());
            vertices.get(u).add(e1);
        }
    }
    
    public void removeEdge(Vertex u, Vertex v){
        List<Edge> l = vertices.get(u);
        Edge rem = null;
        if(l != null)
            for(Edge e : l){
                if(e.u.equals(u) && e.v.equals(v))
                    rem = e;
            }
        if(rem != null)
            l.remove(rem);
        vertices.put(u, l);
    }
    
    public Set<Vertex> getVertices(){
        return vertices.keySet();
    }
    
    @Override
    public String toString(){
        String ret = "";
        for(Vertex v : getVertices())
            ret = ret + v + "? " + vertices.get(v) + "\n";
        return ret;
    }
}

