import org.scalatest.FunSuite
import com.kitsonkit.packunpack.ZipUnzip

class ZipUnzipSuite extends FunSuite{
  test("Empty must be empty") {
    assert(ZipUnzip.pack("") == "")
  }

  test("A must be pack into A") {
    assert(ZipUnzip.pack("A") == "A")
  }
  test("A must be unpack into A") {
    assert(ZipUnzip.unpack("A") == "A")
  }

  test("AAAAABBBCCC -> 5A3B3C") {
    assert(ZipUnzip.pack("AAAAABBBCCC") == "5A3B3C")
  }
  test("5A3B3C -> AAAAABBBCCC") {
    assert(ZipUnzip.pack("5A3B3C") == "AAAAABBBCCC")
  }

  test("AAAAABCDDD -> 5ABC3D") {
    assert(ZipUnzip.pack("AAAAABCDDD") == "5ABC3D")
  }

  test("5ABC3D -> AAAAABCDDD") {
    assert(ZipUnzip.pack("5ABC3D") == "AAAAABCDDD")
  }

}
