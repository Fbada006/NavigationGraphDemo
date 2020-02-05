package com.disruption.navigationgraphdemo

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import org.hamcrest.Matchers.not
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

/**This class tests the navigation in the Welcome Fragment*/
@RunWith(AndroidJUnit4::class)
@MediumTest
class WelcomeFragmentTest {

    /**Test that the proper navigation method to home was called*/
    @Test
    fun filledLoginForm_opensHomeFragment() {
        //GIVEN - On the home screen
        val scenario =
            launchFragmentInContainer<WelcomeFragment>(Bundle(), R.style.AppTheme)
        val navController = Mockito.mock(NavController::class.java)
        scenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }

        onView(withId(R.id.editTextEmail)).perform(replaceText("myEmail@email.com"))
        onView(withId(R.id.editTextPassword)).perform(replaceText("myPassword"))

        // WHEN - Click on the login button
        onView(withId(R.id.button_login)).perform(click())

        // THEN - Verify that we navigate to the HomeFragment
        onView(withId(R.id.editTextEmail)).check(matches(not(withText(""))))
        onView(withId(R.id.editTextPassword)).check(matches(not(withText(""))))
        Mockito.verify(navController).navigate(
            WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment()
        )
    }

    /**Test that the proper navigation method to reg was called*/
    @Test
    fun registrationButton_opensRegistrationFragment() {
        //GIVEN - On the home screen
        val scenario =
            launchFragmentInContainer<WelcomeFragment>(Bundle(), R.style.AppTheme)
        val navController = Mockito.mock(NavController::class.java)
        scenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }

        // WHEN - Click on the login button
        onView(withId(R.id.button_registration)).perform(click())

        // THEN - Verify that we navigate to the RegistrationFragment
        Mockito.verify(navController).navigate(
            WelcomeFragmentDirections.actionWelcomeFragmentToRegistrationFragment()
        )
    }
}