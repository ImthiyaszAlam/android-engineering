import java.util.ArrayList;

public class AllPaths {
    public static class Edge {
        int source;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
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

    public static void printAllPath(ArrayList<Edge>graph[],int currentNode,boolean isVisited[],String path,int target){
        if (currentNode == target) {
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[currentNode].size();i++){
            Edge edge = graph[currentNode].get(i);
            if (!isVisited[edge.dest]) {
                isVisited[currentNode] = true;
                printAllPath(graph, edge.dest, isVisited, path+edge.dest, target);
                isVisited[currentNode] = false;
            }
        }
    }
    public static void main(String[] args) {
        int V= 7;
        int src = 0;
        int dest = 5;
        ArrayList<Edge>graph[] = new ArrayList[V];
        createGraph(graph);
        printAllPath(graph, src, new boolean[V], "0", dest);
    }
}
