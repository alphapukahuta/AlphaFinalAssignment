package com.example.finalassigment

// Import necessary Android components for RecyclerView and Intent handling
import android.content.Intent
import android.view.LayoutInflater  // To create a view from XML
import android.view.View  // Represents a UI component
import android.view.ViewGroup  // Represents a parent layout
import android.widget.Button  // For clickable buttons
import android.widget.TextView  // To display text
import androidx.recyclerview.widget.RecyclerView  // RecyclerView adapter base class
import com.example.finalassigment.data.Science  // Data model for science-related data

// Adapter for displaying a list of Science objects in a RecyclerView.
class ScienceAdapter(private val scienceList: List<Science>) :
    RecyclerView.Adapter<ScienceAdapter.ScienceViewHolder>() {

    // ViewHolder class to hold references to each item's views.
    class ScienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Bind UI components to variables for easy access.
        val tvfield: TextView = itemView.findViewById(R.id.tvfield)  // Field of science
        val tvconcept: TextView = itemView.findViewById(R.id.tvconcept)  // Concept name
        val tvscientist: TextView = itemView.findViewById(R.id.tvscientist)  // Scientist's name
        val tvyearProposed: TextView = itemView.findViewById(R.id.tvyearProposed)  // Year proposed
        val tvbranch: TextView = itemView.findViewById(R.id.tvbranch)  // Branch of science
        val btnSeeDetail: Button = itemView.findViewById(R.id.btnSeeDetail)  // Button to see details
    }

    // Creates and returns a new ViewHolder by inflating the item layout.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScienceViewHolder {
        // Inflate the item layout from XML and pass it to the ViewHolder.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_science, parent, false)
        return ScienceViewHolder(view)
    }

    // Binds data to each item's views when it is displayed in the RecyclerView.
    override fun onBindViewHolder(holder: ScienceViewHolder, position: Int) {
        val science = scienceList[position]  // Get the Science object at the current position

        // Populate the UI components with data from the Science object.
        holder.tvfield.text = science.field
        holder.tvconcept.text = science.concept
        holder.tvscientist.text = science.scientist
        holder.tvyearProposed.text = science.yearProposed.toString()
        holder.tvbranch.text = science.branch

        // Set a click listener on the "See Detail" button to launch the detail activity.
        holder.btnSeeDetail.setOnClickListener {
            val context = holder.itemView.context  // Get the context to start a new activity
            val intent = Intent(context, ScienceDetailActivity::class.java).apply {
                // Pass the Science object details to the next activity via intent extras.
                putExtra("description", science.description)
                putExtra("field", science.field)
                putExtra("concept", science.concept)
                putExtra("scientist", science.scientist)
                putExtra("year proposed", science.yearProposed)
                putExtra("branch", science.branch)
            }
            context.startActivity(intent)  // Start the detail activity
        }
    }

    // Returns the total number of items in the list.
    override fun getItemCount(): Int {
        return scienceList.size  // Size of the scienceList
    }
}
