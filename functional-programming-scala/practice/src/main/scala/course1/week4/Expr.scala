package course1.week4

trait Expr {
  def show: String = this match {
    case Number(n) => s"Number($n)"
    case Sum(x, y) => s"Sum(${x.show} + ${y.show})"
  }
}

case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
