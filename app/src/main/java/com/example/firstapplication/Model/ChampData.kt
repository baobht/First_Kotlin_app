package com.example.firstapplication.Model

import java.io.Serializable

class ChampData(var name:String, var championId:String, var cost:Int, var traits: List<String>): Serializable {
    constructor() : this( "", "", 0, listOf(""))
}