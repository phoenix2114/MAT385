// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.io.*;
import java.util.*;
 
// This class represents a directed graph using adjacency list
// representation
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
 
    // Driver method to
    public static void main(String args[])
    {
     //gets numbers of nodes for graph
      int v = System.out.println("How many nodes do you want your graph to have?"); 
     
     //Number of vertices, user input
     Graph g = new Graph(v);

     Random random = new Random();

     //TODO:Randomly add edges together
        while (i= 0 != v){
        g.addEdge(Math.abs(random.nextInt(v + 1 - 1) + 1), Math.abs(random.nextInt(v + 1 - 1) + 1);
        }

        //TODO: Print out graph to new window
        System.out.println(g);

        //ask for starting starting node
       int startNode = System.out.println("Which node do you want to start? ") ;    
       
       System.out.println("Following is Breadth First Traversal " + "(starting from " + startNode + ")");
 
     //traverse using starting node
     g.BFS(startNode);
    }
}
//
