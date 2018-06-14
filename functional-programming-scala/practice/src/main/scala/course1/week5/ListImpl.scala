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
