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
        //listPois =createMockPois()
        listPois =loadMockPoisfromJson()
        poisAdapter= POIListAdapter(listPois)
        //poisrecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
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

/*
    private fun createMockPois():ArrayList<Poi>{
        return  arrayListOf(
            Poi(
                name = "Rafting",
                description = "Rafting Chibiriquete",
                urlPicture = "https://i.ibb.co/fnFczcY/icon-aventura-rafting.jpg",
                 rating = 4.0,
            ),
            Poi(
                name = "Vuelo",
                description = "Sobre volar la sierra de  Chibiriquete",
                urlPicture= "https://es.seaicons.com/wp-content/uploads/2016/05/airplane-icon.png",
                rating = 4.5
            ),
            Poi(
                name = "Senderismo",
                description = "Senderismo Chibiriquete",
                urlPicture= "https://st.depositphotos.com/2065405/4445/i/950/depositphotos_44455309-stock-photo-icon-button-pictogram-canoeing.jpg",
                rating = 4.0
            ),
        )
    }*/
}