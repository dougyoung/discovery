package course1.week4

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NatSpec extends FunSpec {
  trait TestSet {
    val nat0 = Zero
    val nat1 = new Succ(nat0)
    val nat2 = new Succ(nat1)
    val nat3 = new Succ(nat2)
  }

  describe("equals") {
    it("returns true when two Nats are equivalent") {
      new TestSet {
        assert(nat0 == Zero)
        assert(nat1 == new Succ(nat0))
        assert(nat2 == new Succ(new Succ(nat0)))
        assert(nat3 == new Succ(new Succ(new Succ(nat0))))
      }
    }

    it("returns false when two Nats are not equivalent") {
      new TestSet {
        assert(!(nat0 == nat1))
        assert(!(nat1 == new Succ(nat1)))
        assert(!(nat2 == new Succ(new Succ(nat1))))
        assert(!(nat3 == new Succ(new Succ(new Succ(nat1)))))
      }
    }
  }

  describe("isZero") {
    it("behaves like zero") {
      new TestSet {
        assert(nat0.isZero)
        assert(!nat1.isZero)
        assert(!nat2.isZero)
        assert(!nat3.isZero)
      }
    }
  }

  describe("predecessor") {
    it("returns previous in the sequence") {
      new TestSet {
        assertThrows[UnsupportedOperationException](nat0.predecessor)
        assert(nat1.predecessor == nat0)
        assert(nat2.predecessor == nat1)
        assert(nat3.predecessor == nat2)
      }
    }
  }

  describe("successor") {
    it("returns next in the sequence") {
      new TestSet {
        assert(nat0.successor == nat1)
        assert(nat1.successor == nat2)
        assert(nat2.successor == nat3)
        nat3.successor
      }
    }
  }

  describe("+") {
    it("returns the sum of two Nats") {
      new TestSet {
        assert(nat0 + nat0 == nat0)
        assert(nat0 + nat1 == nat1)
        assert(nat0 + nat2 == nat2)
        assert(nat0 + nat3 == nat3)
        assert(nat1 + nat0 == nat1)
        assert(nat1 + nat1 == nat2)
        assert(nat1 + nat2 == nat3)
        assert(nat2 + nat0 == nat2)
        assert(nat2 + nat1 == nat3)
        assert(nat3 + nat0 == nat3)
      }
    }
  }

  describe("-") {
    it("returns the subtraction of two Nats") {
      new TestSet {
        assert(nat0 - nat0 == nat0)
        assertThrows[UnsupportedOperationException](nat0 - nat1)
        assertThrows[UnsupportedOperationException](nat0 - nat2)
        assertThrows[UnsupportedOperationException](nat0 - nat3)
        assert(nat1 - nat0 == nat1)
        assert(nat1 - nat1 == nat0)
        assertThrows[UnsupportedOperationException](nat1 - nat2)
        assert(nat2 - nat0 == nat2)
        assert(nat2 - nat1 == nat1)
        assert(nat2 - nat2 == nat0)
        assertThrows[UnsupportedOperationException](nat2 - nat3)
        assert(nat3 - nat0 == nat3)
        assert(nat3 - nat1 == nat2)
        assert(nat3 - nat2 == nat1)
        assert(nat3 - nat3 == nat0)
      }
    }
  }

  describe("toInt") {
    it("returns the Int representation") {
      new TestSet {
        assert(nat0.toInt == 0)
        assert(nat1.toInt == 1)
        assert(nat2.toInt == 2)
        assert(nat3.toInt == 3)
      }
    }
  }

  describe("toString") {
    it("returns the String representation") {
      new TestSet {
        assert(nat0.toString == "0")
        assert(nat1.toString == "1")
        assert(nat2.toString == "2")
        assert(nat3.toString == "3")
      }
    }
  }
}
