package recfun

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {

    import recfun.Main.pascal

    test("pascal: col=0,row=0") {
        assert(pascal(0, 0) === 1)
    }

    test("pascal: col=0,row=2") {
        assert(pascal(0, 2) === 1)
    }

    test("pascal: col=1,row=2") {
        assert(pascal(1, 2) === 2)
    }

    test("pascal: col=1,row=3") {
        assert(pascal(1, 3) === 3)
    }

    test("pascal: col=-1,row=-3") {
        intercept[IllegalArgumentException] {
            pascal(-1, -3)
        }
    }

    test("pascal: col=7,row=6") {
        intercept[IllegalArgumentException] {
            pascal(7, 6)
        }
    }
}
