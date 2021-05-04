package com.example.firstapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.champion.view.*
import kotlinx.android.synthetic.main.fragment_champ_list.*
import org.json.JSONArray
import org.json.JSONException

class ChampionDetailsFragment : Fragment(R.layout.champ_details) {
    private lateinit var mainActivity: FragmentActivity
    private lateinit var champName: TextView
    private lateinit var imageSource: ImageView

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
        imageSource = view.findViewById(R.id.tvChampImg)
        champName.text = champion.name
        var imgName = champion.name.replace("\\s+|'".toRegex(), "")
        Picasso.get()
            .load("https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/champions/TFT5_"+imgName+".png")
            .into(imageSource)
        return view
    }

}