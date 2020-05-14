package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.jokes_android_library.JokeDetailsActivity;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;


public class EndpointsAsyncTask extends AsyncTask<Context, Void, List<String>>  {
    private static MyApi myApiService = null;
    private Context context;
    private static final String TAG = "EndpointsAsyncTask";


    @Override
    protected List<String> doInBackground(Context...params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];


        try {

            // Get the jokes from jokes library
            List<String> result = myApiService.getJokesService().execute().getJokeList();

            return result;
        } catch (IOException error) {
            Log.e(TAG, "IO error: " + error);
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<String> result) {

        // Launch Joke details activity
        Class destinationActivity = JokeDetailsActivity.class;

        Intent intent = new Intent(context, destinationActivity);

        intent.putExtra("JokeList", (Serializable) result);
        context.startActivity(intent);


    }
}
