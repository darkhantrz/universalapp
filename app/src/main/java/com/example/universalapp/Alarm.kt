package com.example.universalapp

class Alarm : java.io.Serializable {

    private var id = 0
    private var hour = 0
    private var minute = 0
    private var status = false
    private var name = ""
    constructor()
    constructor(hour:Int, minute:Int, status:Boolean, name:String) {
        this.hour = hour
        this.minute = minute
        this.status = status
        this.name = name
    }

//    fun getId(): Int {
//        return id;
//    }

    fun setId(id:Int) {
        this.id = id
    }
}