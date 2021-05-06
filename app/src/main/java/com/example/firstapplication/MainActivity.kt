package com.example.firstapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.toolbox.*
import com.example.firstapplication.Model.ChampData
import com.example.firstapplication.databinding.ActivityMainBinding
import com.ismaeldivita.chipnavigation.ChipNavigationBar


class MainActivity : AppCompatActivity() {
    private var requestQueue: RequestQueue? = null
    var li: ArrayList<ChampData>? = null

    lateinit var binding: ActivityMainBinding
    lateinit var navigation: ChipNavigationBar
    lateinit var champFragment: ChampionsFragment
    lateinit var itemsFragment: ItemsFragment
    lateinit var traitsFragment: TraitsFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        navigation = findViewById(R.id.navigation)

        // set Champion fragment as the first fragment user see
        navigation.setItemSelected(R.id.nav_champ)

        champFragment = ChampionsFragment()
        itemsFragment = ItemsFragment()
        traitsFragment = TraitsFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMainContent, champFragment)
            commit()
        }

        navChange()

    }

    private fun navChange() {
        navigation.setOnItemSelectedListener {
            when (it) {
                R.id.nav_champ -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flMainContent, champFragment)
                        addToBackStack(null)
                        commit()
                    }
                }
                R.id.nav_items -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flMainContent, itemsFragment)
                        addToBackStack(null)
                        commit()
                    }
                }
                R.id.nav_traits -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flMainContent, traitsFragment)
                        addToBackStack(null)
                        commit()
                    }
                }
            }

        }
    }
}