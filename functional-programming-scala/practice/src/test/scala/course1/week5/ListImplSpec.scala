package course1.week5

import scala.util.Random.shuffle
import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListImplSpec extends FunSpec {
  import ListImpl._

  trait TestLists {
    val l0 = List[Int]()
    val l1 = List(1)
    val l2 = List(1, 2)
    val l3 = List(1, 2, 3)

    val lBooleans3 = List(false, true, true)
    val lChars3 = List('a', 'b', 'c')
    val lDoubles3 = List(1.0, 2.0, 3.0)
    val lStrings3 = List("a", "b", "c")
  }

  describe("flatten") {
    it("returns the same list if it's already flatten") {
      new TestLists {
        assert(flatten(l0) == l0)
        assert(flatten(l1) == l1)
        assert(flatten(l2) == l2)
        assert(flatten(l3) == l3)
      }
    }

    it("returns a flattened list from lists of lists of lists") {
      new TestLists {
        assert(flatten(List(l0)) == l0)
        assert(flatten(List(l0, l1)) == l0 ++ l1)
        assert(flatten(List(l0, l1, l2)) == l0 ++ l1 ++ l2)
        assert(flatten(List(l0, l1, l2, l3)) == l0 ++ l1 ++ l2 ++ l3)
        assert(flatten(List(l0, List(l0))) == l0 ++ l0)
        assert(flatten(List(l0, List(l1))) == l0 ++ l1)
        assert(flatten(List(l0, List(l1), List(l2))) == l0 ++ l1 ++ l2)
        assert(flatten(List(l0, List(l1), List(l2), List(l3))) == l0 ++ l1 ++ l2 ++ l3)
      }
    }

    it("returns a flattened list from lists of elements and lists") {
      new TestLists {
        assert(flatten(List(l0)) == l0)
        assert(flatten(List(l0, l1, 0)) == l0 ++ l1 :+ 0)
        assert(flatten(List(l0, l1, 0, l2)) == (l0 ++ l1 :+ 0) ++ l2)
        assert(flatten(List(l0, l1, 0, l2, l3)) == (l0 ++ l1 :+ 0) ++ l2 ++ l3)
        assert(flatten(List(l0, 0, List(l0))) == ((l0 :+ 0) ++ l0))
        assert(flatten(List(l0, 0, 1, List(l1))) == ((l0 :+ 0 :+ 1) ++ l1))
        assert(flatten(List(l0, 0, 1, 2, List(l1), List(l2))) ==
          ((l0 :+ 0 :+ 1 :+ 2) ++ l1 ++ l2))
        assert(flatten(List(l0, 0, 1, 2, 3, List(l1), 4, List(l2), 5, List(l3))) ==
          ((l0 :+ 0 :+ 1 :+ 2 :+ 3) ++ ((l1 :+ 4) ++ (l2 :+ 5) ++ l3)))
      }
    }
  }

  describe("init") {
    it("returns a list of all elements except the last") {
      new TestLists {
        assertThrows[IllegalArgumentException](init(l0))
        assert(init(l1) == l1.init)
        assert(init(l2) == l2.init)
        assert(init(l3) == l3.init)
      }
    }
  }

  describe("mergesort") {
    it("returns a list of all elements sorted ascending") {
      new TestLists {
        assert(mergesort(shuffle(l0)) == l0)
        assert(mergesort(shuffle(l1)) == l1)
        assert(mergesort(shuffle(l2)) == l2)
        assert(mergesort(shuffle(l3)) == l3)
      }
    }

    it("returns a list of all elements sorted which have a defined Ordering") {
      new TestLists {
        assert(mergesort(shuffle(lBooleans3)) == lBooleans3)
        assert(mergesort(shuffle(lChars3)) == lChars3)
        assert(mergesort(shuffle(lDoubles3)) == lDoubles3)
        assert(mergesort(shuffle(lStrings3)) == lStrings3)
      }
    }
  }

  describe("removeAt") {
    it("returns a list of all elements with index element removed") {
      new TestLists {
        assert(removeAt(l0, -1) == l0)
        assert(removeAt(l0, 0) == l0)
        assert(removeAt(l0, 1) == l0)

        assert(removeAt(l1, -1) == l1)
        assert(removeAt(l1, 0) == List())
        assert(removeAt(l1, 1) == l1)

        assert(removeAt(l2, -1) == l2)
        assert(removeAt(l2, 0) == List(2))
        assert(removeAt(l2, 1) == List(1))
        assert(removeAt(l2, 2) == l2)

        assert(removeAt(l3, -1) == l3)
        assert(removeAt(l3, 0) == List(2, 3))
        assert(removeAt(l3, 1) == List(1, 3))
        assert(removeAt(l3, 2) == List(1, 2))
        assert(removeAt(l3, 3) == l3)
      }
    }
  }

  describe("reverse") {
    it("returns a list of all elements reversed") {
      new TestLists {
        assert(reverse(l0) == l0.reverse)
        assert(reverse(l1) == l1.reverse)
        assert(reverse(l2) == l2.reverse)
        assert(reverse(l3) == l3.reverse)
      }
    }
  }
}
