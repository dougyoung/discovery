package course1.week2

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RationalSpec extends FunSpec {
  describe("Rational") {
    it("raises when denominator is zero") {
      assertThrows[IllegalArgumentException] {
        new Rational(1, 0)
      }
    }

    it("returns standard form") {
      assert(new Rational(1).toString == "1")
      assert(new Rational(1, 2).toString == "1/2")
      assert(new Rational(2, 1).toString == "2")
    }

    it("returns simplified form") {
      assert(new Rational(1, 1).toString == "1")
      assert(new Rational(2, 4).toString == "1/2")
      assert(new Rational(10, 100).toString == "1/10")
      assert(new Rational(20, 2).toString == "10")
    }

    it("returns equality") {
      assert(new Rational(1, 1) == new Rational(1))
      assert(new Rational(1, 1) == new Rational(1, 1))
      assert(new Rational(1, 1) == new Rational(2, 2))
      assert(new Rational(1, 2) == new Rational(2, 4))
      assert(new Rational(1, 2) == new Rational(10, 20))
      assert(new Rational(1, 2) == new Rational(100, 200))
      assert(new Rational(2, 1) == new Rational(2))
      assert(new Rational(2, 1) == new Rational(4, 2))
      assert(new Rational(1, 2) != new Rational(1, 3))
      assert(new Rational(2, 1) != new Rational(3, 1))
    }

    describe("numer") {
      it("returns the numerator of the Rational") {
        assert(new Rational(1, 2).numer == 1)
      }
    }

    describe("denom") {
      it("returns the denominator of the Rational") {
        assert(new Rational(1, 2).denom == 2)
      }
    }

    describe("add") {
      it("returns the addition of two Rationals") {
        assert(new Rational(1, 1).add(new Rational(1, 1)) == new Rational(2))
        assert(new Rational(1, 2).add(new Rational(1, 2)) == new Rational(1))
        assert(new Rational(1, 2).add(new Rational(1, 4)) == new Rational(3, 4))
        assert(new Rational(3, 4).add(new Rational(1, 5)) == new Rational(19, 20))
        assert(new Rational(1, 3).add(new Rational(5, 7)).add(new Rational(3, 2)) == new Rational(107, 42))
      }

      it("supports the + infix operator on two Rationals") {
        assert(new Rational(1, 1) + new Rational(1, 1) == new Rational(2))
        assert(new Rational(1, 2) + new Rational(1, 2) == new Rational(1))
        assert(new Rational(1, 2) + new Rational(1, 4) == new Rational(3, 4))
        assert(new Rational(3, 4) + new Rational(1, 5) == new Rational(19, 20))
        assert(new Rational(1, 3) + new Rational(5, 7) + new Rational(3, 2) == new Rational(107, 42))
      }
    }

    describe("neg") {
      it("returns the negative of the Rational") {
        assert(new Rational(1, 2).neg == new Rational(-1, 2))
      }

      it("supports the - prefix operator on one Rational") {
        assert(-new Rational(1, 2) == new Rational(-1, 2))
      }
    }

    describe("sub") {
      it("returns the subtraction of two Rationals") {
        assert(new Rational(1, 1).sub(new Rational(1, 1)) == new Rational(0, 1))
        assert(new Rational(1, 2).sub(new Rational(1, 2)) == new Rational(0, 1))
        assert(new Rational(1, 2).sub(new Rational(1, 4)) == new Rational(1, 4))
        assert(new Rational(3, 4).sub(new Rational(1, 5)) == new Rational(11, 20))
        assert(new Rational(1, 3).sub(new Rational(5, 7)).sub(new Rational(3, 2)) == new Rational(-79, 42))
      }

      it("supports the - infix operator on two Rationals") {
        assert(new Rational(1, 1) - new Rational(1, 1) == new Rational(0, 1))
        assert(new Rational(1, 2) - new Rational(1, 2) == new Rational(0, 1))
        assert(new Rational(1, 2) - new Rational(1, 4) == new Rational(1, 4))
        assert(new Rational(3, 4) - new Rational(1, 5) == new Rational(11, 20))
        assert(new Rational(1, 3) - new Rational(5, 7) - new Rational(3, 2) == new Rational(-79, 42))
      }
    }
  }

}
