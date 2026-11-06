package com.example.catalogue.support

fun slugify(title: String): String {
    return title.lowercase().replace(" ", "-").trim('-')
}