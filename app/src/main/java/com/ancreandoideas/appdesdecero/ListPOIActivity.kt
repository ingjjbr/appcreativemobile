package com.ancreandoideas.appdesdecero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListPOIActivity : AppCompatActivity() {
    private  lateinit var listPois: ArrayList<Poi>
    private  lateinit var  poisAdapter: POIListAdapter
    private  lateinit var  poisrecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poiactivity)

        poisrecyclerView=findViewById(R.id.RecyclerView_POI)
        listPois =createMockPois()
        poisAdapter= POIListAdapter(listPois)
        //poisrecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        poisrecyclerView.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=poisAdapter
            setHasFixedSize(false)
        }

    }


    private fun createMockPois():ArrayList<Poi>{
        return  arrayListOf(
            Poi(
                name = "Rafting",
                description = "Rafting Chibiriquete",
               // rating = 4.0,
            ),
            Poi(
                name = "Vuelo",
                description = "Sobre volar la sierra de  Chibiriquete",
               // rating = 4.5,
            )
        )
    }
}