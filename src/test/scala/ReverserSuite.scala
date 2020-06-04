import com.kitsonkit.packunpack.Reverser
import org.scalatest.FunSuite

class ReverserSuite extends FunSuite{
  test("empty must be empty") {
    assert(Reverser.reverse(List()) == List())
  }
  test("Reorder Int") {
    assert(Reverser.reverse(List(1,2,3)) == List(3,2,1))
  }
  test("Reorder String") {
    assert(Reverser.reverse(List("A","B","CD")) == List("CD","B","A"))
  }
  test("Reorder mixed types") {
    assert(Reverser.reverse(List(1,"B",BigDecimal("3.1415"))) == List(BigDecimal("3.1415"),"B",1))
  }

  test("Double reverse mixed types") {
    val src = List('A',"B", 0xc, 123L)
    assert(Reverser.reverse(Reverser.reverse(src)) == src)
  }

}

