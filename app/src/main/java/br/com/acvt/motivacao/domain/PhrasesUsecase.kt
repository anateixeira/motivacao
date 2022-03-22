package br.com.acvt.motivacao.domain

import br.com.acvt.motivacao.data.PHRASEFILTER
import br.com.acvt.motivacao.data.Phrase
import kotlin.random.Random

class PhrasesUsecase(val mListPhrases: List<Phrase>) {

    fun getPhrase(value: Int): String {
        val filtered = mListPhrases.filter { (it.category == value || value == PHRASEFILTER.ALL) }
        val rand = (filtered.size).random()
        return filtered[rand].description
    }

    fun Int.random(): Int {
        return Random.nextInt(this)
    }
}