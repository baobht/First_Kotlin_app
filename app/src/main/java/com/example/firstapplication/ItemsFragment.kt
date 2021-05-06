package com.example.firstapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
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
import com.example.firstapplication.Adapter.ItemAdapter
import com.example.firstapplication.Model.ItemData
import org.json.JSONArray
import org.json.JSONException
import java.util.*

class ItemsFragment : Fragment(R.layout.fragment_items_list) {
    private lateinit var rvItems: RecyclerView

    private lateinit var mainActivity: FragmentActivity
    private var requestQueue: RequestQueue? = null
    private lateinit var basicItems: MutableList<ItemData>
    private lateinit var combinedItems: MutableList<ItemData>
    private lateinit var allItems: MutableList<MutableList<ItemData>>
    private lateinit var spinner: Spinner

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
        val view = inflater.inflate(R.layout.fragment_items_list, container, false)
        basicItems = mutableListOf()
        combinedItems = mutableListOf()
        allItems = mutableListOf()

        rvItems = view.findViewById(R.id.rvItems)

// call api to get list item
        callApi()



        return view
    }

    private fun callApi() {
        requestQueue = Volley.newRequestQueue(this.context)
        val url =
            "https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/items.json"
        val request = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener<JSONArray> { response ->
                try {
                    val jsArray = JSONArray(response.toString())
                    for (i in 0 until jsArray.length()) {
                        val itemArr = jsArray.getJSONObject(i)
                        val item = ItemData()
                        item.id = itemArr["id"].toString()
                        item.name = itemArr["name"].toString()
                        item.description = itemArr["description"].toString()
                        item.isUnique = itemArr["isUnique"].toString().toBoolean()
                        item.isShadow = itemArr["isShadow"].toString().toBoolean()

                        if (i <= 8) {
                            basicItems.add(item)
                        } else {
                            combinedItems.add(item)

                        }


                    }
                    for (i in 0 until  basicItems.size) {
                        allItems.add(mutableListOf(basicItems[i], basicItems[i]))
//                        Log.i("I=", i.toString() + basicItems[i])
                        for (j in i + 1 until basicItems.size) {
                            allItems.add(mutableListOf(basicItems[i], basicItems[j]))
                        }
                    }

                    for (i in 0 until 45) {
                        allItems[i].add(combinedItems[i])
                    }

                    displayItemsTable()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }

    private fun displayItemsTable() {
        // call adapter
        val adapter = ItemAdapter(this.context!!, allItems,mainActivity.supportFragmentManager)
        rvItems.layoutManager = LinearLayoutManager(this.context)
        rvItems.adapter = adapter
    }
}