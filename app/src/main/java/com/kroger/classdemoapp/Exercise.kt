package com.kroger.classdemoapp

data class Exercise(
    val name: String,
    val subGroup: String,
    val image: String,
    val desc:String ="Here any description can be passed but I have kept it null for now. It is passes as" +
            "item of bundle to the fragment."
)

