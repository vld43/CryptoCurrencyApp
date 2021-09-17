package com.example.cryptocurrencyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.cryptocurrencyapp.activities.AboutActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd


class MainActivity : AppCompatActivity() {

    private lateinit var interstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        interstitialAd = InterstitialAd(this)
        interstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        interstitialAd.loadAd(AdRequest.Builder().build())

//        val str = Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
//
//        Log.i("qq", "$str")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showAd()
    }

    private fun showAd() {
        if(interstitialAd.isLoaded) {
            interstitialAd.show()
        }
    }
}