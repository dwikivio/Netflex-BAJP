package com.stikubank.mynetflex.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.stikubank.mynetflex.R

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object{
        @StringRes
        private val TAB_HALAMAN = intArrayOf(R.string.movies, R.string.shows)
    }

    override fun getItem(position: Int): Fragment =
            when(position){
                0 -> MoviesFragment()
                1 -> ShowsFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_HALAMAN[position])

    override fun getCount(): Int = 2
}