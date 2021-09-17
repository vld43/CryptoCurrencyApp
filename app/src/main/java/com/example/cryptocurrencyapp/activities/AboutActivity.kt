package com.example.cryptocurrencyapp.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import com.example.cryptocurrencyapp.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class AboutActivity : AppCompatActivity() {

    private val buttonRateApp by lazy { findViewById<Button>(R.id.button_rate_app) }
    private val adView by lazy { findViewById<AdView>(R.id.ad_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adRequest = AdRequest.Builder().build()

        adView.loadAd(adRequest)

        buttonRateApp.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=${applicationContext.packageName}")
                )
            )
        }
    }


}