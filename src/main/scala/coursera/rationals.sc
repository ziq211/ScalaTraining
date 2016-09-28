object rationals {
  println("hello")
  val x: Rational = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.numer
  x.denom
  x.sub(y).sub(z)
  x - y - z
  y.add(y)
  y+y
  x.less(y)
  x.max(y)
  new Rational(2)

  class Rational(x: Int, y: Int){
    require(y != 0, "Denominator must be nonzero")

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a
      else gcd(b, a % b)
    }

    def numer = x
    def denom = y

    def less(that: Rational) = this.numer * that.denom < this.denom * that.numer
    def <(that: Rational) = less(that)

    def max(that: Rational) = if(this.less(that)) that else this

    def add(that: Rational) =
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )
    def +(that: Rational) = add(that)

    def neg = new Rational(-numer, denom)
    def unary_- :Rational = neg

    def sub(that: Rational) =
      add(that.neg)
    def -(that:Rational) = this + -that

    override def toString = {
      def g = gcd(numer, denom)
      numer/g + "/" + denom/g
    }
  }
}

