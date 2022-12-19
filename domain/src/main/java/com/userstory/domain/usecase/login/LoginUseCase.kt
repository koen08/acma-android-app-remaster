package com.userstory.domain.usecase.login

import com.userstory.domain.base.UseCase

interface LoginUseCase: UseCase {
    fun invoke(userId: Int): String
}