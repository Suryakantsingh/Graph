package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {
    int vertex;

    LinkedList<Integer> arr[];

    DFSGraph(int v) {
        arr = new LinkedList[v];
        this.vertex = v;
        for (int i = 0; i < v; i++) {
            arr[i] = new LinkedList<Integer>();
        }
    }

    public void DFS(int start,boolean[] traverse) {

        traverse[start] = true;
        System.out.print(start+" ");
        Iterator<Integer> itr = arr[start].iterator();

        while (itr.hasNext()) {
            int n = itr.next();
            if (!traverse[n]) {
                DFS(n,traverse);
            }
        }
    }
    public void dfsUtil(int v){

        boolean[] traverse = new boolean[vertex];
        DFS(v,traverse);
    }

    public void addEdge(int v, int w) {
        arr[v].add(w);
    }

    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph(4);

        graph.addEdge(2, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 3);

        graph.dfsUtil(2);
    }

}
