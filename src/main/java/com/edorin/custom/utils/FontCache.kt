package com.edorin.custom.utils

import android.content.Context
import android.graphics.Typeface

/**
 * Created  by Edryn on 4/29/2017.
 */

class FontCache {

    companion object {
        val fontCache = HashMap<String, Typeface>()
        fun getFont(font: String, context: Context): Typeface? {
            var typeface = fontCache[font]
            if (typeface == null) {
                try {
                    typeface = Typeface.createFromAsset(context.assets, "fonts/" + font)
                } catch (e: Exception) {
                    return null
                }

                fontCache.put(font, typeface)
            }
            return typeface
        }
    }

}

