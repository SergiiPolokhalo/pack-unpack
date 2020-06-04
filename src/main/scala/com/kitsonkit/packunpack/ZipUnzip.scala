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

  @tailrec
  def unpack(input: String, next: Int = 0, digits: Int = 0, res: String = ""): String = {
    def noZero(num:Int) = if (num == 0) 1 else num
    //if non digit - use as is
    //if digit - collect until no digit, and put as much as big (collected digits).toInt
    if (next >= input.size) res
    else {
      if (input(next).isDigit) {
        unpack(input, next + 1, digits*10+(input(next) - '0'), res)
      } else {
        unpack(input, next + 1, 0, res + input(next).toString * noZero(digits))
      }
    }
  }
}
