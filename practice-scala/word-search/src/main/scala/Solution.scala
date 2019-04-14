object Solution {
  def exist(board: Array[Array[Char]], word: String): Boolean = new Board(board).exists(word)

  class Board(board: Array[Array[Char]]) {
    def exists(word: String): Boolean = {
      val found = for {
        (row, i) <- board.zipWithIndex
        (column, j) <- row.zipWithIndex
        if column == word.charAt(0)
      } yield dfs(word, i, j, 0)

      found.exists(identity)
    }

    private def dfs(word: String, i: Int, j: Int, index: Int): Boolean = {
      if (word.length == index) true
      else if (i < 0 || i >= board.length) false
      else if (j < 0 || j >= board(i).length) false
      else if (board(i)(j) != word(index)) false
      else {
        val temp = board(i)(j)
        board(i).update(j, '~')

        val result =
          dfs(word, i + 1, j, index + 1) ||
          dfs(word, i - 1, j, index + 1) ||
          dfs(word, i, j + 1, index + 1) ||
          dfs(word, i, j - 1, index + 1)

        board(i).update(j, temp)
        result
      }
    }
  }

  def main(args: Array[String]): Unit ={
    val matrix = Array(
      Array('A','B','C','E'),
      Array('S','F','C','S'),
      Array('A','D','E','E')
    )

    val board = new Board(matrix)

    assert(board.exists("ABCCED"))
    assert(board.exists("SEE"))
    assert(!board.exists("ABCB"))
  }
}
