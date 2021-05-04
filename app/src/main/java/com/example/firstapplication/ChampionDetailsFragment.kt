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
    private lateinit var champDet: TextView

    private lateinit var skillTi: TextView
    private lateinit var skillDe: TextView
    private lateinit var imageSource: ImageView
    private lateinit var skillSource: ImageView

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
        skillTi = view.findViewById(R.id.tvChampSkillT)
        skillDe = view.findViewById(R.id.tvChampSkillD)
        imageSource = view.findViewById(R.id.tvChampImg)
        skillSource = view.findViewById(R.id.tvSkillImg)
        champDet = view.findViewById(R.id.tvChampDet)


        // set details to layout
        champName.text = champion.name
        skillTi.text = champion.skillTitle
        skillDe.text = champion.skillDes
        champDet.text = champion.skillDes
        var skillImg = champion.name.replace("\\s+|'".toRegex(), "").toLowerCase()
        var imgName = champion.name.replace("\\s+|'".toRegex(), "")
        Picasso.get()
            .load("https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/champions/TFT5_"+imgName+".png")
            .into(imageSource)

        Picasso.get()
            .load("https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/championskills/"+skillImg+"_passive.png")
            .into(skillSource)

        return view
    }

}