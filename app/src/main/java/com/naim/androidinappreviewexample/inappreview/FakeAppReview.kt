package com.naim.androidinappreviewexample.inappreview

import android.app.Activity
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.testing.FakeReviewManager
import com.naim.androidinappreviewexample.inappreview.BaseAppReview
import com.naim.androidinappreviewexample.inappreview.IInAppReview
import java.lang.ref.WeakReference

class FakeAppReview(
    private val context: WeakReference<Activity>,
    private val iInAppReview: IInAppReview,
) : BaseAppReview(context, iInAppReview) {
    private var appReviewManagerFactory: ReviewManager? = null

    init {
        context.get()?.let {
            appReviewManagerFactory = FakeReviewManager(it)
        }

    }

    override fun appReview() {
        appReviewManagerFactory?.let {
            iInAppReview.appReview(it, context.get())
        }
    }
}