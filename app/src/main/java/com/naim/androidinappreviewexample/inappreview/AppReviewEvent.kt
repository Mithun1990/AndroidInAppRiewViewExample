package com.naim.androidinappreviewexample.inappreview

sealed class AppReviewEvent {
    data class AppReviewError(val it: Exception) : AppReviewEvent()
    object AppReviewSuccessful : AppReviewEvent()
}