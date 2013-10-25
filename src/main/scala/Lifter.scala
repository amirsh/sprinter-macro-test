package ch.epfl.lamp.sprintertest

import scala.reflect.macros.Context
import language.experimental.macros

object Lifter {
  def m[T]  = macro implementations.m[T]

  object implementations {
    def m[T](c: Context)(implicit ctag: c.WeakTypeTag[T]): c.Expr[Unit] = {
      import c.universe._

      val wholeSource = c.enclosingRun.units.toList map (_.body)

      def isCorrectClassDef(tree: Tree): Boolean = {
        (
          tree.symbol != null) &&
          (
            tree.symbol == ctag.tpe.typeSymbol) &&
            (
              tree match {
                case ClassDef(_, _, _, _) => true
                case _                    => false
              })
      }

      val classTree = wholeSource flatMap (sourceTree => sourceTree.find(tree => isCorrectClassDef(tree)))

      println(c.typeCheck(c.resetLocalAttrs(Block(List(classTree.head.duplicate), Literal(Constant(()))))))

      // println(PrettyPrinter.show(c.resetAllAttrs(c.enclosingUnit.body)))

      c.literalUnit
    }
  }
}