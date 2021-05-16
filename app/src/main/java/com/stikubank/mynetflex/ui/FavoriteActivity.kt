package com.stikubank.mynetflex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stikubank.mynetflex.R
import com.stikubank.mynetflex.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val favSectionsPagerAdapter = FavSectionsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = favSectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        supportActionBar?.title = getString(R.string.titlefav)
        supportActionBar?.elevation = 0f
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}