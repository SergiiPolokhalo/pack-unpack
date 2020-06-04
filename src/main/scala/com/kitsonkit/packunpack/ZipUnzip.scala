package com.kitsonkit.packunpack

import scala.annotation.tailrec

/**
 * Object that takes a string of similar consecutive letters (all letters must be same case) and transforms this into a sequence consisting of the count of each consecutive letter followed by that letter. If a letter only appears once, do not apply a count. This should also demonstrate tail recursion. Also write a method that reverses this so that the output of the first method ran with this method will return the original result.
 */
object ZipUnzip {

  @tailrec
  def pack(input: String, next: Int = 1, count: Int = 1, res: String = ""): String = {
    def noOne(num: Int) = if (num == 1) "" else num

    if (next > input.size) res
    else {
      if (next == input.size || input(next) != input(next - 1)) {
        pack(input, next + 1, 1, s"$res${noOne(count)}${input(next - 1)}")
      } else {
        pack(input, next + 1, count + 1, res)
      }
    }
  }

  def unpack(input: String): String = ""
}
