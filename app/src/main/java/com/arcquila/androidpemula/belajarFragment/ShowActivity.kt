package com.arcquila.androidpemula.belajarFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arcquila.androidpemula.R

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

       val mFragmentManager = supportFragmentManager
        val HelloFragment = HelloFragment()
        val fragment = mFragmentManager.findFragmentByTag(HelloFragment::class.java.simpleName)

        if (fragment !is HelloFragment){
            Log.d("MyFlexibleFragment", "Fragment Name :" + HelloFragment::class.java.simpleName)
            mFragmentManager.beginTransaction().add(R.id.fragment_container,HelloFragment,HelloFragment::class.java.simpleName).commit()

        }

    }
}