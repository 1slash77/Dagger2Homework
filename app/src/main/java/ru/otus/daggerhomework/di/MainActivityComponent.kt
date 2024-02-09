package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Qualifier

@Subcomponent
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @ActivityContext
            @BindsInstance
            context: Context): MainActivityComponent
    }
}

@Qualifier
annotation class ActivityContext