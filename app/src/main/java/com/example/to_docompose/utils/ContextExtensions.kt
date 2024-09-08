package com.example.to_docompose.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.ContextWrapper

fun Context.getApplication(): Application? = when (val appContext = this.applicationContext) {
    is Application -> appContext
    is ContextWrapper -> appContext.baseContext.getApplication()
    else -> null
}

fun Context.getActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}