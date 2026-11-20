import java.util.ArrayList;

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

    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();

            graph[0].add(new Edge(i, i, i));
        }
    }
    public static void main(String[] args) {
        
    }
}
