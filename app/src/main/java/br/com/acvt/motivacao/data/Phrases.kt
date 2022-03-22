package br.com.acvt.motivacao.data


data class Phrase(val description: String, val category: Int)

object Mock {
    fun phrasesMock() = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", PHRASEFILTER.HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", PHRASEFILTER.HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", PHRASEFILTER.HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", PHRASEFILTER.HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", PHRASEFILTER.HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", PHRASEFILTER.HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", PHRASEFILTER.MORNING),
        Phrase("Você perde todas as chances que você não aproveita.", PHRASEFILTER.MORNING),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", PHRASEFILTER.MORNING),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", PHRASEFILTER.MORNING),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", PHRASEFILTER.MORNING),
        Phrase("Se você acredita, faz toda a diferença.", PHRASEFILTER.MORNING),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", PHRASEFILTER.MORNING)
    )
}

object PHRASEFILTER {
    val ALL = 0
    val HAPPY = 1
    val MORNING = 2
}
