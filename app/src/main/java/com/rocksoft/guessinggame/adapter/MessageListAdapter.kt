package com.rocksoft.guessinggame.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.rocksoft.guessinggame.MainActivity
import com.rocksoft.guessinggame.R
import com.rocksoft.guessinggame.constants.VIEW_TYPE_GUESS
import com.rocksoft.guessinggame.constants.VIEW_TYPE_RESPONSE
import com.rocksoft.guessinggame.model.Message

data class MessageHolder(val message: TextView)

data class MessageListAdapter(val context: MainActivity, val messages: MutableList<Message> = ArrayList()) :
    BaseAdapter() {

    fun add(message: Message) {
        messages.add(message)
        notifyDataSetChanged()
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val message = messages[position]
        val inflater = context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View
        if (message.type == VIEW_TYPE_GUESS) {
            view = inflater.inflate(R.layout.guess, null)
        } else if (message.type == VIEW_TYPE_RESPONSE) {
            view = inflater.inflate(R.layout.response, null)
        } else {
            view = inflater.inflate(R.layout.system, null)
            view.setOnClickListener {
                messages.clear()
                notifyDataSetChanged()
                context.setup()
            }
        }
        val holder = MessageHolder(view.findViewById(R.id.text_message_body))
        holder.message.text = message.data
        view.tag = holder

        return view
    }

    override fun getItem(position: Int) = messages[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = messages.size
}
