package com.yotsufe.androidhttpconnectionresearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.yotsufe.androidhttpconnectionresearch.coroutine.KotlinCoroutineActivity
import com.yotsufe.androidhttpconnectionresearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        binding.kotlinCoroutine.setOnClickListener {
            startActivity(KotlinCoroutineActivity.createIntent(this))
        }
    }
}
