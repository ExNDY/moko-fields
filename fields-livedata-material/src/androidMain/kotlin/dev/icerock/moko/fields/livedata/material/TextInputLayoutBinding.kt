/*
 * Copyright 2022 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.fields.livedata.material

import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.textfield.TextInputLayout
import dev.icerock.moko.fields.livedata.FormField
import dev.icerock.moko.mvvm.livedata.bindTextTwoWay
import dev.icerock.moko.mvvm.livedata.material.bindError
import dev.icerock.moko.resources.desc.StringDesc

fun TextInputLayout.bindFormField(
    lifecycleOwner: LifecycleOwner,
    formField: FormField<String, StringDesc>,
) {
    val editTextView: EditText = editText ?: return

    with(editTextView) {
        bindTextTwoWay(lifecycleOwner, formField.data)
        setOnFocusChangeListener { _, focused ->
            if (focused) return@setOnFocusChangeListener
            formField.validate()
        }
        bindError(lifecycleOwner, formField.error)
    }
}
