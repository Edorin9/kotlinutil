package com.edorin.custom.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.edorin.custom.R

import com.edorin.custom.utils.setTypeface

/**
 * Forged by Edryn on 4/29/2017.
 */

class TextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : TextView(context, attrs, defStyle) {

    init {
        init(context, this, attrs, defStyle)
    }

    companion object {
        fun init(context: Context, view: TextView, attrs: AttributeSet?, defStyle: Int) {
            if (attrs != null) {
                val a = context.obtainStyledAttributes(attrs, R.styleable.TextView, defStyle, 0)
                val font = a.getString(R.styleable.TextView_font)
                a.recycle()
                if (font != null) {
                    view.setTypeface(font)
                }
            }
        }
    }

}

