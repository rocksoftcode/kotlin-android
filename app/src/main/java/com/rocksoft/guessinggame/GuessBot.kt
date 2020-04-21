package com.rocksoft.guessinggame

import com.rocksoft.guessinggame.constants.HINT_PREFIX
import java.util.*



data class GuessBot(val item:String, val hints: MutableList<String>) {
    fun isCorrect(guess: String) = guess.toLowerCase(Locale.ROOT) == this.item.toLowerCase(Locale.ROOT)

    fun isGameOver() = hints.isEmpty()

    fun hint(): String {
        val randomHint = (0 until hints.size).shuffled().first()
        val randomPrefix = (HINT_PREFIX.indices).shuffled().first()
        return HINT_PREFIX[randomPrefix] + " Hint: " + hints.removeAt(randomHint)
    }
}