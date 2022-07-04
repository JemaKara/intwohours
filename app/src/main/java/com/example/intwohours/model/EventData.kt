package com.example.intwohours.model

class EventData{
    var evenTitle: String? = null
    var info: String? = null
    var image: String? = null

    constructor(){}

    constructor(
        evenTitle:String?,
        info:String?,
        image:String?
    ){
        this.evenTitle = evenTitle
        this.info = info
        this.image = image
    }

}


