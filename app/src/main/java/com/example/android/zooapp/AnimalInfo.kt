package com.example.android.zooapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class AnimalInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle:Bundle = intent.extras
        tvName.text = bundle.getString("name")
        tvDescr.text =bundle.getString("descr")
        imgAnimal.setImageResource(bundle.getInt("imgAnimal"))
    }
}
