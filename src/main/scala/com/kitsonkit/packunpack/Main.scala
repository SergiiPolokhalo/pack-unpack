package com.kitsonkit.packunpack

/**
 * Runner for functions
 */
object Main {
  def main(args: Array[String]): Unit = {
    println(" Generic list reverse:")
    val lst = List("I had a fun", BigDecimal("1000"), "times","playing with this test")
    println(s"$lst converted to ${Reverser.reverse(lst)}")

    println("Transformation:")
    List("AAAAABBBCCC","A","AAA","AABBBCCCD").foreach(s => println(s"$s packed to ${ZipUnzip.pack(s)}"))
    List("5ABC3D","A","3A","2A3B3CD").foreach(s => println(s"$s unpacked to ${ZipUnzip.unpack(s)}"))
  }

}
