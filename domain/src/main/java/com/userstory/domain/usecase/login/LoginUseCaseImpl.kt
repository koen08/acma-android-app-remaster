package com.userstory.domain.usecase.login

class LoginUseCaseImpl: LoginUseCase {
    override fun invoke(userId: Int): String {
        return "Login by $userId"
    }
}