import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 *  Test EndpointsAsyncTask result by overriding onPostExecute. If the first string is not empty, pass the test
 */
public class EndpointsAsyncTaskTest {
    Context context;

    @Test
    public void testAsyncResponse() throws InterruptedException {
        //Initialize latch countdown to 1
        final CountDownLatch latch = new CountDownLatch(1);

        context = InstrumentationRegistry.getContext();

        EndpointsAsyncTask testAsyncTask = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(List<String> result) {
                assertNotNull(result);
                if (result != null) {
                    // Check if the first result string is not empty
                    assertTrue(result.get(0).length() > 0); //String joke = result.get(0);

                    //set count to 0
                    latch.countDown();
                }
            }
        };

        testAsyncTask.execute(context);

        // Waits till the countdown runs from 1 to 0
        latch.await();

    }
}


