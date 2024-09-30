package com.example.to_docompose.di

import com.example.to_docompose.navigation.AppNavHost
import com.example.to_docompose.navigation.AppNavHostImpl
import com.example.to_docompose.navigation.ScreensNavigatorImpl
import com.example.to_docompose.navigation.destinations.ScreensNavigator
import com.smarthome.core.presentation.navigation.manager.NavigationManager
import com.smarthome.core.presentation.navigation.manager.NavigationManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Singleton
    @Binds
    fun bindNavigationManager(navigationManagerImpl: NavigationManagerImpl): NavigationManager

    @Singleton
    @Binds
    fun bindAppNavHost(appNavHostImpl: AppNavHostImpl): AppNavHost

    @Binds
    fun bindScreensNavigation(screensNavigatorImpl: ScreensNavigatorImpl): ScreensNavigator

}