package com.example.firstapplication


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.example.firstapplication.Model.ChampData
import com.example.firstapplication.Model.ItemData
import com.squareup.picasso.Picasso

class CusTomDialogFragment : DialogFragment(){
    private lateinit var mainActivity: FragmentActivity
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
        var rootView:View = inflater.inflate(R.layout.fragment_custom_dialog, container,false)
//        if (arguments!! != null){
//            val item = arguments!!.getSerializable("ite") as ItemData
//
//            val cN = rootView.findViewById<TextView>(R.id.tvItemInfo)
//
//            cN.text = item.name
//        }
        var path = "https://raw.githubusercontent.com/baobht/First_Kotlin_app/master/app/set5/items/"
        val item = arguments!!.getSerializable("item") as ItemData
        val i = arguments!!.getInt("id") as Int
        val cN = rootView.findViewById<TextView>(R.id.tvItemInfo)
        val iD = rootView.findViewById<TextView>(R.id.tvItemDes)
        val iI = rootView.findViewById<ImageView>(R.id.ivItem)
        val btnC = rootView.findViewById<Button>(R.id.btnClose)
        cN.text = item.name
        iD.text = item.description
        if (i == 1){
            Picasso.get().load("${path}${item.id}.png").into(iI)

        }
        else{
            Picasso.get().load("${path}0${item.id}.png").into(iI)

        }
        btnC.setOnClickListener {
            dismiss()
        }
        return rootView
    }
}