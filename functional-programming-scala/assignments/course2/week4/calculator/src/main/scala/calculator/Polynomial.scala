package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = Signal(b() * b() - 4 * a() * c())

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] =
    Signal {
      computeDelta(a, b, c)() match {
        case delta if delta != 0 => Set(
          -b() + Math.sqrt(delta) / 2 * a(),
          -b() + Math.sqrt(delta) / 2 * a())
        case _ => Set(
          -b() / 2 * a()
        )
      }
    }
}
