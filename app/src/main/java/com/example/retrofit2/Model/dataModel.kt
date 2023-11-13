package com.example.retrofit2.Model

import com.google.gson.annotations.SerializedName

data class dataModel(
    @SerializedName("result")
    val result : List<dataList>
)

data class dataList(

    @SerializedName("id")
    val id : Int,

    @SerializedName("title")
    val title : String,

    @SerializedName("image")
    val image : String

)