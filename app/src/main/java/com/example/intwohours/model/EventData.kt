package com.example.intwohours.model

class EventData{
    var title: String? = null
    var info: String? = null
    var image: String? = null

    constructor(){}

    constructor(
        name:String?,
        info:String?,
        img:String?
    ){
        this.title = name
        this.info = info
        this.image = img
    }

}


