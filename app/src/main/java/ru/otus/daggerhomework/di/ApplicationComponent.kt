package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier


@Component(modules = [AppSubcomponents::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @AppContext
            @BindsInstance
            appContext: Context
        ): ApplicationComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory

}

@Qualifier
annotation class AppContext