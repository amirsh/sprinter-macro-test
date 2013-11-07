package ch.epfl.lamp.sprintertest

object TestMain {
  def main(args: Array[String]) {
    Lifter.m
  }
}

class A(i: Int) {
  def this() {
    this(1)
    println("""Hello in multiline!
      """)
  }
}

// class B(i: Int) extends A(i) {
//   def this() {
//     this(1)
//   }
// }