package course1.week4.idealized.scala

abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T
  def && (x: => Boolean): Boolean = ifThenElse[Boolean](x, False)
  def || (x: => Boolean): Boolean = ifThenElse[Boolean](True, x)
  def unary_! : Boolean = ifThenElse[Boolean](False, True)
  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)
  def != (x: Boolean): Boolean = ifThenElse(x.unary_!, x)
  def < (x: Boolean): Boolean = ifThenElse(False, x)
  def <= (x: Boolean): Boolean = ifThenElse(x, True)
  def > (x: Boolean): Boolean = ifThenElse(!x, False)
  def >= (x: Boolean): Boolean = ifThenElse(True, !x)
}

object True extends Boolean {
  def ifThenElse[T](t: => T, e: => T) = t
}

object False extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = e
}
