package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    require(c >= 0, "Column must be positive")
    require(r >= 0, "Row must be positive")

    def triangle(c: Int, r: Int): Int = {
      if (c < 0) 0
      else if (r < 0) 0
      else if (c == 0 && r == 0) 1
      else
        triangle(c, r-1) +
        triangle(c-1, r-1)
    }

    triangle(c, r)
  }
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    @tailrec
    def loop(chars: List[Char], stack: List[Char] = List()): Boolean = {
      val last = stack.lastOption.getOrElse('_')

      chars.headOption match {
        case None => stack.isEmpty
        case Some(')') if last != '(' => false
        case Some(')') =>
          loop(chars.tail, stack.dropRight(1))
        case Some('(') =>
          loop(chars.tail, stack :+ '(')
        case _ =>
          loop(chars.tail, stack)
      }
    }

    loop(chars)
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def loop(money: Int, coins: List[Int]): Int = {
      if (money < 0) 0
      else if (money == 0) 1
      else if (coins.isEmpty) 0
      else
        loop(money, coins.tail) +
        loop(money - coins.head, coins)
    }

    loop(money, coins)
  }

}
