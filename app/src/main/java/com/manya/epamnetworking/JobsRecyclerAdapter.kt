package com.manya.epamnetworking

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

/**
 *
 * Simple [RecyclerView.Adapter] with inner class realization [RecyclerView.ViewHolder] for display jobs list.
 *
 * @author Maria Kirdun
 */

class JobsRecyclerAdapter (private val jobs : List<Job>,
                           private val context: Context) : RecyclerView.Adapter<JobsRecyclerAdapter.JobsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        val inflater = LayoutInflater.from(context)
        return JobsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        val job = jobs[position]
        holder.bind(job)
    }

    override fun getItemCount(): Int {
        return jobs.size
    }

    class JobsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_layout, parent, false)) {

        private val companyTV : TextView = itemView.findViewById(R.id.company)
        private val positionTV : TextView = itemView.findViewById(R.id.position)
        private val locationTV : TextView = itemView.findViewById(R.id.location)

        fun bind(job : Job){
            companyTV.text = job.company
            positionTV.text = job.position
            locationTV.text = job.location
        }

    }

}