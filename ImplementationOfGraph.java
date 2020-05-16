package graph;

import java.util.ArrayList;

public class ImplementationOfGraph {

    public void addEdge(ArrayList<ArrayList<Integer>> adj,int u, int v)
    {
            adj.get(u).add(v);
            adj.get(v).add(u);
    }

    public void print(ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size();i++){
            System.out.println("This is for vertex "+i);
            for(int j =0 ; j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        int vertex = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertex);

        for(int i=0;i<vertex;i++)
            adj.add(new ArrayList<Integer>());

        ImplementationOfGraph g = new ImplementationOfGraph();
        g.addEdge(adj,0,1);
        g.addEdge(adj,0,4);
        g.addEdge(adj,1,2);
        g.addEdge(adj,1,3);
        g.addEdge(adj,1,4);
        g.addEdge(adj,2,3);
        g.addEdge(adj,3,4);
        g.print(adj);


    }
}
