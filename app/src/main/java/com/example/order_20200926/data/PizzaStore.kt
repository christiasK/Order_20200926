package com.example.order_20200926.data

import java.io.Serializable

class PizzaStore(
    val title: String,
    val callNumber: String,
    val logoSource: String,
    val homepage: String
) : Serializable {
}