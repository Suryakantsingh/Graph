package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class MotherVertex {

    ArrayList<ArrayList<Integer>> arrayOfVertex = null;
    static int numberOfNode;

    public MotherVertex(int noOfVertex) {

        this.numberOfNode = noOfVertex;
        arrayOfVertex = new ArrayList<ArrayList<Integer>>(noOfVertex);

        for (int i = 0; i < noOfVertex; i++) {
            arrayOfVertex.add(new ArrayList<Integer>());
        }

    }

    public void addEdge(int u, int v) {
        arrayOfVertex.get(u).add(v);
    }

    public int graph() {

        boolean[] visitedNode = new boolean[numberOfNode];
        
        int vertex = 0;

        for( int i = 0 ;i < numberOfNode; i++ ) {
            if(visitedNode[i]== false) {
                dfsUtil(i, visitedNode);
                vertex = i;
            }
        }
        return vertex;
    }

    public void dfsUtil(int v, boolean[] visited) {

        visited[v] = true;
        //System.out.print(v + " ");

        Iterator<Integer> itr = arrayOfVertex.get(v).listIterator();
        while (itr.hasNext()) {

            int n = itr.next();

            if (!visited[n]) {
                dfsUtil(n, visited);
            }
        }
    }

    public static void main(String[] args) {

        MotherVertex findMother = new MotherVertex(7);
        findMother.addEdge(0, 1);
        findMother.addEdge(0, 2);
        findMother.addEdge(1, 3);
        findMother.addEdge(4, 1);
        findMother.addEdge(6, 4);
        findMother.addEdge(6, 0);
        findMother.addEdge(5, 6);
        findMother.addEdge(5, 2);

        System.out.println(findMother.graph());
    }
}
