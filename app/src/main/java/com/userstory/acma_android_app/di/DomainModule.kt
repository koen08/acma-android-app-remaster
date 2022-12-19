package com.userstory.acma_android_app.di

import com.userstory.domain.usecase.login.LoginUseCase
import com.userstory.domain.usecase.login.LoginUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideLoginUseCase() : LoginUseCase {
        return LoginUseCaseImpl()
    }
}