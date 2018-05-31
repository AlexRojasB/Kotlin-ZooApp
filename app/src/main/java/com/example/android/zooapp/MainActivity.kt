package com.example.android.zooapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var ListOfAnimals = ArrayList<Animal>()
    var ListAnimalsAdapter:AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.ListOfAnimals.add(Animal("Baboon", "Baboon live in big place with tree", R.drawable.baboon, false))
        this.ListOfAnimals.add(Animal("Bulldog", "Bulldog is a common pet", R.drawable.bulldog, false))
        this.ListOfAnimals.add(Animal("Panda", "Panda is a white and black animal", R.drawable.panda, true))
        this.ListOfAnimals.add(Animal("Swallow Bird", "Swallow is a small bird ", R.drawable.swallow_bird, false))
        this.ListOfAnimals.add(Animal("White Tiger", "Do you have the eye of the tiger", R.drawable.white_tiger, true))
        this.ListOfAnimals.add(Animal("Zebra", "Zebra is another white and black animal", R.drawable.zebra,false))
        ListAnimalsAdapter = AnimalsAdapter(this, this.ListOfAnimals)
        lvAnimals.adapter = this.ListAnimalsAdapter
    }

    fun DeleteAnimal(index: Int){
        this.ListOfAnimals.removeAt(index)
        this.ListAnimalsAdapter!!.notifyDataSetChanged()
    }
}
