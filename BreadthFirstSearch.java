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
    	//Check if node is already connected to w
    	if (adj[v].contains(w));
    	//If not, connect it
    	else
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
        Scanner nodes = new Scanner(System.in);
        Scanner start = new Scanner(System.in);

        //gets numbers of nodes for graph
        System.out.print("How many nodes do you want your graph to have? ");

        //Number of vertices, user input
        int v = nodes.nextInt();

        System.out.print("Which node do you want to start? ") ;
        int startNode = start.nextInt();

        System.out.println("Following is Breadth First Traversal starting from " + startNode);

        //creates graph based on nodes indicated by user
        Graph g = new Graph(v);

        //Random node to attach to
        Random rand = new Random();
        int random;
        //Number of connections
        Random rand2 = new Random();
        int random2;
        //Randomly add edges together
        for(int i = 0; i<v; i++){
            //generate between 1 and v-1 connections (if 5 nodes, generate 1-4 connections)
        	random2 = rand2.nextInt(v-1)+1;
        	random = rand.nextInt(v);
        	//generate random number of connections from one node to another
        	for (int k = 0; k < random2; k++){
                //don't connect node to itself
        		while(random == i){
        			random = rand.nextInt(v);
        		}
                //connect to the random node
        		g.addEdge(i, random);
                //generate new node
        		random = rand.nextInt(v);
        	}
        }

        //traverse using starting node
        g.BFS(startNode);
        
        //Print out graph
        System.out.println("\nYour graph and edges: ");
        for (int j =0; j < v ; j++){
            System.out.println("[" + j + "]" + " -> " + g.adj[j]);
        }
        nodes.close();
        start.close();
    }
}
