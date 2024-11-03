package io.github.akueisara

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform