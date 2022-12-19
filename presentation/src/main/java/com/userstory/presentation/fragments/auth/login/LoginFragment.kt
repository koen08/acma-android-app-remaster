package com.userstory.presentation.fragments.auth.login

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.userstory.presentation.R
import com.userstory.presentation.base.fragment.BaseFragment
import com.userstory.presentation.databinding.FragmentLoginBinding
import com.userstory.presentation.model.UiEvent
import com.userstory.presentation.model.uiState.auth.login.LoginUiState
import com.userstory.presentation.utils.applyStatusBarInsetsOnly
import com.userstory.presentation.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginUiState, UiEvent, LoginViewModel, FragmentLoginBinding>(
    R.layout.fragment_login
) {

    private val viewModel: LoginViewModel by viewModels()
    override val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       applyStatusBarInsetsOnly(binding.root, binding.containerMain)
        // findTopNavController().navigate(R.id.action_loginFragment_to_tabsFragment)
        Log.e("TAG1", viewModel.getLogin())

        binding.etEmail.setOnClickListener {
            binding.containerMain.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
        }
    }
}