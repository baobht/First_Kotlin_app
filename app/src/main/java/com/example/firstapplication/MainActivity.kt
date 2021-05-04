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

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMainContent, champFragment)
            commit()
        }

        navChange()


//        button.setOnClickListener({
//            jsonParse()
//        })
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
            }

        }
    }

//    private fun jsonParse() {
//
//        requestQueue = Volley.newRequestQueue(this)
//
//        var listChamp = DataRec()
//
//        val url = "https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/champions.json"
//        val request = JsonArrayRequest(Request.Method.GET, url, null, Response.Listener<JSONArray> {
//                response ->try {
//            val jsonArray = response.toString()
//            val jsArray = JSONArray(response.toString())
//
//            for (i in 1 until jsArray.length()){
//                val champArr = jsArray.getJSONObject(i)
//                val champi = ChampData()
//                champi.name = champArr["name"].toString()
//                champi.championId = champArr["championId"].toString()
//                champi.cost = champArr["cost"].toString().toInt()
//                listChamp?.tftdata?.add(champi)
//                if(champArr["traits"].toString().split("[\\W]".toRegex()).size > 8){
//                    champi.traits = listOf(champArr["traits"].toString().split("[\\W]".toRegex())?.get(2),champArr["traits"].toString().split("[\\W]".toRegex())?.get(5),champArr["traits"].toString().split("[\\W]".toRegex())?.get(8))
//                }
//                else{
//                    champi.traits = listOf(champArr["traits"].toString().split("[\\W]".toRegex())?.get(2),champArr["traits"].toString().split("[\\W]".toRegex())?.get(5))
//                }
//                val traitsArr = champArr.getJSONArray("traits")
//
//
//
//            }
////
////            for(i in 0 until listChamp.size()!!){
////                // if size > 8 position : 2,5,8 else position 2,5
//////                    var a = listChamp.tftdata?.get(i)?.traits
////
////
////
////                Log.d(""+i,""+ listChamp.tftdata?.get(i)?.traits?.get(0))
//////                   println(listChamp.tftdata?.get(i)?.name)
////            }
//
//            li = listChamp.tftdata
//
//            for (i in li!!){
//                println(i)
//            }
////           }
////                println(obj)
////            }
////            println(jsArray[1])
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        }, Response.ErrorListener { error -> error.printStackTrace() })
//        requestQueue?.add(request)
//
//        //        for (i in li!!){
////            println(i.name)
////        }
//
//    }
}