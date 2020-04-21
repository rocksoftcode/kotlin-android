package com.rocksoft.guessinggame

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.rocksoft.guessinggame.adapter.MessageListAdapter
import com.rocksoft.guessinggame.constants.ITEMS
import com.rocksoft.guessinggame.constants.VIEW_TYPE_GUESS
import com.rocksoft.guessinggame.constants.VIEW_TYPE_RESPONSE
import com.rocksoft.guessinggame.constants.VIEW_TYPE_SYSTEM
import com.rocksoft.guessinggame.model.Item
import com.rocksoft.guessinggame.model.Message

class MainActivity : AppCompatActivity() {
    private lateinit var view: ListView
    private lateinit var viewAdapter: MessageListAdapter
    private lateinit var guessTextView: EditText
    private lateinit var guessBot: GuessBot

    fun setup() {
        val item = ITEMS[(ITEMS.indices).shuffled().first()]
        guessBot = GuessBot(item.name, item.hints)
        viewAdapter.add(Message("OK, I'm thinking of ${item.type}.  Can you guess what it is?", VIEW_TYPE_RESPONSE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        guessTextView = findViewById(R.id.editText)
        viewAdapter = MessageListAdapter(this)
        view = findViewById(R.id.dialogue)
        view.adapter = viewAdapter
        setup()
    }

    fun submitGuess(v: View) {
        val guess = guessTextView.text.toString()
        if (guess.isNotEmpty()) {
            viewAdapter.add(Message(guess, VIEW_TYPE_GUESS))
            guessTextView.text.clear()
            if (guessBot.isCorrect(guess)) {
                viewAdapter.add(Message("You got it! Play again?", VIEW_TYPE_SYSTEM))
            } else if (guessBot.isGameOver()) {
                viewAdapter.add(Message("Game Over! Try again?", VIEW_TYPE_SYSTEM))
            } else {
                viewAdapter.add(Message(guessBot.hint(), VIEW_TYPE_RESPONSE))
            }
        }
        view.setSelection(view.count - 1)
    }
}
