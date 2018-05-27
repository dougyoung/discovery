package course1.week2

import math.abs

object SquareRoot {
  def sqrt(x: Double): Double =
    fixedPoint(averageDamp(y =>  x / y))(1)

  private def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  private def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def loop(guess: Double): Double = {
      val next = f(guess)
      if (converged(guess, next)) next
      else loop(next)
    }

    loop(firstGuess)
  }

  private val tolerance = 1e-10
  private def converged(x: Double, y: Double): Boolean =
    abs((x - y) / x) / x < tolerance
}
