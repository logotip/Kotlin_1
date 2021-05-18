package ru.m.kotlin_1.model

data class Movie(
        val film: Film = getDefaultMovie(),
        val rankKP: String = "КиноПоиск: 6.5", //рейтинг Кинопоиск
        val rankIMBd: String = "IMDb: 6.5" //рейтинг IMDb
)

fun getDefaultMovie() = Film("Рога", "Фильм", "фэнтези, триллер, драма, ужасы", 2013)