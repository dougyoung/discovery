import scala.collection.mutable.{HashMap, Map}
import scala.io.{StdIn => stdin}

object Solution {
  class PrefixMap() {
    private val map: Map[String, List[String]] = new HashMap()

    def insert(word: String): Unit = {
      (1 to word.length)
        .map(word.take(_))
        .foreach(prefix => map.get(prefix) match {
          case Some(words) => map.update(prefix, word +: words)
          case _ => map += (prefix -> List(word))
        })
    }

    def search(prefix: String): Int =
      map.getOrElse(prefix, Nil).size
  }

  def main(args: Array[String]) {
    val prefixMap = new PrefixMap()

    Iterator.continually(stdin.readLine)
      .drop(1)
      .takeWhile(_ != null)
      .map(_.split(" ", 2))
      .foreach {
        case Array(op, contact) => op match {
          case "add" => prefixMap.insert(contact)
          case "find" => println(prefixMap.search(contact))
          case _ => throw new IllegalArgumentException("must be 'add' or 'find'");
        }
      }
  }
}
