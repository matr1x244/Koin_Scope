package com.geekbrains.koinscope.di.koin

import com.geekbrains.koinscope.data.SomeDepend
import org.koin.core.qualifier.named
import org.koin.dsl.module

object ModuleKoin {

    val mainScope = module {
        scope(named("mainScope")) {
            scoped {
                SomeDepend()
            }
        }
    }
}