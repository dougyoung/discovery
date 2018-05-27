package course1.week2

import org.junit.runner.RunWith
import org.scalactic.TolerantNumerics
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SquareRootSpec extends FunSpec {
  import SquareRoot._

  implicit val tolerance = TolerantNumerics.tolerantDoubleEquality(1e-10)

  describe("sqrt") {
    it("calculates square roots from 1 to 1,000,000") {
      1 to 1000000 foreach { i =>
        assert(sqrt(i) === Math.sqrt(i))
      }
    }
  }

}
