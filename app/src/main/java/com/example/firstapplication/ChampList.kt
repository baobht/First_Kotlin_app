package com.example.firstapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue


class ChampList : AppCompatActivity() {
    private var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_champ_list)


        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        recyclerView.layoutManager =layoutManager
//        val adapter = ChampionListAdapter(this, DataRec)


    }

//    private fun display() {
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
//            for(i in 0 until listChamp.size()!!){
//                // if size > 8 position : 2,5,8 else position 2,5
////                    var a = listChamp.tftdata?.get(i)?.traits
//
//
//
//                Log.d(""+i,""+ listChamp.tftdata?.get(i)?.traits?.get(0))
////                   println(listChamp.tftdata?.get(i)?.name)
//            }
//
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
//    }
}