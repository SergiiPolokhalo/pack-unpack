package com.kitsonkit.packunpack

import scala.annotation.tailrec

/**
 * Object that takes a generic list and can reverse it using a method that allows tail recursion. The test can implement an instance of any concrete object
 */
object Reverser {
  @tailrec
  def reverse[T](value: List[T], accumulator: List[T] = List.empty[T]): List[T] = value match {
    case Nil => accumulator
    case List(oneValue) => oneValue :: accumulator
    case head :: body => reverse(body, head :: accumulator)
  }
}
