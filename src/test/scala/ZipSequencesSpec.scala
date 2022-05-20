import org.scalacheck.Prop.forAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatestplus.scalacheck.Checkers

class ZipSequencesSpec extends AnyFlatSpec with should.Matchers with Checkers {

  import ZipSequences._

  it should "check if lengths of two sequences are equal" in {
    check((a: List[Int], b: List[Int]) => zipper(a, b).size == (a ::: b).size)
  }

  it should "return empty list" in {
    check((a: List[Int], b: List[Int]) => zipper(a, b).empty == List())
  }

  it should "end with sequence b" in {
    forAll { (a: List[Int], b: List[Int]) =>
      zipper(a, b).endsWith(a)
    }
  }
}
