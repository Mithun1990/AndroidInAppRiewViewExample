package com.naim.androidinappreviewexample.inappreview

import android.app.Activity
import java.lang.ref.WeakReference

abstract class BaseAppReview(
    private val context: WeakReference<Activity>,
    private val iAppReview: IInAppReview
) {
    abstract fun appReview()
}