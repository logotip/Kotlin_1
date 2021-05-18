package ru.m.kotlin_1.model

interface Repository {
    fun geMovieFromServer(): Movie
    fun getMovieFromLocalStorage(): Movie
}