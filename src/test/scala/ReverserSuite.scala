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

}

