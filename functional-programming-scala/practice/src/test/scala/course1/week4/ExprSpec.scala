package course1.week4

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExprSpec extends FunSpec {
  trait TestSet {
    val expr1 = Number(0)
    val expr2 = Sum(Number(1), Number(2))
  }

  describe("show") {
    it("returns strings of each type") {
      new TestSet {
        assert(expr1.show == "Number(0)")
        assert(expr2.show == "Sum(Number(1) + Number(2))")
      }
    }
  }
}
