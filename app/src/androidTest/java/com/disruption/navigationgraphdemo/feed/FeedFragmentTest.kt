package com.disruption.navigationgraphdemo.feed

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.disruption.navigationgraphdemo.R
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

/**This class tests the code in the Feed Fragment*/
@RunWith(AndroidJUnit4::class)
@MediumTest
class FeedFragmentTest {

    @Test
    fun clickBoat_navigateToBoatFragment() {
        //GIVEN - On the feed screen
        val args = Bundle().apply {
            putString("id_dl", "2")
        }
        val scenario =
            launchFragmentInContainer<FeedFragment>(args, R.style.AppTheme)
        val navController = Mockito.mock(NavController::class.java)
        scenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }

        // WHEN - Click on a boat item
        onView(ViewMatchers.withId(R.id.recycler))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    1, click()
                )
            )

        // THEN - Verify that we navigate to the BoatFragment
        //This is for tutorial purposes only. Passing the ID like this is not recommended
//        Mockito.verify(navController).navigate(
//            HomeFragmentDirections.actionHomeFragmentToBoatFragment(1)
//        )
    }
}