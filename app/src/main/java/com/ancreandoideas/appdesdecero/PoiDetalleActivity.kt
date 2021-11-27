package com.ancreandoideas.appdesdecero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PoiDetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poi_detalle)
        val namedetallepoi=intent.getStringExtra("namedetalle")
        val namedetallepoitexview=findViewById<TextView>(R.id.detallepoi_textView)
        namedetallepoitexview.text=namedetallepoi
    }
}