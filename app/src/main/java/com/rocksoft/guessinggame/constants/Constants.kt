package com.rocksoft.guessinggame.constants

import com.rocksoft.guessinggame.R
import com.rocksoft.guessinggame.model.Item

val VIEW_TYPE_GUESS = 1
val VIEW_TYPE_RESPONSE = 2
val VIEW_TYPE_SYSTEM = 3
val VIEW_TYPE_TO_LAYOUT = mapOf<Int, Int>(VIEW_TYPE_GUESS to R.layout.guess, VIEW_TYPE_RESPONSE to R.layout.response)
val HINT_PREFIX = arrayOf("Not quite...", "Nope!", "Close, but no cigar.")

val ITEMS = arrayOf(
    Item("an animal", "Duck", mutableListOf("Feathers", "Bill", "Webbed feet", "Quack quack!")),
    Item("a household item", "Kettle", mutableListOf("The pot calls it black", "You make tea with it")),
    Item("a car", "Volvo", mutableListOf("Boxy, but good", "Swedish", "Safe", "Quirky")),
    Item("a game", "Donkey Kong", mutableListOf("Features jump man", "The boss is an angry ape", "You jump barrels", "It goes on forever")),
    Item("a number", "101", mutableListOf("Less than 150", "More than 78", "Intro level", "Palindrome")))