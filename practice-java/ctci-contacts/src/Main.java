import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    static class PrefixTree {
        PrefixNode root;

        PrefixTree() {
            root = new PrefixNode();
        }

        public void insert(String word) {
            PrefixNode current = root;

            for (Character c : word.toCharArray()) {
                if (current.getChild(c) == null) {
                    current.setChild(c);
                }

                current = current.getChild(c);
                current.words.add(word);
            }
        }

        public int search(String prefix) {
            PrefixNode current = root;

            for (Character c : prefix.toCharArray()) {
                if (current.getChild(c) != null) {
                    current = current.getChild(c);
                } else {
                    return 0;
                }
            }

            return current.words.size();
        }
    }

    static class PrefixNode {
        private PrefixNode[] children = new PrefixNode[26];
        private List<String> words = new LinkedList<>();
        private char character;

        PrefixNode() {}

        PrefixNode(char c) {
            character = c;
        }

        public PrefixNode getChild(char c) {
            return this.children[c - 97];
        }

        public void setChild(char c) {
            this.children[c - 97] = new PrefixNode(c);
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        PrefixTree tree = new PrefixTree();

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            String contact = opContact[1];

            switch (op.toLowerCase()) {
                case "add":
                    tree.insert(contact);
                    break;
                case "find":
                    System.out.println(tree.search(contact));
                    break;
                default:
                    throw new IllegalArgumentException("Command must be 'add' or 'find'");
            }
        }

        scanner.close();
    }
}
