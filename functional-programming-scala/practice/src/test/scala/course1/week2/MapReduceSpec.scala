package course1.week2

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MapReduceSpec extends FunSpec {
  import MapReduce._

  describe("sum") {
    describe("identity") {
      val identity = (x: Int) => x

      it("calculates same result as Sum implementation between 0 and 10") {
        0 to 10 foreach { i =>
          assert(sum(identity)(0, i) == Sum.sum(identity)(0, i))
        }
      }
    }

    describe("square") {
      val square = (x: Int) => x * x

      it("calculates same result as Sum implementation between 0 and 10") {
        0 to 10 foreach { i =>
          assert(sum(square)(0, i) == Sum.sum(square)(0, i))
        }
      }
    }

    describe("cube") {
      val cube = (x: Int) => x * x * x

      it("calculates same result as Sum implementation between 0 and 10") {
        0 to 10 foreach { i =>
          assert(sum(cube)(0, i) == Sum.sum(cube)(0, i))
        }
      }
    }
  }

  describe("product") {
    describe("identity") {
      val identity = (x: Int) => x

      it("calculates same result as Product implementation between 1 and 10") {
        0 to 10 foreach { i =>
          assert(product(identity)(0, i) == Product.product(identity)(0, i))
        }
      }
    }

    describe("square") {
      val square = (x: Int) => x * x

      it("calculates same result as Product implementation between 1 and 8") {
        0 to 10 foreach { i =>
          assert(product(square)(0, i) == Product.product(square)(0, i))
        }
      }
    }

    describe("cube") {
      val cube = (x: Int) => x * x * x

      it("calculates same result as Product implementation between 1 and 6") {
        0 to 10 foreach { i =>
          assert(product(cube)(0, i) == Product.product(cube)(0, i))
        }
      }
    }
  }

}
