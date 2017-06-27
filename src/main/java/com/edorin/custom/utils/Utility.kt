package com.edorin.custom.utils

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.TextView
import java.util.regex.Pattern

/**
 * Forged by Edryn on 4/30/2017.
 */

object Utility {

    fun dpToPx(context: Context, dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
    }

    fun pxToDp(context: Context, px: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, context.resources.displayMetrics)
    }

    fun overrideFonts(context: Context, v: android.view.View, font: String) {
        try {
            if (v is ViewGroup) {
                (0..v.childCount - 1)
                        .map { v.getChildAt(it) }
                        .forEach { overrideFonts(context, it, font) }
            } else if (v is TextView) {
                v.setTypeface(font)
            }
        } catch (e: Exception) {
        }
    }



}