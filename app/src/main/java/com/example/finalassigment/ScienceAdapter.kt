package com.example.finalassigment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassigment.data.Science

class ScienceAdapter(private val scienceList: List<Science>) : RecyclerView.Adapter<ScienceAdapter.ScienceViewHolder>() {

    class ScienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvfield: TextView = itemView.findViewById(R.id.tvfield)
        val tvconcept: TextView = itemView.findViewById(R.id.tvconcept)
        val tvscientist: TextView = itemView.findViewById(R.id.tvscientist)
        val tvyearProposed: TextView = itemView.findViewById(R.id.tvyearProposed)
        val tvbranch: TextView = itemView.findViewById(R.id.tvbranch)
        val btnSeeDetail: Button = itemView.findViewById(R.id.btnSeeDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScienceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_science, parent, false)
        return ScienceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScienceViewHolder, position: Int) {
        val science = scienceList[position]
        holder.tvfield.text = science.field
        holder.tvconcept.text = science.concept
        holder.tvscientist.text = science.scientist
        holder.tvyearProposed.text = science.yearProposed.toString()
        holder.tvbranch.text = science.branch

        holder.btnSeeDetail.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ScienceDetailActivity::class.java).apply {
                putExtra("description", science.description)
                putExtra("field",science.field)
                putExtra("concept", science.concept)
                putExtra("scientist",science.scientist)
                putExtra("year proposed",science.yearProposed)
                putExtra("branch",science.branch)

            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return scienceList.size
    }
}