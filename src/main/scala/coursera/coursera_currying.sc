object exercise {
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)

  def fact(n: Int) = product(x => x)(1, n)

  product(x => x * x)(3, 4)
  fact(5)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b)  zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)

  product2(x => x * x)(3, 4)
  sum(x => x)(1, 5)
}