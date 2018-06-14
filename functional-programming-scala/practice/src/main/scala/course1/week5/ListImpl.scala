package course1.week5

object ListImpl {
  def flatten[T](xs: List[T]): List[T] = xs match {
    case Nil => Nil
    case (y: List[T]) :: ys => flatten(y) ++ flatten(ys)
    case (y: T) :: ys => y :: flatten(ys)
  }

  def init[T](xs: List[T]): List[T] = xs match {
    case Nil => throw new IllegalArgumentException("init of empty list")
    case List(_) => Nil
    case y :: ys => y :: init(ys)
  }

  def mergesort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] =
        (xs, ys) match {
          case (_, Nil) => xs
          case (Nil, _) => ys
          case (x :: xs1, y :: ys1) =>
            if (x < y) x :: merge(xs1, ys)
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
