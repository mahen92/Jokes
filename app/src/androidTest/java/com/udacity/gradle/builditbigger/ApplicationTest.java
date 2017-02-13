package com.udacity.gradle.builditbigger;

/**
 * Created by Mahendran on 12-02-2017.
 */

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.ExecutionException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
    public void testFetchJokeTask() throws ExecutionException, InterruptedException {
        GEAsync testJoke = new GEAsync(new GEAsync.Callback() {
            @Override
            public void onFinished(String result) {

            }
        });
        testJoke.execute();
        String joke = testJoke.get();
        assertNotNull(joke);
    }
}
