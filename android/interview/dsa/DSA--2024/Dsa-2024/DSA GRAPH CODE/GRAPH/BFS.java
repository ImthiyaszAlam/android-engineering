import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 4, 0));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        graph[4].add(new Edge(4, 4, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));

        graph[6].add(new Edge(6, 5, 0));
    }

    public static void bfs(ArrayList<Edge>graph[],int V){
        Queue<Integer>q = new LinkedList();
        boolean visited[] = new boolean[V];
        q.add(0);
        while (!q.isEmpty()) {
            int current = q.remove();
            if (visited[current] == false) {
                System.out.print(current+" ");
                visited[current] = true;

                for(int i=0;i<graph[current].size();i++){
                     Edge e = graph[current].get(i);
                     q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V= 7;
        ArrayList<Edge>graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph, V);
    }
}
