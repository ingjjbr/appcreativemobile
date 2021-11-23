package com.ancreandoideas.appdesdecero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        poisAdapter= POIListAdapter(listPois)

        poisrecyclerView.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=poisAdapter
            setHasFixedSize(false)
        }

    }

    private fun loadMockPoisfromJson(): ArrayList<PoiItem> {
        val poisString:String=applicationContext.assets.open("pois.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data =gson.fromJson(poisString,Poi::class.java)
        return data

    }


}