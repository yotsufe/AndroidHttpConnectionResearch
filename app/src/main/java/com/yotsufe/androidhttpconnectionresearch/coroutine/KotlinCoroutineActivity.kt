package com.yotsufe.androidhttpconnectionresearch.coroutine

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.yotsufe.androidhttpconnectionresearch.R
import com.yotsufe.androidhttpconnectionresearch.databinding.ActivityKotlinCoroutineBinding
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KotlinCoroutineActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, KotlinCoroutineActivity::class.java)
    }

    private lateinit var binding: ActivityKotlinCoroutineBinding
    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://qiita.com/api/v2/")
        .client(client)
        .build()
        .create(ApiInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_kotlin_coroutine)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnGet.setOnClickListener {
            lifecycleScope.launch {
                binding.result.text = getRequest()?.get(0).toString()
            }
        }

        binding.btnClear.setOnClickListener {
            binding.result.text = ""
        }
    }

    private suspend fun getRequest(): Array<Item>? {
        return try {
            api.getItems()
        } catch (e: Exception) {
            Log.d("###", e.message.toString())
            null
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
