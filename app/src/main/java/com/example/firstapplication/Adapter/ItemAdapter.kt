package com.example.firstapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapplication.R
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.firstapplication.ChampionDetailsFragment
import com.example.firstapplication.CusTomDialogFragment
import com.example.firstapplication.Model.ItemData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.champion.view.*
import kotlinx.android.synthetic.main.item.view.*
import java.util.ArrayList

class ItemAdapter(
    private val context: Context,
    private val items: MutableList<MutableList<ItemData>>,
    private val supportFragmentManager: FragmentManager

) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private lateinit var cvItem1: CardView
    private lateinit var cvItem2: CardView
    private lateinit var cvItem3: CardView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        cvItem1 = view.findViewById(R.id.cvItem1)
        cvItem2 = view.findViewById(R.id.cvItem2)
        cvItem3 = view.findViewById(R.id.cvItem3)


        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val curItem = items[position]
        Log.d("Item","${curItem[0].id} - ${curItem[1].id} - ${curItem[2].id}")

        val item1 = curItem[0]
        val item2 = curItem[1]
        val item3 = curItem[2]

        holder.setData(curItem)




        cvItem1.setOnClickListener{
            Log.d("Item","${curItem[0].id}")
            val bundle = Bundle()
            bundle.putSerializable("item", item1)
            bundle.putInt("id", 0)
            val dialog = CusTomDialogFragment()
            dialog.arguments = bundle

            supportFragmentManager.beginTransaction().apply {
                add( dialog,"customDialog")
                addToBackStack(null)
                commit()
            }
        }

        cvItem2.setOnClickListener{
            Log.d("Item","${curItem[1].id}")
            val bundle = Bundle()
            bundle.putSerializable("item", item2)
            bundle.putInt("id", 0)
            val dialog = CusTomDialogFragment()
            dialog.arguments = bundle

            supportFragmentManager.beginTransaction().apply {
                add( dialog,"customDialog")
                addToBackStack(null)
                commit()
            }

        }

        cvItem3.setOnClickListener{
            Log.d("Item","${curItem[2].id}")
            val bundle = Bundle()
            bundle.putSerializable("item", item3)
            bundle.putInt("id", 1)
            val dialog = CusTomDialogFragment()
            dialog.arguments = bundle

            supportFragmentManager.beginTransaction().apply {
                add( dialog,"customDialog")
                addToBackStack(null)
                commit()
            }        }

    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(items: MutableList<ItemData>) {
            val tvItem1 = itemView.findViewById<TextView>(R.id.tvItem1)
            val ivItem1 = itemView.findViewById<ImageView>(R.id.ivItem1)
            val tvItem2 = itemView.findViewById<TextView>(R.id.tvItem2)
            val ivItem2 = itemView.findViewById<ImageView>(R.id.ivItem2)
            val tvItem3 = itemView.findViewById<TextView>(R.id.tvItem3)
            val ivItem3 = itemView.findViewById<ImageView>(R.id.ivItem3)

            var path =
                "https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/items/"

            tvItem1.text = items[0].name
            tvItem2.text = items[1].name
            tvItem3.text = items[2].name

            Picasso.get().load("${path}0${items[0].id}.png").into(ivItem1)
            Picasso.get().load("${path}0${items[1].id}.png").into(ivItem2)
            Picasso.get().load("${path}${items[2].id}.png").into(ivItem3)


        }
    }
}


