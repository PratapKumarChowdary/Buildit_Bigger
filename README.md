# Build It Bigger / Jokes displaying app

## Project Overview
App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.

## Implementation details:
1. App consist of four modules. A Java library that provides jokes, a Google Cloud Endpoints (GCE) project that serves those jokes, an Android Library containing an activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

2. Project contains paid/free flavors. The paid flavor has no ads and no unnecessary dependencies.

3. Includes connected tests to verify that the AsyncTask is indeed loading jokes. Test Jokes Details Activity & verify it receives intent extra and can request random joke.


## Requirements
Stable release versions of all libraries, Gradle, and Android Studio.


