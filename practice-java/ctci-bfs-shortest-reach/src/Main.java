import java.util.*;

public class Main {
    public static class UndirectedGraph {
        private int idOffset;
        private Node[] nodes;

        UndirectedGraph(int size) {
            this.idOffset = -1;
            this.nodes = new Node[size];
        }

        class Node {
            private int id;
            private Set<Node> adjacent = new HashSet<>();

            Node(int id) {
                this.id = id;
            }
        }

        public void addEdge(int oneId, int twoId) {
            Node oneNode = nodes[oneId];
            Node twoNode = nodes[twoId];

            if (oneNode == null) {
                oneNode = new Node(oneId);
                nodes[oneNode.id] = oneNode;
            }

            if (twoNode == null) {
                twoNode = new Node(twoId);
                nodes[twoNode.id] = twoNode;
            }

            oneNode.adjacent.add(twoNode);
            twoNode.adjacent.add(oneNode);
        }

        public int[] findShortestPaths(int startId) {
            Node start = nodes[startId];

            int[] distances = new int[nodes.length];
            Arrays.fill(distances, -1);
            distances[start.id] = 0;

            LinkedList<Node> queue = new LinkedList<>();
            queue.add(start);

            while (!queue.isEmpty()) {
                Node current = queue.pollFirst();
                for (Node nextNode : current.adjacent) {
                    if (distances[nextNode.id] < 0) {
                        queue.add(nextNode);
                        distances[nextNode.id] =
                            distances[current.id] + 6;
                    }
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queriesNum = scanner.nextInt();
        for (int i = 0; i < queriesNum; i++) {
            int nodesNum = scanner.nextInt();
            int edgesNum = scanner.nextInt();

            UndirectedGraph graph = new UndirectedGraph(nodesNum);
            for (int j = 0; j < edgesNum; j++) {
                int nodeOne = scanner.nextInt();
                int nodeTwo = scanner.nextInt();

                graph.addEdge(nodeOne - 1, nodeTwo - 1);
            }

            int nodeStart = scanner.nextInt();
            int[] distances = graph.findShortestPaths(nodeStart - 1);

            for (int distance : distances) {
                if (distance != 0) {
                    System.out.print(distance + " ");
                }
            }

            System.out.println();
        }
    }
}
