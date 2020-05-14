package com.udacity.gradle.builditbigger.backend;

import java.util.List;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private List<String> jokeList;


    public void setJokeList(List<String> jokeList) {
        this.jokeList = jokeList;
    }

    public List<String> getJokeList() {
        return jokeList;
    }


}