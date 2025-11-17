/******************************************************************************
 * A undirected graph ADT definition implemented with Java Map. All vertices are 
 * the keys of the map, and adjacent vertices are stored in Java List as values 
 * of the map.
 * 
 *****************************************************************************/
package javaundirectedgraphex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The JavaUndirectedGraph class represents an undirected graph of vertices 
 * from Vertex class. It provides the following operations: 
 * check adjacency of two vertices, get all neighbour vertices of a vertex,
 * add a vertex, add an edge, get all vertices, return string representation 
 * of the graph.
 * 
 * @author Ziping Liu
 */
public class JavaUndirectedGraph {
    // all vertices are stored in keys of Map
    // all adjacent vertices of a key are stored in values of Map    
    private Map<Vertex, List<Vertex>> adjVertices;
    // store all vertices in an array, and a vertex's id is the array's index
    private Vertex[] vertices;   
    private int numV;
    private int numE;
    
    /**
     * Initialize an undirected graph with a specified number of vertices and edges
     * @param numV number of vertices 
     * @param numE number of edges
     */
    public JavaUndirectedGraph(int numV, int numE){
        adjVertices = new HashMap<>();        
        this.numV = numV;
        this.numE = numE;
        vertices = new Vertex[numV];
    }   
    
    /**
     * Return the number of vertices in this graph
     * @return the number of vertices 
     */
    public int V(){
        return numV;
    }
    
    /**
     * Return the number of edges in this graph
     * @return the number of edges
     */
    public int E(){
        return numE;
    }
    
    /**
     * Return all vertices of this graph
     * @return all vertices 
     */
    public Vertex[] getVertices(){
        return vertices;
    }    
    
    /**
     * Add a vertex to the graph if it isn't in the graph yet
     * 
     * @param   v a vertex to be added to the graph
     */
    public void addVertex(Vertex v){
        vertices[v.id] = v;
        adjVertices.putIfAbsent(v, new ArrayList< >());
    }    

    /**
     * Add an edge with two vertices as u and v
     * 
     * @param   u a vertex of an edge
     * @param   v a vertex of an edge
     */
    public void addEdge(Vertex u, Vertex v){
        if(!adjVertices.containsKey(u))
            adjVertices.putIfAbsent(u, new ArrayList< >());
        if(!adjVertices.containsKey(v))
            adjVertices.putIfAbsent(v, new ArrayList< >()); 
        if(!adjVertices.get(u).contains(v))     
            adjVertices.get(u).add(v);
        if(!adjVertices.get(v).contains(u))     
            adjVertices.get(v).add(u);    
    }   
    
    /**
     * Return a vertex's neighbour vertices as a set
     * @param   u a vertex
     * @return a vertex's neighbour vertices as a set
     */
    public Set<Vertex> neighbours(Vertex u){
        Set<Vertex> neighbourset = null;
        if(adjVertices.containsKey(u)){
            neighbourset = new HashSet<>(adjVertices.get(u));
        }      
        
        return neighbourset;
    }  
    
    /**
     * Return a boolean value on whether or not two vertices are neighbours
     * 
     * @param u one vertex
     * @param v the other vertex
     * @return a boolean value on whether or not two vertices are neighbours
     */
    public boolean adjacent(Vertex u, Vertex v){
        if(!adjVertices.containsKey(u) || !adjVertices.containsKey(v)){
            return false;
        }
       
        if(adjVertices.containsKey(u))
            return adjVertices.get(u).contains(v);
        else
            return adjVertices.get(v).contains(u);        
    }    

    /**
     * Return the graph as a string formatted as lines of "a vertex? list of 
     * adjacent vertices"
     * 
     * @return the graph as a string formatted as lines of "a vertex? list of 
     * adjacent vertices"
     */
    @Override
    public String toString(){
        String ret = "";
        for(Vertex v : vertices){
            ret = ret + v + "? " + adjVertices.get(v) + "\n";
        }    
        return ret;
    }   
}
