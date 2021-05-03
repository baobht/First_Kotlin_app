package com.example.firstapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ProgressBar
import android.widget.TextView
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

class ChampionDetailsFragment : Fragment(R.layout.champ_details) {
    private lateinit var mainActivity: FragmentActivity
    private lateinit var champName: TextView

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
        val view = inflater.inflate(R.layout.champ_details, container, false)

        // get bundle
        val champion = arguments!!.getSerializable("champ") as ChampData

        champName = view.findViewById(R.id.tvChampName)
        champName.text = champion.name

        return view
    }

}