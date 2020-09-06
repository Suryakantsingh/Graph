package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class TransitiveClosure {

    static  int[][] reachabilityMatrix = null;
    static int nodeOfVertices;
    ArrayList<ArrayList<Integer>> arrayOfVertices = null;

    TransitiveClosure(int v) {
        this.nodeOfVertices = v;
        arrayOfVertices = new ArrayList<ArrayList<Integer>>(nodeOfVertices);

        for (int i = 0; i < v; i++) {
            arrayOfVertices.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v) {
        arrayOfVertices.get(u).add(v);
    }

    public void graph() {

        reachabilityMatrix = new int[nodeOfVertices][nodeOfVertices];


        for (int i = 0; i < nodeOfVertices; i++) {
            dfsUtil( i,i);
        }
        for(int i=0;i<nodeOfVertices;i++){
            for(int j=0;j<nodeOfVertices;j++){
                System.out.print(reachabilityMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void dfsUtil( int i,int j) {

        reachabilityMatrix[i][j] = 1;
        Iterator<Integer> itr = arrayOfVertices.get(j).listIterator();

        while (itr.hasNext()) {

            int n = itr.next();

                if(reachabilityMatrix[i][n] == 0) {
                    dfsUtil( i , n);
                }
        }
    }

    public static void main(String[] args) {

        TransitiveClosure transitiveClosure = new TransitiveClosure(4);
        transitiveClosure.addEdge(0, 1);
        transitiveClosure.addEdge(0, 2);
        transitiveClosure.addEdge(1, 2);
        transitiveClosure.addEdge(2, 0);
        transitiveClosure.addEdge(2, 3);
        transitiveClosure.addEdge(3, 3);
        transitiveClosure.graph();
    }
}
