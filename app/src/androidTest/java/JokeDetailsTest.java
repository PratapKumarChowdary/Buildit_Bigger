import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;


/**
 * Test Jokes Details Activity & verify it receives intent extra
 * and can request random joke (via random joke button)
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class JokeDetailsTest {

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
            MainActivity.class);


    @Before
    public void stubAllExternalIntents() {
        // By default Espresso Intents does not stub any Intents. Stubbing needs to be setup before
        // every test run. In this case all external Intents will be blocked.
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }



    @Test
    public void JokesTestUI(){
        //Wait to Load screen
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click launch joke button
        onView(ViewMatchers.withId(R.id.button_launchJoke)).perform(ViewActions.click());

        // Check if Jokes Activity has intent extra
        intended(hasExtraWithKey("JokeList"));

        // Click random joke button to generate random joke & check the textview is not empty
        for (int i = 0; i < 10; i++){
            onView(ViewMatchers.withId(R.id.text_joke)).check(matches(not(withText(""))));
            onView(ViewMatchers.withId(R.id.button_randomJoke)).perform(ViewActions.click());
        }


    }


}
