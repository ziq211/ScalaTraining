package coursera.week3

object nth2{

  def main(args: Array[String]) {

    def nthf[T](n: Int, xs: List[T]): T =
      if (xs.isEmpty) throw new IndexOutOfBoundsException
      else if(n == 0) xs.head
      else nthf(n - 1, xs.tail)

    val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
    nthf(2, list)
    //nthf(-1, list)
  }

}