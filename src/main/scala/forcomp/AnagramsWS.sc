import forcomp.Anagrams._

object AnagramsWS {

    def sentenceAnagrams(sentence: Sentence): List[Sentence] = {
        def anagrams(occurrences: Occurrences): List[Sentence] = occurrences match {
            case Nil => List(List())
            case _ => {
                for {
                    o <- combinations(occurrences)
                    w <- dictionaryByOccurrences(o)
                    s <- anagrams(subtract(occurrences, wordOccurrences(w)))
                    if !o.isEmpty
                } yield w :: s
            }
        }
        anagrams(sentenceOccurrences(sentence))
    }

    sentenceAnagrams(List("Linux", "rulez"))
}

