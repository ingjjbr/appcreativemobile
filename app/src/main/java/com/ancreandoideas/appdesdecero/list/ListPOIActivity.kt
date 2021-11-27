package com.ancreandoideas.appdesdecero.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ancreandoideas.appdesdecero.R
import com.ancreandoideas.appdesdecero.detalle.PoiDetalleActivity
import com.ancreandoideas.appdesdecero.model.Poi
import com.ancreandoideas.appdesdecero.model.PoiItem
import com.google.gson.Gson

class ListPOIActivity : AppCompatActivity() {
    private  lateinit var listPois: ArrayList<PoiItem>
    private  lateinit var  poisAdapter: POIListAdapter
    private  lateinit var  poisrecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poiactivity)

        poisrecyclerView=findViewById(R.id.RecyclerView_POI)

        listPois =loadMockPoisfromJson()
        poisAdapter= POIListAdapter(listPois, onItemClicked ={onPoisCliked(it)})

        poisrecyclerView.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=poisAdapter
            setHasFixedSize(false)
        }

    }

    private fun onPoisCliked(poi: PoiItem) {
        val intent = Intent(this,PoiDetalleActivity:: class.java)
        intent.putExtra("poi", poi)
        startActivity(intent)
    }

    private fun loadMockPoisfromJson(): ArrayList<PoiItem> {
        val poisString: String =
            applicationContext.assets.open("pois.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(poisString, Poi::class.java)

    }


}