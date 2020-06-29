package com.example.webserviceprueba1

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Posts (
    var userId: Int,
    var id: Int?,
    var title: String,
    var body: String
)