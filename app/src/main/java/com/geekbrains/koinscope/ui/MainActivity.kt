package com.geekbrains.koinscope.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.geekbrains.koinscope.R
import com.geekbrains.koinscope.data.SomeDepend
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.getOrCreateScope
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity : AppCompatActivity(), KoinScopeComponent {

//    val scope by lazy { getKoin().getOrCreateScope("", named("mainScope")) }

    override val scope: Scope by getOrCreateScope()
    private val someDepend: SomeDepend by inject()

    private lateinit var textViewScope : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        koinStart()
        textViewScope = findViewById(R.id.koin_text_hello)
    }

    private fun koinStart() {
//        scope.get<SomeDepend>().koinScope()
        someDepend.koinScope()
    }

    override fun onDestroy() {
        scope.close()
        super.onDestroy()
    }
}