import java.util.*;

public class DFSGraph {
    private Map<Integer, List<Integer>> adj;

    public DFSGraph() {
        adj = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsUtil(start, visited);
    }

    private void dfsUtil(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.println("Visitando nodo: " + node);

        for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        graph.dfs(0);
    }
}
