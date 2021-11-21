package com.ancreandoideas.appdesdecero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class POIListAdapter (
    private val poisList: ArrayList<Poi>
): RecyclerView.Adapter<POIListAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view =LayoutInflater.from(parent.context).inflate(R.layout.activity_list_poiactivity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val poi =poisList[position]
        holder.bind(poi)

    }

    override fun getItemCount(): Int = poisList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameTextView: TextView = itemView.findViewById(R.id.textViewname_al)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.textViewdescripcion_al)
        private var ratingTextView: TextView = itemView.findViewById(R.id.textViewcalificacion_al)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.imageViewaventura_list)

        fun bind (poi:Poi){
            nameTextView.text=poi.name

        }

    }
}