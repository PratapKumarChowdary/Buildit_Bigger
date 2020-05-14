package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.List;

import javax.inject.Named;
import com.udacity.jokes_java_library.Joker;


/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * Jokes endpoint that set and retrieve joke list
     * @return the Jokes
     */
    @ApiMethod(name = "getJokesService")
    public MyBean getJokesService(){
        MyBean response = new MyBean();

        Joker joker = new Joker();
        List<String> jokeList = joker.getJokeList();

        response.setJokeList(jokeList);


        return response;
    }

}
