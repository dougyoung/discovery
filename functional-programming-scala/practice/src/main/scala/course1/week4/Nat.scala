package course1.week4

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat

  def toInt: Int = {
    def helper(nat: Nat): Int =
      if (nat.isZero) 0 else 1 + helper(nat.predecessor)

    helper(this)
  }

  override def equals(that: Any): Boolean = {
    that match {
      case that: Nat => this.isInstanceOf[Nat] && this.hashCode == that.hashCode
      case _ => false
    }
  }

  override def hashCode: Int = this.toInt

  override def toString: String = {
    String.valueOf(this.toInt)
  }
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def predecessor: Nat =
    throw new UnsupportedOperationException

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat =
    if (that.isZero) this else throw new UnsupportedOperationException
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  override def predecessor: Nat = n

  override def +(that: Nat): Nat = new Succ(n + that)

  override def -(that: Nat): Nat =
    if (that.isZero) this else n - that.predecessor
}
