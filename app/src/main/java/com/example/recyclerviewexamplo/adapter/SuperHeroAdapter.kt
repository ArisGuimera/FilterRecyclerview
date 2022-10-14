package com.example.recyclerviewexamplo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexamplo.R
import com.example.recyclerviewexamplo.SuperHero

class SuperHeroAdapter(
    private var superheroList: List<SuperHero>,
    private val onClickListener: (SuperHero) -> Unit,
    private val onClickDelete:(Int) -> Unit
) : RecyclerView.Adapter<SuperHeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superheroList[position]
        holder.render(item, onClickListener, onClickDelete)
    }

    override fun getItemCount(): Int = superheroList.size

    fun updateSuperHeroes(superheroList: List<SuperHero>){
        this.superheroList = superheroList
        notifyDataSetChanged()
    }
}