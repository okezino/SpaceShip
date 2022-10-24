package com.mindera.rocketscience.presentation.view.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.mindera.rocketscience.R
import com.mindera.rocketscience.common.Constants
import com.mindera.rocketscience.databinding.ActivityMainBinding
import com.mindera.rocketscience.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url  = intent.getStringExtra(Constants.WEB_URL_CONST)
        url?.let {
            launchWebView(url)
        }

    }

    private fun launchWebView(url : String){
        binding.webViewLauncher.webViewClient = WebViewClient()
        binding.webViewLauncher.loadUrl(url)


    }

    override fun onBackPressed() {
        if(binding.webViewLauncher.canGoBack()){
            binding.webViewLauncher.goBack()
        }else {
            super.onBackPressed()
        }

    }




}