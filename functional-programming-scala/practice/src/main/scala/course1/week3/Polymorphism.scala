package course1.week3

object Polymorphism {
  trait List[+T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
    def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
  }

  class Nil[T] extends List[T] {
    def isEmpty = true
    def head = throw new NoSuchElementException("Nil.head")
    def tail = throw new NoSuchElementException("Nil.tail")
  }

  def nth[T](i: Int, list: List[T]): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (i == 0) list.head
    else nth(i - 1, list.tail)
  }

  object List {
    def apply[T](): List[T] = new Nil
    def apply[T](x1: T): List[T] = new Cons(x1, new Nil)
    def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  }
}
