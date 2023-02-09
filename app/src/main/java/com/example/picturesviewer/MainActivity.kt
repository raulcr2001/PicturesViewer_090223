package com.example.picturesviewer

import AdaptadorCards
import Card
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cards = ArrayList<Card>()

        cards.add(Card(R.drawable.image8))
        cards.add(Card(R.drawable.image3))
        cards.add(Card(R.drawable.image6))
        cards.add(Card(R.drawable.image7))
        cards.add(Card(R.drawable.image1))
        cards.add(Card(R.drawable.image4))
        cards.add(Card(R.drawable.image2))
        cards.add(Card(R.drawable.image5))


        val recView = findViewById<RecyclerView>(R.id.recyclerview)
        recView.setHasFixedSize(true)

        val adaptador = AdaptadorCards(cards)
        recView.adapter = adaptador
        recView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        adaptador.onClick = {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return true
    }

    private val actionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            menuInflater.inflate(R.menu.menu_opciones, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            TODO("Not yet implemented")
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            TODO("Not yet implemented")
        }
    }


}