package ru.m.kotlin_1.model

class RepositoryImpl : Repository {
    override fun geMovieFromServer() = Movie()
    override fun getMovieFromLocalStorage() = Movie()
}