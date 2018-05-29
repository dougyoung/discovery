package course1.week3

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PolymorphismSpec extends FunSpec {
  import Polymorphism._

  trait TestSets {
    val nil = new Nil[Int]

    val l3 = new Cons(2, nil)
    val l2 = new Cons(1, l3)
    val l1 = new Cons(0, l2)
  }

  describe("nth") {
    it("throws when index is negative") {
      new TestSets {
        assertThrows[IndexOutOfBoundsException](nth(-1, l1))
      }
    }

    it("throws when index exceeds bounds") {
      new TestSets {
        assertThrows[IndexOutOfBoundsException](nth(3, l1))
        assertThrows[IndexOutOfBoundsException](nth(2, l2))
        assertThrows[IndexOutOfBoundsException](nth(1, l3))
        assertThrows[IndexOutOfBoundsException](nth(0, nil))
      }
    }

    it("returns the nth element") {
      new TestSets {
        assert(nth(0, l1) == 0)
        assert(nth(1, l1) == 1)
        assert(nth(2, l1) == 2)

        assert(nth(0, l2) == 1)
        assert(nth(1, l2) == 2)

        assert(nth(0, l3) == 2)
      }
    }

  }
}
