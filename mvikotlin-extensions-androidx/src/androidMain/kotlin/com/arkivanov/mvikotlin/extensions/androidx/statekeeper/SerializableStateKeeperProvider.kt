package com.arkivanov.mvikotlin.extensions.androidx.statekeeper

import androidx.savedstate.SavedStateRegistryOwner
import com.arkivanov.mvikotlin.core.statekeeper.ExperimentalStateKeeperApi
import com.arkivanov.mvikotlin.core.statekeeper.StateKeeper
import com.arkivanov.mvikotlin.core.statekeeper.StateKeeperProvider
import java.io.Serializable
import kotlin.reflect.KClass

@Deprecated("Use getSerializableStateKeeperRegistry()", ReplaceWith("getSerializableStateKeeperRegistry()"))
@ExperimentalStateKeeperApi
fun SavedStateRegistryOwner.getSerializableStateKeeperProvider(): StateKeeperProvider<Serializable> =
    object : StateKeeperProvider<Serializable> {
        override fun <S : Serializable> get(clazz: KClass<out S>, key: String): StateKeeper<S> =
            SerializableStateKeeper(registry = savedStateRegistry, clazz = clazz, key = key)
    }
