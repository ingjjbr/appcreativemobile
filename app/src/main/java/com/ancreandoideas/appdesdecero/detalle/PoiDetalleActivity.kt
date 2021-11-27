package com.ancreandoideas.appdesdecero.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ancreandoideas.appdesdecero.databinding.ActivityPoiDetalleBinding
import com.ancreandoideas.appdesdecero.model.PoiItem

class PoiDetalleActivity : AppCompatActivity() {
    private lateinit var detalleBinding: ActivityPoiDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding= ActivityPoiDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val poi :PoiItem = intent.extras?.getSerializable("poi") as PoiItem

        with(detalleBinding){
            detpoiTitleTextView.text = poi.name
            detpoiBodyRatingTextView.text = poi.rating.toString()
        }



    }
}