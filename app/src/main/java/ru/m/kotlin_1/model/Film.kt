package ru.m.kotlin_1.model

data class Film(
        val film: String, // название фильма
        val type: String, // фильм или сериал
        val genre: String, // жанр
        val year: Int //год выпуска

)
