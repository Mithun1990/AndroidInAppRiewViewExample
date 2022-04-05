package com.naim.androidinappreviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naim.androidinappreviewexample.inappreview.AppReviewEvent
import com.naim.androidinappreviewexample.inappreview.FakeAppReview
import com.naim.androidinappreviewexample.inappreview.InAppReviewManager
import com.naim.androidinappreviewexample.inappreview.RealAppReview
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val iInAppReview = InAppReviewManager {
            when (it) {
                is AppReviewEvent.AppReviewSuccessful -> {
                    println("App reviewed")
                }
                is AppReviewEvent.AppReviewError -> {
                    println("${it.it.printStackTrace()}")
                }
            }
        }
        val appReview = RealAppReview(WeakReference(this), iInAppReview)
        appReview.appReview()
    }
}