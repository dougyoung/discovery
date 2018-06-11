package course1.week4

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SortSpec extends FunSpec {
  import Sort._

  trait TestSet {
    val l0 = List()
    val l1 = List(1, 2, 3)
    val l2 = List(3, 2, 1)
    val l3 = List(1, 3, 2)
  }

  describe("isort") {
    it("sorts lists of integers") {
      new TestSet {
        assert(isort(l0) == List())
        assert(isort(l1) == List(1, 2, 3))
        assert(isort(l2) == List(1, 2, 3))
        assert(isort(l3) == List(1, 2, 3))
      }
    }
  }

}
