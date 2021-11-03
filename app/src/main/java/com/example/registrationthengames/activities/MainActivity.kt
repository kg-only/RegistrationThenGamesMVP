package com.example.registrationthengames.activities

import android.os.Bundle
import com.example.registrationthengames.R
import com.example.registrationthengames.base.BaseActivity
import com.example.registrationthengames.fragment.GamesFragment
import com.example.registrationthengames.fragment.LoginFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(GamesFragment())
    }
}