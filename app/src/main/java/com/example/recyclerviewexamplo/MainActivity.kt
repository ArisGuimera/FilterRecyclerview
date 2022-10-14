package com.example.recyclerviewexamplo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexamplo.adapter.SuperHeroAdapter
import com.example.recyclerviewexamplo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var superHeroMutableList: MutableList<SuperHero> =
        SuperHeroProvider.superheroList.toMutableList()
    private lateinit var adapter: SuperHeroAdapter
    private val llmanager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etFilter.addTextChangedListener { userFilter ->
            val superheroesFiltered =
                superHeroMutableList.filter { superhero ->
                    superhero.superhero.lowercase().contains(userFilter.toString().lowercase())
                }
            adapter.updateSuperHeroes(superheroesFiltered)
        }
        initRecyclerView()
    }

    private fun createSuperHero() {
        val superHero = SuperHero(
            "Incognito",
            "AristiDevsCorporation",
            "???????",
            "https://pbs.twimg.com/profile_images/1037281659727634432/5x2XVPwB_400x400.jpg"
        )

        superHeroMutableList.add(index = 3, superHero)
        adapter.notifyItemInserted(3)
        llmanager.scrollToPositionWithOffset(3, 10)
    }

    private fun initRecyclerView() {
        adapter = SuperHeroAdapter(
            superheroList = superHeroMutableList,
            onClickListener = { superhero -> onItemSelected(superhero) },
            onClickDelete = { position -> onDeletedItem(position) }
        )
        binding.recyclerSuperHero.layoutManager = llmanager
        binding.recyclerSuperHero.adapter = adapter

    }

    private fun onDeletedItem(position: Int) {
        superHeroMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    private fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.realName, Toast.LENGTH_SHORT).show()
    }
}

















