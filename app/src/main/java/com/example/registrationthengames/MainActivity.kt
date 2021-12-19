package com.example.registrationthengames

import android.os.Bundle
import com.example.registrationthengames.common.mvp.BaseActivity
import com.example.registrationthengames.main.ui.gamelist.GamesFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(GamesFragment())
    }
}