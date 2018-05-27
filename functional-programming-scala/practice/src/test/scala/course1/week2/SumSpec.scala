package course1.week2

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SumSpec extends FunSpec {
  import Sum._

  describe("sum") {
    describe("identity") {
      val identity = (x: Int) => x

      it("calculates correctly between 0 and 10") {
        assert(sum(identity)(0, 1) == 1)
        assert(sum(identity)(0, 2) == 3)
        assert(sum(identity)(0, 3) == 6)
        assert(sum(identity)(0, 4) == 10)
        assert(sum(identity)(0, 5) == 15)
        assert(sum(identity)(0, 6) == 21)
        assert(sum(identity)(0, 7) == 28)
        assert(sum(identity)(0, 8) == 36)
        assert(sum(identity)(0, 9) == 45)
        assert(sum(identity)(0, 10) == 55)
      }
    }

    describe("square") {
      val square = (x: Int) => x * x

      it("calculates correctly between 0 and 10") {
        assert(sum(square)(0, 1) == 1)
        assert(sum(square)(0, 2) == 5)
        assert(sum(square)(0, 3) == 14)
        assert(sum(square)(0, 4) == 30)
        assert(sum(square)(0, 5) == 55)
        assert(sum(square)(0, 6) == 91)
        assert(sum(square)(0, 7) == 140)
        assert(sum(square)(0, 8) == 204)
        assert(sum(square)(0, 9) == 285)
        assert(sum(square)(0, 10) == 385)
      }
    }

    describe("cube") {
      val cube = (x: Int) => x * x * x

      it("calculates correctly between 0 and 10") {
        assert(sum(cube)(0, 1) == 1)
        assert(sum(cube)(0, 2) == 9)
        assert(sum(cube)(0, 3) == 36)
        assert(sum(cube)(0, 4) == 100)
        assert(sum(cube)(0, 5) == 225)
        assert(sum(cube)(0, 6) == 441)
        assert(sum(cube)(0, 7) == 784)
        assert(sum(cube)(0, 8) == 1296)
        assert(sum(cube)(0, 9) == 2025)
        assert(sum(cube)(0, 10) == 3025)
      }
    }
  }

}
