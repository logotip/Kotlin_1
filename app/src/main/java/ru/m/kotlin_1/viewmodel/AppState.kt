package ru.m.kotlin_1.viewmodel

import ru.m.kotlin_1.model.Movie


sealed class AppState {
    data class Success(val movieData: Movie) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}