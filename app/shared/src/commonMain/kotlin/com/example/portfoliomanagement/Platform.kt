package com.example.portfoliomanagement

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform