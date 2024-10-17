package com.usatayamish.expertcourseunscramblegame.views.shuffledword

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class ShuffledWordTextView : AppCompatTextView, UpdateText {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun getFreezesText(): Boolean = true

    override fun update(text: String) {
        this.text = text
    }


}

interface UpdateText {

    fun update(text: String)
}

