package io.github.xit0c.mapboxpluginofflinedemo

import android.util.Log
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class LogAdapter: RecyclerView.Adapter<LogAdapter.LogViewHolder>() {

    private val logs = mutableListOf<LogMessage>()
    private var rv: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        rv = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        rv = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder =
            LogViewHolder(TextView(parent.context))

    override fun getItemCount(): Int = logs.size

    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
        holder.bind(logs[position])
    }

    fun addLog(log: LogMessage) {
        Log.d(log.tag, log.message)
        logs.add(log)
        notifyItemInserted(logs.size - 1)
        rv?.scrollToPosition(logs.size - 1)
    }

    class LogViewHolder(itemView: TextView): RecyclerView.ViewHolder(itemView) {

        private val textView = itemView.apply { setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f) }

        fun bind(log: LogMessage) {
            textView.text = log.formattedMessage
            textView.setTextColor(ContextCompat.getColor(textView.context, log.color))
        }
    }
}