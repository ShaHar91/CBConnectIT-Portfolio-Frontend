package com.christiano.bolla.utils

object Config {

    var baseUrl: String = ""
        private set

    fun init(baseUrl: String?) {
        this.baseUrl = baseUrl ?: ""
    }
}