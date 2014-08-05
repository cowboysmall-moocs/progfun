package funsets

object Main extends App {

    import FunSets._

    println(contains(singletonSet(1), 1))


    val s = union(singletonSet(1), singletonSet(2))
    printSet(s)

    printSet(map(s, x => x + 2))
}
