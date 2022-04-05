package com.naim.androidinappreviewexample.inappreview

import android.app.Activity
import com.google.android.play.core.review.ReviewManager

class InAppReviewManager(private val onAction: (AppReviewEvent) -> Unit = {}) : IInAppReview {
    override fun appReview(appReviewRequest: ReviewManager?, context: Activity?) {
        val request = appReviewRequest?.requestReviewFlow()
        request?.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                val reviewInfo = request.result
                context?.let {
                    val flow = appReviewRequest.launchReviewFlow(it, reviewInfo)
                    flow.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            onAction.invoke(AppReviewEvent.AppReviewSuccessful)
                        } else {
                            task.exception?.let { it ->
                                onAction.invoke(AppReviewEvent.AppReviewError(it))
                            }
                        }
                    }
                }
            } else {
                request.exception?.let { it ->
                    onAction.invoke(AppReviewEvent.AppReviewError(it))
                }
            }
        }
    }
}