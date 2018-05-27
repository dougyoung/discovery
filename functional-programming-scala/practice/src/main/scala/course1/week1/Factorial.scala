package course1.week1

import scala.annotation.tailrec

object Factorial {
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  def factorialTailRecursive(n: Int): Int = {
    @tailrec
    def loop(x: Int, result: Int): Int = {
      if (x == 0) result
      else loop(x - 1, result * x)
    }

    loop(n, 1)
  }
}
