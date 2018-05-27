package course1.week2

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProductSpec extends FunSpec {
  import Product._

  describe("product") {
    describe("identity") {
      val identity = (x: Int) => x

      it("calculates correctly between 1 and 10") {
        assert(product(identity)(1, 1) == 1)
        assert(product(identity)(1, 2) == 2)
        assert(product(identity)(1, 3) == 6)
        assert(product(identity)(1, 4) == 24)
        assert(product(identity)(1, 5) == 120)
        assert(product(identity)(1, 6) == 720)
        assert(product(identity)(1, 7) == 5040)
        assert(product(identity)(1, 8) == 40320)
        assert(product(identity)(1, 9) == 362880)
        assert(product(identity)(1, 10) == 3628800)
      }
    }

    describe("square") {
      val square = (x: Int) => x * x

      it("calculates correctly between 1 and 8") {
        assert(product(square)(1, 1) == 1)
        assert(product(square)(1, 2) == 4)
        assert(product(square)(1, 3) == 36)
        assert(product(square)(1, 4) == 576)
        assert(product(square)(1, 5) == 14400)
        assert(product(square)(1, 6) == 518400)
        assert(product(square)(1, 7) == 25401600)
        assert(product(square)(1, 8) == 1625702400)
      }
    }

    describe("cube") {
      val cube = (x: Int) => x * x * x

      it("calculates correctly between 1 and 6") {
        assert(product(cube)(1, 1) == 1)
        assert(product(cube)(1, 2) == 8)
        assert(product(cube)(1, 3) == 216)
        assert(product(cube)(1, 4) == 13824)
        assert(product(cube)(1, 5) == 1728000)
        assert(product(cube)(1, 6) == 373248000)
      }
    }
  }

  describe("productTailRecursive") {
    describe("identity") {
      val identity = (x: Int) => x

      it("calculates correctly between 1 and 10") {
        assert(productTailRecursive(identity)(1, 1) == 1)
        assert(productTailRecursive(identity)(1, 2) == 2)
        assert(productTailRecursive(identity)(1, 3) == 6)
        assert(productTailRecursive(identity)(1, 4) == 24)
        assert(productTailRecursive(identity)(1, 5) == 120)
        assert(productTailRecursive(identity)(1, 6) == 720)
        assert(productTailRecursive(identity)(1, 7) == 5040)
        assert(productTailRecursive(identity)(1, 8) == 40320)
        assert(productTailRecursive(identity)(1, 9) == 362880)
        assert(productTailRecursive(identity)(1, 10) == 3628800)
      }
    }

    describe("square") {
      val square = (x: Int) => x * x

      it("calculates correctly between 1 and 8") {
        assert(product(square)(1, 1) == 1)
        assert(product(square)(1, 2) == 4)
        assert(product(square)(1, 3) == 36)
        assert(product(square)(1, 4) == 576)
        assert(product(square)(1, 5) == 14400)
        assert(product(square)(1, 6) == 518400)
        assert(product(square)(1, 7) == 25401600)
        assert(product(square)(1, 8) == 1625702400)
      }
    }

    describe("cube") {
      val cube = (x: Int) => x * x * x

      it("calculates correctly between 1 and 6") {
        assert(product(cube)(1, 1) == 1)
        assert(product(cube)(1, 2) == 8)
        assert(product(cube)(1, 3) == 216)
        assert(product(cube)(1, 4) == 13824)
        assert(product(cube)(1, 5) == 1728000)
        assert(product(cube)(1, 6) == 373248000)
      }
    }
  }

}
