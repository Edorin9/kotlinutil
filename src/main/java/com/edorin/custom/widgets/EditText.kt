package com.edorin.custom.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import com.edorin.custom.R

/**
 * Forged by Edryn on 4/29/2017.
 */

class EditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = R.attr.editTextStyle)
    : EditText(context, attrs, defStyle) {

    init {
        TextView.init(context, this, attrs, defStyle)
    }

}

