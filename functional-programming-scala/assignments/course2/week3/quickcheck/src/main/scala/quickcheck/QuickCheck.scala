package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    a <- arbitrary[Int]
    h <- oneOf(const(empty), genHeap)
  } yield insert(a, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("gen will find the minimum element if it is found then inserted to the heap") = forAll { h: H =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("findMin will return same element if element inserted to empty empty") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("findMin will return smaller of two inserted elements to empty heap") = forAll { (a: Int, b: Int) =>
    val h = insert(a, insert(b, empty))
    findMin(h) == scala.math.min(a, b)
  }

  property("findMin will return the minimum element in a sorted ascending fashion") = forAll { h: H =>
    def removeMin(ts: H, as: List[Int]): List[Int] = {
      if (isEmpty(ts)) as
      else findMin(ts) :: removeMin(deleteMin(ts), as)
    }

    val xs = removeMin(h, Nil)
    xs == xs.sorted
  }

  property("deleteMin will return an empty list if only one element is inserted to the heap") = forAll { a: Int =>
    val h = insert(a, empty)
    isEmpty(deleteMin(h))
  }

  property("mindFind of any two heaps returns a minimum of one or the other") = forAll { (h1: H, h2: H) =>
    def removeMin(ts: H, as: List[Int]): List[Int] = {
      if (isEmpty(ts)) as
      else findMin(ts) :: removeMin(deleteMin(ts), as)
    }

    val meld1 = meld(h1, h2)
    val min1 = findMin(h1)
    val meld2 = meld(deleteMin(h1), insert(min1, h2))
    val xs1 = removeMin(meld1, Nil)
    val xs2 = removeMin(meld2, Nil)
    xs1 == xs2
  }

}
