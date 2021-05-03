package com.example.firstapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapplication.Model.ChampData
import com.example.firstapplication.R
import android.os.Bundle
import android.widget.ProgressBar
import com.example.firstapplication.ChampionDetailsFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.champion.view.*

class ChampionListAdapter(
    private val context: Context,
    private val champions: List<ChampData>,
    private val supportFragmentManager: FragmentManager,
    private val progressBar: ProgressBar

    ) : RecyclerView.Adapter<ChampionListAdapter.ChampionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.champion, parent, false)

        progressBar.visibility = ProgressBar.GONE

        return ChampionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return champions.size;
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        val currentChamp = champions[position]
//        println(champion)
        holder.setData(currentChamp)

        // on click a champion
        holder.itemView.setOnClickListener{
            val bundle = Bundle()
            bundle.putSerializable("champ", currentChamp)

            val championDetailsFragment = ChampionDetailsFragment()
            championDetailsFragment.arguments = bundle

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flMainContent, championDetailsFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    inner class ChampionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(champion: ChampData) {
//            var url = "\"https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/champions/TFT5_Aatrox.png\""
//            var image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            itemView.imageShare.setImageBitmap(image);
            itemView.tvTitle.text = champion.name
            var imgName = champion.name.replace("\\s+|'".toRegex(), "")

            Picasso.get()
                .load("https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/champions/TFT5_"+imgName+".png")
                .into(itemView.ivChampImg)
//            itemView.imageShare
        }
    }
}


