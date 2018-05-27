package course1.week2

class Rational(x: Int, y: Int) {
  def numer: Int = x
  def denom: Int = y

  def add(r: Rational) = new Rational(
    numer * r.denom + denom * r.numer,
    denom * r.denom
  )

  def neg: Rational = new Rational(-numer, denom)

  def sub(r: Rational): Rational = add(r.neg)

  override def equals(r: Any): Boolean = r match {
    case ration: Rational => hashCode == ration.hashCode
    case _ => false
  }

  override def hashCode: Int =
    (numer.toDouble / denom).hashCode

  override def toString: String = numer + "/" + denom
}
