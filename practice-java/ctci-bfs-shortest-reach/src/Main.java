import java.util.*;

public class Main {

    private static Map<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node {
        private int id;

        LinkedList<Node> adjacent = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return nodeLookup.getOrDefault(id, new Node(id));
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    public boolean hasPathDFS(Node s, Node d, Set<Integer> visited) {
        if (visited.contains(s.id)) return false;

        visited.add(s.id);

        if (s == d) return true;

        for (Node node : s.adjacent) {
            if (hasPathDFS(node, d, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPathBFS(Node s, Node d) {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int queriesNum = in.nextInt();
        for (int i = 0; i < queriesNum; i++) {
            int nodesNum = in.nextInt();
            int vertexNum = in.nextInt();

            for (int j = 0; j < vertexNum; j++) {
                int nodeStart = in.nextInt();
                int nodeEnd = in.nextInt();

                Set<Integer> startEnd = graph.getOrDefault(nodeStart, new HashSet<>());
                startEnd.add(nodeEnd);
                graph.put(nodeStart, startEnd);

                Set<Integer> endStart = graph.getOrDefault(nodeEnd, new HashSet<>());
                endStart.add(nodeStart);
                graph.put(nodeEnd, endStart);
            }
        }
    }
}
