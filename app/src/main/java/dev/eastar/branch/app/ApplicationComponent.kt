package dev.eastar.branch.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import dev.eastar.branch.di.module.*
import javax.inject.Singleton

@Component(modules = [AndroidSupportInjectionModule::class
    , RoomModule::class
    , RetrofitModule::class
    , RepositoryModule::class
    , BranchViewModule::class
    , BranchMapModule::class
])
@Singleton
interface ApplicationComponent : AndroidInjector<DaggerApplication> {
    fun inject(application: AppApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AppApplication): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ApplicationComponent
    }
}