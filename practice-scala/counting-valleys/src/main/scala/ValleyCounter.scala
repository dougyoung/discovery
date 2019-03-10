import java.io.PrintWriter

object Solution {
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val outputPath = sys.env.getOrElse("OUTPUT_PATH", "/tmp/output.tmp")
    val printWriter = new PrintWriter(outputPath)

    val _ = stdin.readLine.trim.toInt
    val path = stdin.readLine
    val result = ValleyCounter.count(path)

    println(result)
    printWriter.println(result)
    printWriter.close()
  }
}

object ValleyCounter {
  def count(path: String): Int =
    path.map {
      case 'U' => 1
      case 'D' => -1
    }.foldLeft(0, 0)(countHelper) match {
      case (_, count) => count
    }

  private def countHelper(output: (Int, Int), delta: Int): (Int, Int) = output match {
    // At sea level and going down
    case (height, count) if height == 0 && delta == -1 =>
      (height + delta, count + 1)
    // At any level and going up or down
    case (height, count) =>
      (height + delta, count)
  }
}
