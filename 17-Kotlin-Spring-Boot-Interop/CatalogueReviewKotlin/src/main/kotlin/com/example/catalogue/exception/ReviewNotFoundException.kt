package com.example.catalogue.exception

class ReviewNotFoundException(id: Long) : RuntimeException("Review with id $id not found")