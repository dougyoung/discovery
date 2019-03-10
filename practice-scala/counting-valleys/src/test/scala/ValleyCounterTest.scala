import org.scalatest.FlatSpec

class ValleyCounterTest extends FlatSpec {

  "UDDDUDUU" should "be 1" in {
    assert(ValleyCounter.count("UDDDUDUU") == 1)
  }

  "DDUUDDUDUUUD" should "be 2" in {
    assert(ValleyCounter.count("DDUUDDUDUUUD") == 2)
  }

}
