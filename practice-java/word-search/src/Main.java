public class Main {

    public static void main(String[] args) {
        char[][] board = new char[][] {
            { 'A','B','C','E' },
            { 'S','F','C','S' },
            { 'A','D','E','E' }
        };

        assert(exist(board, "ABCCED"));
        assert(exist(board, "SEE"));
        assert(!exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
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
