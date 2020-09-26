package com.arkivanov.mvikotlin.keepers.instancekeeper

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

@ExperimentalInstanceKeeperApi
fun <T : ViewModelStoreOwner> T.getInstanceKeeper(): InstanceKeeper =
    ViewModelProvider(this)
        .get(InstanceKeeperViewModel::class.java)
        .instanceKeeper

class CalculatorController(instanceKeeper: InstanceKeeper) {

    private val something: Something =
        instanceKeeper.getOrCreate(::Something)

    /*
     * Instances of this class will be retained.
     * ⚠️ Pay attention to not leak any dependencies.
     */
    private class Something : InstanceKeeper.Instance {
        override fun onDestroy() {
            // Clean-up any resources here
        }
    }
}
