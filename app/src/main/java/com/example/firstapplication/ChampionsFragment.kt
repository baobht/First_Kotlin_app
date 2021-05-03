package com.example.firstapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.firstapplication.Adapter.ChampionListAdapter
import com.example.firstapplication.Model.ChampData
import kotlinx.android.synthetic.main.fragment_champ_list.*
import org.json.JSONArray
import org.json.JSONException

class ChampionsFragment : Fragment(R.layout.fragment_champ_list) {
    private lateinit var rvChampions: RecyclerView
    private lateinit var mainActivity: FragmentActivity
    private lateinit var progressBar: ProgressBar
    private var requestQueue: RequestQueue? = null
    private lateinit var but:Button
    private lateinit var but1:Button

    private var champions =  arrayListOf<ChampData>()

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FragmentActivity) {
            mainActivity = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_champ_list, container, false)
//        but = view.findViewById(R.id.btn)
//        but1 = view.findViewById(R.id.btn1)

        progressBar = view.findViewById(R.id.pbChampions)

        rvChampions = view.findViewById(R.id.rvChampions)
        rvChampions.setHasFixedSize(true)
        rvChampions.layoutManager = LinearLayoutManager(this.context)
        callApi()
        displayChampions()

//        but.setOnClickListener({
//            displayChampions()
//        })

        return view
    }
    private fun callApi () {
        requestQueue = Volley.newRequestQueue(this.context)

        val url = "https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/champions.json"
//        val request = JsonArrayRequest(Request.Method.GET, url, null, Response.Listener<JSONArray> {}
        val request = JsonArrayRequest(Request.Method.GET, url, null, Response.Listener<JSONArray> {
                response ->try {
            val jsArray = JSONArray(response.toString())

            for (i in 1 until jsArray.length()){
                val champArr = jsArray.getJSONObject(i)
                val champi = ChampData()
                champi.name = champArr["name"].toString()
                champi.championId = champArr["championId"].toString()
                champi.cost = champArr["cost"].toString().toInt()
                if(champArr["traits"].toString().split("[\\W]".toRegex()).size > 8){
                    champi.traits = listOf(champArr["traits"].toString().split("[\\W]".toRegex())?.get(2),champArr["traits"].toString().split("[\\W]".toRegex())?.get(5),champArr["traits"].toString().split("[\\W]".toRegex())?.get(8))
                }
                else{
                    champi.traits = listOf(champArr["traits"].toString().split("[\\W]".toRegex())?.get(2),champArr["traits"].toString().split("[\\W]".toRegex())?.get(5))
                }
                champions.add(champi)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }
    private fun displayChampions () {
        println(123)
        //cach cua Hue
//        var champions = listOf<ChampData>()
        // cach cua bao


        // send request
//        requestQueue = Volley.newRequestQueue(this.context)
//
//        val url = "https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/champions.json"
////        val request = JsonArrayRequest(Request.Method.GET, url, null, Response.Listener<JSONArray> {}
//        val request = JsonArrayRequest(Request.Method.GET, url, null, Response.Listener<JSONArray> {
//                response ->try {
//            val jsArray = JSONArray(response.toString())
//
//            for (i in 1 until jsArray.length()){
//                val champArr = jsArray.getJSONObject(i)
//                val champi = ChampData()
//                champi.name = champArr["name"].toString()
//                champi.championId = champArr["championId"].toString()
//                champi.cost = champArr["cost"].toString().toInt()
//                if(champArr["traits"].toString().split("[\\W]".toRegex()).size > 8){
//                    champi.traits = listOf(champArr["traits"].toString().split("[\\W]".toRegex())?.get(2),champArr["traits"].toString().split("[\\W]".toRegex())?.get(5),champArr["traits"].toString().split("[\\W]".toRegex())?.get(8))
//                }
//                else{
//                    champi.traits = listOf(champArr["traits"].toString().split("[\\W]".toRegex())?.get(2),champArr["traits"].toString().split("[\\W]".toRegex())?.get(5))
//                }
//                champions.add(champi)
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        }, Response.ErrorListener { error -> error.printStackTrace() })
//        requestQueue?.add(request)

        // process responses into a list
//        champions.forEach({e -> println(e.name)})
//
//        println(champions)

        // call adapter
        val adapter = ChampionListAdapter(this.context!!, champions, mainActivity.supportFragmentManager, progressBar)
        rvChampions.layoutManager= GridLayoutManager(this.context, 3)
        rvChampions.adapter = adapter
    }

}