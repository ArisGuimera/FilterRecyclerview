package com.example.recyclerviewexamplo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexamplo.adapter.SuperHeroAdapter
import com.example.recyclerviewexamplo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mutableSuperHeroList = mutableListOf<SuperHero>()
    private lateinit var adapter: SuperHeroAdapter
    private val manager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mutableSuperHeroList = SuperHeroProvider.superheroList.toMutableList()
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener { addSuperHero() }
        initRecyclerView()
    }

    private fun addSuperHero() {
        val superhero = SuperHero("Random", "Marvel", "Pepito", "https://pbs.twimg.com/media/DOgfDmmXcAACDTm.jpg")
        mutableSuperHeroList.add(7, superhero)
        adapter.notifyItemInserted(7)
        manager.scrollToPosition(7)
    }

    private fun initRecyclerView() {
        adapter = SuperHeroAdapter(mutableSuperHeroList,
            onClickListener = { superhero -> onItemSelected(superhero) },
            onItemDeleted = { position -> onItemDeleted(position) })


        binding.recyclerSuperHero.layoutManager = manager
        binding.recyclerSuperHero.adapter = adapter
    }

    private fun onItemDeleted(position: Int) {
        mutableSuperHeroList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.realName, Toast.LENGTH_SHORT).show()
    }
}

















