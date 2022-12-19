package com.userstory.presentation.utils

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.userstory.presentation.R
import com.userstory.presentation.base.fragment.BaseFragment
import com.userstory.presentation.base.view_model.BaseViewModel
import com.userstory.presentation.model.UiEvent
import com.userstory.presentation.model.UiState
import kotlin.math.abs
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <VB : ViewBinding, STATE : UiState, EVENT : UiEvent, VM : BaseViewModel<STATE, EVENT>> BaseFragment<STATE, EVENT, VM, VB>.viewBinding(
    viewBindingFactory: (View) -> VB
): ReadOnlyProperty<Fragment, VB> = object : ReadOnlyProperty<Fragment, VB> {
    private var binding: VB? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): VB {
        observerOnDestroy()
        return viewBindingFactory(thisRef.requireView()).also { viewBinding ->
            this.binding = viewBinding
        }
    }

    private fun observerOnDestroy() {
        viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                binding = null
            }
        })
    }

}


fun Fragment.applyStatusBarInsetsOnly(
    view: View,
    viewGroup: ViewGroup,
    isStatusBarLight: Boolean = true,
) {
    WindowInsetsControllerCompat(
        requireActivity().window,
        requireActivity().window.decorView
    ).isAppearanceLightStatusBars = isStatusBarLight

    val iniViewTopPadding = view.paddingTop
    val types = WindowInsetsCompat.Type.systemBars()
    ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->
        val typeInsets = insets.getInsets(types)
        view.updatePadding(top = iniViewTopPadding + typeInsets.top)
        WindowInsetsCompat.CONSUMED
    }
}

fun View?.removeSelf() {
    this ?: return
    val parentView = parent as? ViewGroup ?: return
    parentView.removeView(this)
}