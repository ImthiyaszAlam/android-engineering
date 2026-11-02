import java.util.ArrayList;
import java.util.PriorityQueue;

public class MSTPrims {

    public static class Edge {
        int source;
        int dest;
        int weight;
        public Edge(int s,int d,int w){
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }


    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length-1; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[0].add(new Edge(1, 0, 10));
        graph[0].add(new Edge(1, 3, 40));

        graph[0].add(new Edge(2, 0, 15));
        graph[0].add(new Edge(2, 3, 50));

        graph[0].add(new Edge(3, 1, 40));
        graph[0].add(new Edge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int n,int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost-p2.cost;
        }
        
    }
    public static void primsMST( ArrayList<Edge>graph[],int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[V];
        pq.add(new Pair(0, 0));
        int finalCost = 0;


        while (!pq.isEmpty()) {
            Pair currPair = pq.remove();
            if (!visited[currPair.node]) {
                visited[currPair.node] = true;
                finalCost+=currPair.cost;

                for(int i=0;i<graph[currPair.node].size();i++){
                    Edge e = graph[currPair.node].get(i);
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }
        System.out.println("miminum cost of mst: "+finalCost);
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>graph[] = new ArrayList[V];
        createGraph(graph);
        primsMST(graph, V);
    }
}
