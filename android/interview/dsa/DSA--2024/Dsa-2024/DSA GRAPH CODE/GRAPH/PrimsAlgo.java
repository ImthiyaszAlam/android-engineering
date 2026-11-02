import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {

    public static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> grapg[]) {
        for (int i = 0; i < grapg.length; i++) {
            grapg[i] = new ArrayList<>();
        }

        grapg[0].add(new Edge(0, 1, 10));
        grapg[0].add(new Edge(0, 2, 15));
        grapg[0].add(new Edge(0, 3, 30));

        grapg[0].add(new Edge(1, 0, 10));
        grapg[0].add(new Edge(1, 3, 40));

        grapg[0].add(new Edge(2, 0, 15));
        grapg[0].add(new Edge(2, 3, 50));

        grapg[0].add(new Edge(3, 1, 40));
        grapg[0].add(new Edge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair> {

        int node;
        int cost;

        public Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }

    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[V];
        pq.add(new Pair(0, 0));
        int finalCost = 0;
        while (!pq.isEmpty()) {
            Pair currentPair = pq.remove();
            if (!visited[currentPair.node]) {
                visited[currentPair.node] = true;
                finalCost += currentPair.cost;

                for (int i = 0; i < graph[currentPair.node].size(); i++) {
                    Edge e = graph[currentPair.node].get(i);
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }
        System.out.println("min cost is " + finalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primsAlgo(graph, V);
    }
}
