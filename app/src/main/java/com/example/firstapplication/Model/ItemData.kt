package com.example.firstapplication.Model

import java.io.Serializable

class ItemData(var id:String, var name:String, var description:String, var isUnique: Boolean,var isShadow:Boolean):
    Serializable {
    constructor() : this( "", "", "", false,false)


}