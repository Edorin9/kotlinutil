package com.edorin.custom.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.TextView
import android.view.inputmethod.InputMethodManager
import android.net.ConnectivityManager
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.edorin.custom.R
import com.edorin.custom.widgets.EditText
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration
import java.util.regex.Pattern
import android.telephony.TelephonyManager




/**
 * Forged by Edryn on 4/29/2017.
 */

fun String.isValidEmail(): Boolean {
    return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(this).find()
}

fun EditText.text(): String {
    return text.toString()
}

fun TextView.setTypeface(font: String) {
    this.typeface = FontCache.getFont(font, this.context)
}

fun Context.getStringResource(stringResource: Int): String {
    return getString(stringResource)
}

fun Context.getColorResource(colorResource: Int): Int {
    return ContextCompat.getColor(this, colorResource)
}

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

fun Context.getDeviceId(): String {
    val deviceId = (getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager).deviceId
    if (deviceId != null) {
        return deviceId
    } else {
        return android.os.Build.SERIAL
    }
}

fun RecyclerView.clear(list: ArrayList<*>) {
    list.clear()
    adapter.notifyItemRangeRemoved(0, adapter.itemCount)
}

fun Activity.hidesSoftInputOnTouch(rootLayout: ViewGroup) {
    rootLayout.isClickable = true
    rootLayout.isFocusable = true
    rootLayout.isFocusableInTouchMode = true
    rootLayout.setOnFocusChangeListener { v, hasFocus ->
        if (hasFocus) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.rootView.windowToken, 0)
        }
    }
}

fun ViewGroup.softInputStateChanged(context: Context, shown: () -> Unit, hidden: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener {
        val heightDiff = rootView.height - height
        if (heightDiff > Utility.dpToPx(context, 200f)) {
            shown()
            Log.e("TAG", "shown")
        } else {
            hidden()
            Log.e("TAG", "hidden")
        }
    }
}

fun View.scaleAnimate(fromScale: Float? = null, toScale: Float? = null, fromX: Float = fromScale!!, toX: Float = toScale!!,
                      fromY: Float = fromX, toY: Float = toX, pivotX: Float = 0.5f, pivotY: Float = 0.5f,
                      delay: Long = 0, duration: Long = 500, interpolator: Interpolator? = null) {
    val anim = ScaleAnimation(fromX, toX, fromY, toY,
            Animation.RELATIVE_TO_SELF, pivotX, Animation.RELATIVE_TO_SELF, pivotY)
    anim.fillAfter = true
    if (interpolator != null) anim.interpolator = interpolator
    anim.startOffset = delay
    anim.duration = duration
    startAnimation(anim)
}

fun View.translateAnimate(fromXDelta: Float, toXDelta: Float, fromYDelta: Float, toYDelta: Float,
                          delay: Long = 0, duration: Long = 500, interpolator: Interpolator? = null) {
    val anim = TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta)
    anim.fillAfter = true
    if (interpolator != null) anim.interpolator = interpolator
    anim.startOffset = delay
    anim.duration = duration
    startAnimation(anim)
}

fun View.alphaAnimate(fromAlpha: Float, toAlpha: Float, delay: Long = 0, duration: Long = 500, interpolator: Interpolator? = null) {
    val anim = AlphaAnimation(fromAlpha, toAlpha)
    anim.fillAfter = true
    if (interpolator != null) anim.interpolator = interpolator
    anim.startOffset = delay
    anim.duration = duration
    startAnimation(anim)
}

fun View.rotateAnimate(fromDegrees: Float, toDegrees: Float, pivotX: Float = 0.5f, pivotY: Float = 0.5f,
                       delay: Long = 0, duration: Long = 500, interpolator: Interpolator? = null) {
    val anim = RotateAnimation(fromDegrees, toDegrees, pivotX, pivotY)
    anim.fillAfter = true
    if (interpolator != null) anim.interpolator = interpolator
    anim.startOffset = delay
    anim.duration = duration
    startAnimation(anim)
}