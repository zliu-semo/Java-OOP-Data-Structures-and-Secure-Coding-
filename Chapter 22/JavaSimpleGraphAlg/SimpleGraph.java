/******************************************************************************
 * A simple graph ADT definition implemented with Java Map. All vertices are 
 * the keys of the map, and adjacent edges are stored in Java List as values 
 * of the map. The graph also supports depth-first traversal, breadth-first 
 * traversal, cycle detection of a vertex, path between two vertices, and 
 * topological numbering of vertices
 * 
 *****************************************************************************/
package javasimplegraphalg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * The SimpleGraph class represents a simple directed graph / digraph of 
 * vertices from Vertex class. It provides the following operations: 
 * check adjacency of two vertices, get all neighbour vertices of a vertex,
 * add a vertex, remove a vertex, add an edge, remove an edge, 
 * get all vertices, return string representation of the graph, 
 * depth-first traverse, breadth-first traverse, check if a vertex contains
 * a cycle, check if there is a path between two vertices, and assign 
 * topological numbers to vertices.
 * 
 * @author Ziping Liu
 */
public class SimpleGraph {
    private Map<Vertex, List<Edge>> vertices;
    private Map<Vertex, Vertex> predecessors;
    private Vertex V[];
    private Edge E[];
    
    /**
     * Initialize a graph with a specified number of vertices and edges
     * @param numV number of vertices
     * @param numE number of edges 
     */
    public SimpleGraph(int numV, int numE){
        vertices = new HashMap<>();
        predecessors = new HashMap<>();
        V = new Vertex[numV];
        E = new Edge[numE];
    }
    
    /**
     * Initialize a graph with another existing graph
     * @param g another existing graph 
     */
    public SimpleGraph(SimpleGraph g){
        V = g.V.clone();
        E = g.E.clone();
        vertices = new HashMap<>();
        for(Vertex v:g.vertices.keySet()){
            vertices.putIfAbsent(v, new ArrayList<Edge>());
            for(Edge e:g.vertices.get(v))
                vertices.get(v).add(e);
        }
    }
    
    /**
     * Return all vertices of this graph
     * @return all vertices as a vertex array
     */
    public Vertex[] getVertices(){
        return V;
    }
    
    /**
     * Return all edges of this graph
     * @return all edges as an edge array
     */
    public Edge[] getEdges(){
        return E;
    }
    
    /**
     * Return a boolean value on whether or not two vertices are neighbours
     * 
     * @param u one vertex
     * @param v the other vertex
     * @return a boolean value on whether or not two vertices are neighbours
     */
    public boolean adjacent(Vertex u, Vertex v){
        if(!vertices.containsKey(u) || !vertices.containsKey(v)){
            return false;
        }
       
        for(Edge e:vertices.get(u))
            if(e.another(u).equals(v))
                return true;

        return false;
    }
    
    /**
     * Return a vertex's neighbour vertices as a set
     * @param   u a vertex
     * @return a vertex's neighbour vertices as a set
     */
    public Set<Vertex> neighbours(Vertex u){
        Set<Vertex> neighbourset = new HashSet<>();
        if(vertices.containsKey(u)){
            vertices.get(u).stream().forEach(e->neighbourset.add(e.another(u)));
        }      
        
        return neighbourset;
    }
    
    /**
     * Add a vertex to the graph if it isn't in the graph yet
     * 
     * @param   v a vertex to be added to the graph
     */
    public void addVertex(Vertex v){
        V[v.id] = v;
        vertices.putIfAbsent(v, new ArrayList<Edge>());
    }
    
    /**
     * Add an edge with two vertices as u and v
     * 
     * @param   u a vertex of an edge
     * @param   v a vertex of an edge
     */
    public void addEdge(int id, Vertex u, Vertex v){
        if(!vertices.containsKey(u))
            vertices.putIfAbsent(u, new ArrayList<Edge>());
        if(!vertices.containsKey(v))
            vertices.putIfAbsent(v, new ArrayList<Edge>());  
        if(E[id] == null)
            E[id] = new Edge(id, u, v);
        if(!vertices.get(u).contains(E[id]))     
            vertices.get(u).add(E[id]);
        if(!vertices.get(v).contains(E[id]))     
            vertices.get(v).add(E[id]);    
    }
     
    /**
     * Return the graph as a string formatted as lines of "a vertex? list of 
     * adjacent edges"
     * 
     * @return the graph as a string formatted as lines of "a vertex? list of 
     * adjacent edges"
     */
    @Override
    public String toString(){
        String ret = "";
        for(Vertex v: getVertices()){
            ret = ret + v + "? " + vertices.get(v) + "\n";
        }    
        return ret;
    }
    
    /**
     * Return all vertices' predecessor vertices as a map
     * 
     * @return a map which contains all vertices' predecessor vertices 
     */
    public Map<Vertex, Vertex> getPredecessors(){
        return predecessors;
    }    
    

    
    /**
     * Return a vertex's successor vertices as a list
     * 
     * @param  v a specified vertex
     * @return vertex v's successor vertices as a list 
     */
    public List<Vertex> getSuccessorVertices(Vertex v){
        //Set<Vertex> set = new HashSet<>();
        List<Vertex> set = new LinkedList<>();
        // use functional operation instead of loop
        vertices.get(v).stream().filter(e->!set.contains(e.v)).forEach(e->set.add(e.v));
        /*for(Edge e: vertices.get(v))
            set.add(e.v);*/
       return set;
    }
 
    /**
     * Reset all vertices' status related with traversing to their default values.
     * This method should be called before each traversal, cyclic check, 
     * path check and topological {@code number} assignment 
     *
     */
    public void resetVisited(){
        for(Vertex v: getVertices()){
            v.visited = false;
            v.flag = VertexFlag.UNVISITED;
            predecessors.put(v, null);
        }
    }    
    
    /**
     * Return all vertices traversed via depth-first search as a list
     * depth-first traversal implemented using stack
     * 
     * @param   origin a specified starting vertex for traversal
     * @return  all vertices traversed via depth-first search as a list          
     */
    public List<Vertex> depthFirstTraversal(Vertex origin) {
        List<Vertex> visited = new LinkedList<>();
        Stack<Vertex> verStack = new Stack<>();
        verStack.push(origin);
        while (!verStack.isEmpty()) {
            Vertex var = verStack.pop();
            if (!visited.contains(var)) {
                visited.add(var);
                List<Vertex> l = new LinkedList(neighbours(var));
                Collections.reverse(l); // consistent with recursive order
                // use functional operation instead of loop
                l.stream().filter(v->!visited.contains(v)).forEach(v->verStack.push(v));
               /* for (Vertex v : l) { 
                    if(!visited.contains(v))
                        verStack.push(v);
                }*/
            }
        }
        
        return visited;
    }

    /**
     * Return all vertices traversed via depth-first search as a list
     * depth-first traversal implemented using recursion
     * 
     * @param   origin a specified starting vertex for traversal
     * @return  all vertices traversed via depth-first search as a list          
     */    
    public void dfs(Vertex origin) {
        origin.visited = true;
        System.out.print(origin + ", ");
        // use functional operation instead of loop
        neighbours(origin).stream().filter(v->!v.visited).forEach(v->dfs(v));
        /*for (Vertex v : getSuccessorVertices(origin)) {
            if (!v.visited) {
                dfs(v);
            }
        }*/
    }

    /**
     * Return boolean value on whether or not there is a path between two vertices:
     * source is the starting vertex and destination is the ending vertex of a path
     * and field predecessors is used to back track the path from destination to source
     * 
     * @param  source the starting vertex of a path
     * @param  destination the ending vertex of a path
     * @param  path all vertices visited, not the path from source to destination
     * @return boolean value on whether or not there is a path between two vertices 
     */
    public boolean hasPath(Vertex source, Vertex destination, ArrayList<Vertex> path) {
        source.visited = true;        
        path.add(source);
        if(source.equals(destination)){
            return true;
        }
        for (Vertex v : neighbours(source)) {
            if (!v.visited) {
                predecessors.put(v, source);
                if(hasPath(v, destination, path))
                    return true;  
            }
        } 
        return false;
    } 
    
    /**
     * Return all vertices traversed via breadth-first search as a list
     * breadth-first traversal implemented using recursion
     * 
     * @param   origin a specified starting vertex for traversal
     * @return  all vertices traversed via breadth-first search as a list          
     */     
    public List<Vertex> breadthFirstTraversal(Vertex origin) {
        List<Vertex> visited = new LinkedList<>();
        Queue<Vertex> verQueue = new LinkedList<>();
        verQueue.add(origin);
        while (!verQueue.isEmpty()) {
            Vertex var = verQueue.poll();
            if (!visited.contains(var)) {
                visited.add(var);
                // use functional operation instead of loop
                neighbours(var).stream().filter(v->!visited.contains(v)).forEach(v->verQueue.add(v));
                /*for (Vertex v : getSuccessorVertices(var)) {   
                    if(!visited.contains(v))
                        verQueue.add(v);
                }*/
            }
        }
        
        return visited;
    }  
    
    /**
     * Return boolean value on whether or not a vertex has a cycle:
     * the vertex is both the starting and ending vertex of a path
     * and field predecessors is used to back track the cyclic path
     * 
     * @param   origin a specified vertex for checking of cyclic path 
     * @param   path an ArrayList of all vertices visited, not the cyclic path
     * @return  boolean value on whether or not a vertex has a cycle
     */
    public boolean hasCycle(Vertex origin, ArrayList<Vertex> path, Vertex parent) {
        origin.flag = VertexFlag.INPROGRESS;
        path.add(origin);
        predecessors.put(origin, parent);
        System.out.print("***"+origin);
        for(Edge e: vertices.get(origin)){
            if (!path.contains(e.another(origin))) {
                //predecessors.put(e.another(origin), origin);
                if (hasCycle(e.another(origin), path, origin))
                    return true;
            }
            else if( e.another(origin) != parent){
                //predecessors.put(e.another(origin), origin);
                return true;
            }
                
        }
        return false;
    }         
}
