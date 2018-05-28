package course1.week3

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TreeSetSpec extends FunSpec {
  describe("Empty set") {
    trait TestSets {
      val t1 = Empty
    }

    it("is empty") {
      new TestSets {
        assert(!t1.contains(0))
        assert(!t1.contains(1))
      }
    }

    describe("incl") {
      it("includes an element") {
        new TestSets {
          val t2 = t1.incl(0)

          assert(!t1.contains(0))
          assert(t2.contains(0))
          assert(!t2.contains(1))
        }
      }
    }

    describe("union") {
      it("equals the other set") {
        new TestSets {
          val t2 = new NonEmpty(0)

          assert(t1.union(t2) == t2)
        }
      }
    }
  }

  describe("Non-empty set") {
    trait TestSets {
      val t1 = new NonEmpty(0)
      val t2 = new NonEmpty(1)
    }

    it("is not empty") {
      new TestSets {
        assert(t1.contains(0))
        assert(!t1.contains(1))
      }
    }

    describe("incl") {
      it("includes an element") {
        new TestSets {
          val tree = t1.incl(1)

          assert(!t1.contains(1))
          assert(tree.contains(0))
          assert(tree.contains(1))
        }
      }
    }

    describe("union") {
      it("equals this set and the other set") {
        new TestSets {
          val tree = t1.union(t2)

          assert(tree.contains(0))
          assert(tree.contains(1))
          assert(!tree.contains(2))
        }
      }
    }
  }
}
