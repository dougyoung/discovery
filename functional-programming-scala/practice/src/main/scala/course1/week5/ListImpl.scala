package course1.week5

import scala.math.Ordering

object ListImpl {
  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (x => (x.head, x.size))

  def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => Nil
    case (y: List[_]) :: ys => flatten(y) ++ flatten(ys)
    case (y :: ys) => y :: flatten(ys)
  }

  def init[T](xs: List[T]): List[T] = xs match {
    case Nil => throw new IllegalArgumentException("init of empty list")
    case List(_) => Nil
    case y :: ys => y :: init(ys)
  }

  def length[T](xs: List[T]): Int =
    (xs foldRight 0)( (_, acc) => acc + 1 )

  def map[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())( (x, acc) => f(x) :: acc )

  def mergesort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (_, Nil) => xs
          case (Nil, _) => ys
          case (x :: xs1, y :: ys1) =>
            if (ord.lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }

      val (fst, snd) = xs splitAt n
      merge(mergesort(fst), mergesort(snd))
    }
  }

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: _ =>
      val (first, rest) = xs span (x1 => x == x1)
      first :: pack(rest)
  }

  def removeAt[T](xs: List[T], n: Int): List[T] = {
    def finder(xs: List[T], i: Int): List[T] = xs match {
      case Nil => xs
      case _ :: ys if i == n => ys
      case y :: ys => y :: finder(ys, i + 1)
    }

    finder(xs, 0)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case Nil => xs
    case y :: ys => reverse(ys) ++ List(y)
  }

  def squareList(xs: List[Int]): List[Int] =
    xs match {
      case Nil => xs
      case y :: ys => y * y :: squareList(ys)
    }

  def squareListMapImpl(xs: List[Int]): List[Int] =
    xs.map(x => x * x)
}
