package course1.week2

object Factorial {
  import Product._

  def factorial(n: Int): Int = product(x => x)(1, n)

  def factorialTailRecursive(n: Int): Int =
    productTailRecursive(x => x)(1, n)
}
