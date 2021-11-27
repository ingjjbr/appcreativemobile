package com.ancreandoideas.appdesdecero.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ancreandoideas.appdesdecero.R
import com.ancreandoideas.appdesdecero.model.PoiItem
import com.squareup.picasso.Picasso

class POIListAdapter (
        private val poisList: ArrayList<PoiItem>,
        private  val onItemClicked: (PoiItem) ->Unit
): RecyclerView.Adapter<POIListAdapter.PoiViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
       val view =LayoutInflater.from(parent.context).inflate(R.layout.card_view_poi_item, parent, false)
        return PoiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoiViewHolder, position: Int) {
        val poi =poisList[position]
        holder.itemView.setOnClickListener { onItemClicked(poisList[position]) }
        holder.bind(poi)

    }

    override fun getItemCount(): Int = poisList.size

    class PoiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameTextView: TextView = itemView.findViewById(R.id.textViewname_al)
        private var ratingTextView: TextView = itemView.findViewById(R.id.textViewcalificacion_al)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.imageViewaventura_list)

        fun bind(poi: PoiItem) {
            nameTextView.text = poi.name
            poi.rating.also { ratingTextView.text = it.toString() }
            Picasso.get().load(poi.urlPicture).into(pictureImageView)

            }

        }

    }
