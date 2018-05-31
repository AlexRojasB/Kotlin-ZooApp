package com.example.android.zooapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.animal_ticket.view.*


class AnimalsAdapter(context: Context, listOfAnimals: ArrayList<Animal>) : BaseAdapter() {
    var ListOfAnimals = listOfAnimals
    var ParentContext:Context? = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val animal = this.ListOfAnimals[position]
        var layoutUsed:Int
        if(animal.IsKiller){
            layoutUsed = R.layout.animal_killer_ticket
        }else{
            layoutUsed = R.layout.animal_ticket
        }
        val convertView = convertView ?: LayoutInflater.from(this.ParentContext).inflate(layoutUsed, parent, false)
        val holder = convertView.tag as? ViewHolder ?: ViewHolder(convertView)
        convertView.tag = holder
        convertView.tvName.text = animal.Name
        convertView.tvDescr.text = animal.Descr
        convertView.imgAnimal.setImageResource(animal.ImgAnimal)
        convertView.setOnClickListener({
            val intent = Intent(this.ParentContext, AnimalInfo::class.java)
            intent.putExtra("name", animal.Name)
            intent.putExtra("descr", animal.Descr)
            intent.putExtra("imgAnimal", animal.ImgAnimal)
            intent.putExtra("isKiller", animal.IsKiller)
            this.ParentContext!!.startActivity(intent)
        })
        return convertView
    }

    override fun getItem(position: Int): Any {
        return  this.ListOfAnimals[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getCount(): Int {
        return this.ListOfAnimals.size
    }
   inner class ViewHolder(view: View) {
        val tvName: TextView = view.tvName // etc
        val tvDescr: TextView = view.tvDescr // etc
        val imgAnimal: ImageView = view.imgAnimal // etc
    }
}