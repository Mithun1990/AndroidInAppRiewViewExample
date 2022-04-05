package com.naim.androidinappreviewexample.inappreview

import android.app.Activity
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import com.naim.androidinappreviewexample.inappreview.BaseAppReview
import com.naim.androidinappreviewexample.inappreview.IInAppReview
import java.lang.ref.WeakReference

class RealAppReview(
    private val context: WeakReference<Activity>,
    private val iAppReview: IInAppReview
) : BaseAppReview(context, iAppReview) {
    private var appReviewManagerFactory: ReviewManager? = null

    init {
        context.get()?.let {
            appReviewManagerFactory = ReviewManagerFactory.create(it)
        }
    }

    override fun appReview() {
        appReviewManagerFactory?.let {
            iAppReview.appReview(it, context.get())
        }
    }
}