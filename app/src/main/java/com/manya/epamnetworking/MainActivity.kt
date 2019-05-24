package com.manya.epamnetworking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/**
 *
 * Simple [MainActivity] with [Fragment].
 *
 * @author Maria Kirdun
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.conteiner, NetworkingFragment())
                .commit()
        }
    }
}
