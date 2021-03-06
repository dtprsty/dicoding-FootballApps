package com.odora.id.footballapps.ui.event.pastEvent

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.odora.id.footballapps.R
import com.odora.id.footballapps.model.Events
import com.odora.id.footballapps.ui.detail.match.MatchDetailActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class PastEventAdapter(private val events: List<Events>) : RecyclerView.Adapter<PastEventAdapter.TeamsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {

        return TeamsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.match, parent, false))
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
            holder.bindItem(events [position])
    }

    override fun getItemCount(): Int = events.size

    class TeamsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txDate: TextView = itemView.find(R.id.txDate)
        private val txHomeTeam: TextView = itemView.find(R.id.txHomeTeam)
        private val txAwayTeam: TextView = itemView.find(R.id.txAwayTeam)
        private val txAwayScore: TextView = itemView.find(R.id.txAwayScore)
        private val txHomeScore: TextView = itemView.find(R.id.txHomeScore)
        private val rootView: LinearLayout= itemView.rootView as LinearLayout

        fun bindItem(events: Events) {
            txDate.text = events.strDate
            txHomeTeam.text = events.homeTeam
            txAwayTeam.text = events.awayTeam
            txHomeScore.text = events.homeScore.toString()
            txAwayScore.text = events.awayScore.toString()

            rootView.setOnClickListener {
                itemView.context.startActivity<MatchDetailActivity>("idHomeTeam" to "${events.idHomeTeam}", "idAwayTeam" to "${events.idAwayTeam}", "idEvent" to "${events.idEvent}", "fragment" to "past")
            }

        }
    }

}