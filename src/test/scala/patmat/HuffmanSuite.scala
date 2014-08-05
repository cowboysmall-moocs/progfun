package patmat

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {

    trait TestTrees {
        val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
        val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
    }

    test("weight of a larger tree") {
        new TestTrees {
            assert(weight(t1) === 5)
        }
    }

    test("chars of a larger tree") {
        new TestTrees {
            assert(chars(t2) === List('a', 'b', 'd'))
        }
    }



    test("string2chars(\"hello, world\")") {
        assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
    }

    test("test times(List('a', 'b', 'a'))") {
        assert(times(List('a', 'b', 'a')) === List(('a', 2), ('b', 1)))
    }

    test("test times(List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))") {
        assert(times(List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd')) === List(('d', 1), ('l', 3), ('r', 1), ('o', 2), ('w', 1), (' ', 1), (',', 1), ('e', 1), ('h', 1)))
    }



    test("test singleton") {
        new TestTrees {
            assert(singleton(List(t1)) === true)
            assert(singleton(List(t1, t2)) === false)
        }
    }

    test("test singleton of Nil") {
        new TestTrees {
            assert(singleton(Nil) === false)
        }
    }

    test("test singleton of Empty List") {
        new TestTrees {
            assert(singleton(List()) === false)
        }
    }



    test("makeOrderedLeafList for some frequency table") {
        assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
    }

    test("makeOrderedLeafList for some other frequency table") {
        assert(makeOrderedLeafList(List(('d', 1), ('l', 3), ('r', 1), ('o', 2), ('w', 1), (' ', 1), (',', 1), ('e', 1), ('h', 1))) === List(Leaf('d', 1), Leaf('r', 1), Leaf('w', 1), Leaf(' ', 1), Leaf(',', 1), Leaf('e', 1), Leaf('h', 1), Leaf('o', 2), Leaf('l', 3)))
    }



    test("combine some leaf list") {
        val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
        assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
    }

    test("combine some other leaf list") {
        val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4), Leaf('y', 5))
        assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4), Leaf('y', 5)))
    }



    test("decode empty list") {
        new TestTrees {
            assert(decode(t1, List()) === "".toList)
        }
    }

    test("decode bits") {
        new TestTrees {
            assert(decode(t1, List(0, 1)) === "ab".toList)
            assert(decode(t2, List(0, 0, 0, 1, 1)) === "abd".toList)
        }
    }



    test("encode empty text") {
        new TestTrees {
            assert(encode(t1)("".toList) === List())
        }
    }

    test("encode characters") {
        new TestTrees {
            assert(encode(t2)("a".toList) === List(0, 0))
            assert(encode(t2)("b".toList) === List(0, 1))
            assert(encode(t2)("d".toList) === List(1))
        }
    }



    test("quick encode empty text") {
        new TestTrees {
            assert(quickEncode(t1)("".toList) === List())
        }
    }

    test("quick encode characters") {
        new TestTrees {
            assert(quickEncode(t2)("a".toList) === List(0, 0))
            assert(quickEncode(t2)("b".toList) === List(0, 1))
            assert(quickEncode(t2)("d".toList) === List(1))
        }
    }



    test("decode and encode a very short text should be identity") {
        new TestTrees {
            assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
        }
    }

    test("decode and quick encode a very short text should be identity") {
        new TestTrees {
            assert(decode(t1, quickEncode(t1)("ab".toList)) === "ab".toList)
        }
    }



    test("decode and encode some text should be identity") {
        new TestTrees {
            assert(decode(frenchCode, encode(frenchCode)("abcdefghijklmnopqrstuvwxyz".toList)) === "abcdefghijklmnopqrstuvwxyz".toList)
        }
    }

    test("decode and quick encode some text should be identity") {
        new TestTrees {
            assert(decode(frenchCode, quickEncode(frenchCode)("abcdefghijklmnopqrstuvwxyz".toList)) === "abcdefghijklmnopqrstuvwxyz".toList)
        }
    }



    test("decoded secret") {
        assert(decodedSecret === List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
    }
}
