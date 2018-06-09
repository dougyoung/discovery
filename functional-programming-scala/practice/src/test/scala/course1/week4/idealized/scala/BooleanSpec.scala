package course1.week4.idealized.scala

import org.junit.runner.RunWith
import org.scalatest.FunSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BooleanSpec extends FunSpec {
  describe("&&") {
    it("returns values according to definition") {
      assert((True && True).equals(True))
      assert((True && False).equals(False))
      assert((False && True).equals(False))
      assert((False && False).equals(False))
    }
  }

  describe("||") {
    it("returns values according to definition") {
      assert((True || True).equals(True))
      assert((True || False).equals(True))
      assert((False || True).equals(True))
      assert((False || False).equals(False))
    }
  }

  describe("!") {
    it("returns values according to definition") {
      assert(!True.equals(False))
      assert(!False.equals(True))
    }
  }

  describe("==") {
    it("returns values according to definition") {
      assert((True == True).equals(True))
      assert((True == False).equals(False))
      assert((False == True).equals(False))
      assert((False == False).equals(True))
    }
  }

  describe("!=") {
    it("returns values according to definition") {
      assert((True != True).equals(False))
      assert((True != False).equals(True))
      assert((False != True).equals(True))
      assert((False != False).equals(False))
    }
  }

  describe("<") {
    it("returns values according to definition") {
      assert((True < True).equals(False))
      assert((True < False).equals(False))
      assert((False < True).equals(True))
      assert((False < False).equals(False))
    }
  }

  describe("<=") {
    it("returns values according to definition") {
      assert((True <= True).equals(True))
      assert((True <= False).equals(False))
      assert((False <= True).equals(True))
      assert((False <= False).equals(True))
    }
  }

  describe(">") {
    it("returns values according to definition") {
      assert((True > True).equals(False))
      assert((True > False).equals(True))
      assert((False > True).equals(False))
      assert((False > False).equals(False))
    }
  }

  describe(">=") {
    it("returns values according to definition") {
      assert((True >= True).equals(True))
      assert((True >= False).equals(True))
      assert((False >= True).equals(False))
      assert((False >= False).equals(True))
    }
  }
}
