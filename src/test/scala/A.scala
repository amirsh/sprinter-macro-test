package ch.epfl.lamp.sprintertest

class A(val i: List[Int]) {
  def +(a: A): A = new A(i zip a.i map ((f) => f._1 + f._2))
  def *(a: A): A = this + a

  def update(l: Int): Unit = println(l)

}