package com.example.picturesviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Imagen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen)

        val imagen = findViewById<ImageView>(R.id.imagenAnim)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        val bundle =intent.extras
        val img = bundle!!.getInt("image")

        imagen.setImageResource(img)

        var tap = false

        fab.setOnClickListener {
            if (!tap){
                tap = true
            fab.setImageResource(R.drawable.ic_continue)}
            else{
                fab.setImageResource(R.drawable.ic_pause)
                tap = false
            }
        }

    }
}