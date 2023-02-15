package com.example.picturesviewer

import AdaptadorCards
import Card
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    val cards = ArrayList<Card>()
    lateinit var recView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val adaptador = AdaptadorCards(cards, ::lanzar)
        recView.adapter = adaptador
        recView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        var modeCallBack: android.view.ActionMode.Callback = object : android.view.ActionMode.Callback {
            override fun onActionItemClicked(mode: android.view.ActionMode?, item: MenuItem?): Boolean {
                val id = item?.itemId
                when (id) {
                    R.id.action_editar -> {
                        Log.i("MainActivity", "editar")
                        mode?.finish()
                    }
                    R.id.action_eliminar -> {
                        Log.i("MainActivity", "eliminar")
                        mode?.finish()
                    }
                    R.id.action_compartir -> {
                        Log.i("MainActivity", "compartir")
                        mode?.finish()
                    }
                    else -> return false
                }
                return true
            }

            override fun onPrepareActionMode(mode: android.view.ActionMode, menu: Menu): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: android.view.ActionMode?) {
                var mode = mode
                mode = null
            }

            override fun onCreateActionMode(mode: android.view.ActionMode, menu: Menu): Boolean {
                mode.setTitle("Options")
                mode.getMenuInflater().inflate(R.menu.menu_opciones, menu)
                return true
            }
        }

        adaptador.onLongClick = { view ->
            view.startActionMode(modeCallBack)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun lanzar(view: View) {

        val i = Intent(this, Imagen::class.java)
        val item = cards.get(recView.getChildAdapterPosition(view))
        val p1 = Pair.create<View, String>(view, view.transitionName)

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1).toBundle()
        options?.putString("String", view.transitionName)
        options?.putInt("Imagen", item.foto)
        //Añadimos la información al Intent
        i.putExtras(options!!)
        startActivity(i, options)
        overridePendingTransition(R.transition.slide, R.transition.slide);

    }
}