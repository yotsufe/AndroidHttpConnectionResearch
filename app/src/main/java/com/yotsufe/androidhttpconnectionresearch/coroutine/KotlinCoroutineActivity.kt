package com.yotsufe.androidhttpconnectionresearch.coroutine

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.yotsufe.androidhttpconnectionresearch.R
import com.yotsufe.androidhttpconnectionresearch.databinding.ActivityKotlinCoroutineBinding

class KotlinCoroutineActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, KotlinCoroutineActivity::class.java)
    }

    private lateinit var binding: ActivityKotlinCoroutineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_kotlin_coroutine)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnGet.setOnClickListener {
        }

        binding.btnClear.setOnClickListener {
            binding.result.text = ""
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
