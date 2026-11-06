package com.example.catalogue.exception

class ReviewLimitExceededException(val limit: Int) :
    RuntimeException("Limit exceeded: $limit")