package course1.week5

import scala.math.Ordering

object ListImpl {
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
}
