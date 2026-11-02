import java.util.ArrayList;

public class DfsCycle {

    public static class Edge {
        int source;
        int dest;

        public Edge(int s,int d){
            this.source = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[0] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[0].add(new Edge(1, 0));
        graph[0].add(new Edge(1, 2));
        // graph[0].add(new Edge(1, 4));
        
        graph[0].add(new Edge(2, 1));
        graph[0].add(new Edge(2, 3));
        
        graph[0].add(new Edge(3, 2));

        graph[0].add(new Edge(4, 0));
        //graph[0].add(new Edge(4, 1));
        graph[0].add(new Edge(4, 5));

        graph[0].add(new Edge(5, 4));
    }

    public static boolean isCycleUndirected(ArrayList<Edge> graph[],boolean isVisited[],int currentNode,int parent){
        isVisited[currentNode]= true;
        for(int i=0;i<graph[currentNode].size();i++){
            Edge edge = graph[currentNode].get(i);
            if (!isVisited[edge.dest] && edge.dest !=parent) {
                return true;
            }else if (!isVisited[edge.dest]) {
                if (isCycleUndirected(graph, isVisited, edge.dest, currentNode) == true) {
                return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycleUndirected(graph, new boolean[V], 0, -1));
    }
}