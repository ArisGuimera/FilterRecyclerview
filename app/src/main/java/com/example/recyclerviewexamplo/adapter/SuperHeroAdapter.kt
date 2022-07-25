package com.example.recyclerviewexamplo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexamplo.R
import com.example.recyclerviewexamplo.SuperHero

class SuperHeroAdapter(
    private val superheroList: List<SuperHero>,
    private val onClickListener: (SuperHero) -> Unit,
    private val onItemDeleted: (Int) -> Unit
) : RecyclerView.Adapter<SuperHeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superheroList[position]
        holder.render(item, onClickListener, onItemDeleted)
    }

    override fun getItemCount(): Int = superheroList.size
}