import java.util.ArrayList;

public class CycleDetection {

    public static class Edge {
        int source;
        int destination;

        public Edge(int s, int d) {
            this.source = s;
            this.destination = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycleDetected(ArrayList<Edge> graph[], boolean visited[], int currentNode, boolean rec[]) {
        visited[currentNode] = true;
        rec[currentNode] = true;
        for (int i = 0; i < graph[currentNode].size(); i++) {
            Edge edge = graph[currentNode].get(i);
            if (rec[edge.destination]) {
                return true;
            } else if (!visited[edge.destination]) {
                if (isCycleDetected(graph, visited, edge.destination, rec)) {
                    return true;
                }
            }
        }
        rec[currentNode] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycleDetected(graph, new boolean[V], 0, new boolean[V]));
    }
}