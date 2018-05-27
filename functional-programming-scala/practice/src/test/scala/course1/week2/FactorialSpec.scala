package course1.week2

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FactorialSpec extends FunSpec {
  import Factorial._

  private def testFactorial(f: Int => Int): Unit = {
    assert(f(0) == 1)
    assert(f(1) == 1)
    assert(f(2) == 2)
    assert(f(3) == 6)
    assert(f(4) == 24)
    assert(f(5) == 120)
    assert(f(6) == 720)
    assert(f(7) == 5040)
    assert(f(8) == 40320)
    assert(f(9) == 362880)
    assert(f(10) == 3628800)
  }

  describe("factorial") {
    it("calculates factorials 0 to 10") {
      testFactorial(factorial)
    }
  }

  describe("factorialTailRecursive") {
    it("calculates factorials 0 to 10") {
      testFactorial(factorialTailRecursive)
    }
  }

}
