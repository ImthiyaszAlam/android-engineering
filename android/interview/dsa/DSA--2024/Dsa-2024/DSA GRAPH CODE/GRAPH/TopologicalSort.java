import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    public static class Edge {
        int source;
        int dest;

        public Edge(int s, int d) {
            this.source = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(2, 3));
        graph[0].add(new Edge(3, 1));

        graph[0].add(new Edge(4, 0));
        graph[0].add(new Edge(4, 1));

        graph[0].add(new Edge(5, 0));
        graph[0].add(new Edge(5, 2));
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int currentNode, boolean isVisited[],
            Stack<Integer> stack) {
        isVisited[currentNode] = true;
        for (int i = 0; i < graph[currentNode].size(); i++) {
            Edge edge = graph[currentNode].get(i);
            if (!isVisited[currentNode]) {
                topSortUtil(graph, edge.dest, isVisited, stack);
            }
        }
        stack.push(currentNode);
    }

    public static void topSort(ArrayList<Edge> graph[], int V) {
        boolean isVisited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                topSortUtil(graph, i, isVisited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph, V);
    }
}
