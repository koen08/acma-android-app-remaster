package com.userstory.presentation.utils

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.updateLayoutParams
import com.google.android.material.internal.CheckableImageButton
import com.google.android.material.textfield.TextInputLayout

//Bug fix https://github.com/material-components/material-components-android/issues/366
fun TextInputLayout.defaultPadding() {
    val button =
        this.findViewById<CheckableImageButton>(com.google.android.material.R.id.text_input_error_icon)
    val parent = button.parent as LinearLayout

    button.updateLayoutParams<ViewGroup.MarginLayoutParams> {
        width = 110
        setMargins(0, 20, 0, 0)
    }

    parent.updateLayoutParams {
        width = 100
    }
}