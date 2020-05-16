package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BfsTraversal {

    private int V;
    private LinkedList<Integer> arr[];

    BfsTraversal(int v) {
        this.V = v;
        arr = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            arr[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        arr[v].add(w);
    }

    public void bfs(int s) {
        boolean[] traversed = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        traversed[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {

            s = queue.poll();
            System.out.print(s+" ");
            LinkedList<Integer> list = arr[s];

            Iterator<Integer> itr = list.iterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (!traversed[n]) {
                    queue.add(n);
                    traversed[n] = true;

                }
            }

        }

    }

    public static void main(String[] args) {
        BfsTraversal graph = new BfsTraversal(4);

        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 3);

        graph.bfs(2);


    }
}
