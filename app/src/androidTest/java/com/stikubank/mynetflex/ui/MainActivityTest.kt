package com.stikubank.mynetflex.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.stikubank.mynetflex.R
import com.stikubank.mynetflex.utils.DataDummy
import com.stikubank.mynetflex.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Rule

class MainActivityTest {

    private val dataMovies = DataDummy.generateMovies()
    private val dataTvshow = DataDummy.generateTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataMovies.size))
    }

    @Test
    fun loadDetailMovies(){
        onView(withId(R.id.rv_movies)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.tv_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_judul)).check(matches(withText(dataMovies[0].title)))
        onView(withId(R.id.tv_synopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis)).check(matches(withText(dataMovies[0].synopsis)))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadShows(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataTvshow.size))
    }

    @Test
    fun loadDetailTvshows(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_judul)).check(matches(withText(dataTvshow[0].title)))
        onView(withId(R.id.tv_synopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis)).check(matches(withText(dataTvshow[0].synopsis)))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
    }
}