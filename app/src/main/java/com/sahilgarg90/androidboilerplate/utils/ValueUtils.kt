package com.sahilgarg90.androidboilerplate.utils

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import kotlin.random.Random

/**
 * Created by Sahil Garg on 07-03-2021.
 */

class ValueUtils {

    companion object {
        fun getRandomNumberString(): String {
            return "-${Random.nextInt(Int.MAX_VALUE)}"
        }
    }
}

fun String?.addRequiredField(): SpannableString {
    val requiredTitle = SpannableString("$this *")
    requiredTitle.setSpan(
        ForegroundColorSpan(Color.RED),
        requiredTitle.length - 1, requiredTitle.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return requiredTitle
}

fun String?.containsUrl(): Boolean {
    this?.let {
        return Patterns.WEB_URL.matcher(this).matches()
    }
    return false
}