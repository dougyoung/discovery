import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[][] {
            { 'o','a','a','n' },
            { 'e','t','a','e' },
            { 'i','h','k','r' },
            { 'i','f','l','v' }
        };

        String[] words = new String[] {
            "oath", "pea", "eat", "rain"
        };

        List<String> wordsFound = findWords(board, words);

        assert(wordsFound.size() == 2);
        assert(wordsFound.get(0).equals("eat"));
        assert(wordsFound.get(1).equals("oath"));

        System.out.println(wordsFound);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> wordsFound = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (search(board, words[i])) {
                wordsFound.add(words[i]);
            }
        }


        Collections.reverse(wordsFound);

        return wordsFound;
    }

    private static boolean search(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = dfs(board, word, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (word.length() == index) return true;
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[i].length) return false;
        if (board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '~';

        boolean result =
            dfs(board, word, i + 1, j, index + 1) ||
            dfs(board, word, i - 1, j, index + 1) ||
            dfs(board, word, i, j + 1, index + 1) ||
            dfs(board, word, i, j - 1, index + 1);

        board[i][j] = temp;
        return result;
    }
}
