package com.naim.androidinappreviewexample.inappreview

import android.app.Activity
import com.google.android.play.core.review.ReviewManager

interface IInAppReview {
    fun appReview(appReviewRequest: ReviewManager?, context: Activity?)
}