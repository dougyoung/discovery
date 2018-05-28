package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets.
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {
  import FunSets._

  test("contains is implemented") {
    assert(contains(_ => true, 100))
  }

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val all = union(union(s1, s2), s3)
  }

  test("supports toString") {
    new TestSets {
      assert(FunSets.toString(all) == "{1,2,3}")
    }
  }

  test("singletonSet(1) contains 1") {
    new TestSets {
      assert(contains(s1, 1))
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1))
      assert(contains(s, 2))
      assert(!contains(s, 3))

      val sAll = union(s, s3)
      assert(contains(sAll, 1))
      assert(contains(sAll, 2))
      assert(contains(sAll, 3))
    }
  }

  test("intersect contains elements that appear in both sets") {
    new TestSets {
      val s = intersect(all, s2)
      assert(!contains(s, 1))
      assert(contains(s, 2))
      assert(!contains(s, 3))
    }
  }

  test("diff contains elements that appear in the left set and not the right") {
    new TestSets {
      val s = diff(all, s2)
      assert(contains(s, 1))
      assert(!contains(s, 2))
      assert(contains(s, 3))
    }
  }

  test("filter returns elements that satisfy a predicate") {
    new TestSets {
      val sFiltered = filter(all, x => x % 2 == 0)
      assert(!contains(sFiltered, 1))
      assert(contains(sFiltered, 2))
      assert(!contains(sFiltered, 3))
    }
  }

  test("forall returns true when all bounded integers in s satisfy p") {
    new TestSets {
      assert(forall(all, _ => true))
      assert(forall(all, x => x > 0))
      assert(!forall(all, x => x % 2 == 0))
    }
  }

  test("exists returns true one bounded integer in s satisfies p") {
    new TestSets {
      assert(exists(all, _ => true))
      assert(exists(all, x => x > 0))
      assert(exists(all, x => x % 2 == 0))
      assert(!exists(all, x => x < 0))
    }
  }

  test("maps returns the set transformed by applying f to each element of s") {
    new TestSets {
      val sCubed = map(all, x => x * x * x)
      assert(contains(sCubed, 1))
      assert(contains(sCubed, 8))
      assert(contains(sCubed, 27))

      assert(!contains(sCubed, 2))
      assert(!contains(sCubed, 3))
      assert(!contains(sCubed, 9))
    }
  }

}
