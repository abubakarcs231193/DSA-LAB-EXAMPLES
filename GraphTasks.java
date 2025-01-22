import java.util.*;

public class GraphTasks {

    public static void calculateDegree(int numNodes, List<List<Integer>> graph) {
        for (int i = 0; i < numNodes; i++) {
            System.out.println(graph.get(i).size());
        }
    }

    public static void bfs(int startNode, int numNodes, List<List<Integer>> graph) {
        boolean[] visited = new boolean[numNodes];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void dfs(int node, int numNodes, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, numNodes, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes in the graph: ");
        int numNodes = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int numEdges = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (node1 node2):");
        for (int i = 0; i < numEdges; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);  // For undirected graph
        }

        System.out.println("Degree of each node:");
        calculateDegree(numNodes, graph);

        System.out.println("BFS traversal starting from node 0:");
        bfs(0, numNodes, graph);

        System.out.println("DFS traversal starting from node 0:");
        boolean[] visited = new boolean[numNodes];
        dfs(0, numNodes, graph, visited);
        System.out.println();

        sc.close();
    }
}
