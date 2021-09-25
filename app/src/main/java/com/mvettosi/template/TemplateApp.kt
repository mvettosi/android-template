package com.mvettosi.template

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class TemplateApp : Application() {
  override fun onCreate() {
    super.onCreate()
    if (BuildConfig.DEBUG) {
      Timber.plant(
          object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String {
              return "{${BuildConfig.APPLICATION_ID}} ${super.createStackElementTag(element)}"
            }
          })
    }
  }
}
