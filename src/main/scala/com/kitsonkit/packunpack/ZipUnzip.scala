package com.kitsonkit.packunpack

import scala.annotation.tailrec

/**
 * Object that takes a string of similar consecutive letters (all letters must be same case) and transforms this into a sequence consisting of the count of each consecutive letter followed by that letter. If a letter only appears once, do not apply a count. This should also demonstrate tail recursion. Also write a method that reverses this so that the output of the first method ran with this method will return the original result.
 */
object ZipUnzip {
  private def noOne(num: Int) = if (num == 1) "" else num

  private def noZero(num:Int) = if (num == 0) 1 else num

  @tailrec
  def pack(input: String, next: Int = 1, count: Int = 1, res: String = ""): String = {
    val (forward, backward) = (next + 1, next - 1)
    (next > input.size, next == input.size , next < input.size && input(next) != input(backward)) match {
      case (true, _, _) => res
      case (_, _, true) => pack(input, forward, 1, s"$res${noOne(count)}${input(backward)}")
      case (_, true, _) => pack(input, forward, 1, s"$res${noOne(count)}${input(backward)}")
      case _            => pack(input, forward, count + 1, res)
    }
  }

  @tailrec
  def unpack(input: String, next: Int = 0, digits: Int = 0, res: String = ""): String = {
    val forward = next + 1
    (next == input.size, next<input.size && input(next).isDigit) match {
      case (true, _)  => res
      case (_, true)  => unpack(input, forward, digits*10+(input(next) - '0'), res)
      case _          => unpack(input, forward, 0, res + input(next).toString * noZero(digits))
    }
  }
}
