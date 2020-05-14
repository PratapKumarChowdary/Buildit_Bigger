package com.udacity.jokes_java_library;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joker {

    private static List<String> jokeList = new ArrayList<>();

    public static List<String> getJokeList() {
        if (jokeList.isEmpty())
            setJokes();

        return jokeList;
    }
    

    private static void setJokes() {
        jokeList.add("\"I wasn't that drunk yesterday.\" \"Oh boy you took the shower head in your arms and told it to stop crying.\"");
        jokeList.add("Women really know how to hold a grudge. My wife asked me to pass her a lip balm. And by mistake, I gave her a tube of Super Glue. It’s been a month now and she’s still not speaking to me!");
        jokeList.add("When my wife starts to sing I always go out and do some garden work so our neighbors can see there's no domestic violence going on.");
        jokeList.add("8 p.m. I get an SMS from my girlfriend: Me or football?! \n11 p.m. I SMS my girlfriend: You of course.");
        jokeList.add("I invented a new word! \n Plagiarism!\n");
        jokeList.add("What are shark's two most favorite words? Man overboard!");
        jokeList.add("Who says nothing is impossible? \nI've been doing nothing for years.");
        jokeList.add("Where do fish sleep? In the riverbed.");
        jokeList.add("Where are average things manufactured? The satisfactory.");
        jokeList.add("Talk is cheap? Have you ever talked to a lawyer?\n");
        jokeList.add("Rest in peace boiling water. You will be mist!");
        jokeList.add("Talk is cheap? Have you ever talked to a lawyer?");
        jokeList.add("What do you call a singing laptop? A Dell!");
        jokeList.add("What do you call bears with no ears?\n B.");
        jokeList.add("How do trees get online?\n They just log on!");
        jokeList.add("Why did the orange stop?\n It ran out of juice!");
        jokeList.add("What did 0 say to 8? Nice belt!");
        jokeList.add("What do you call a boomerang that doesn't work?\n A stick.");
        jokeList.add("What goes up and down but does not move?\n Stairs");
        jokeList.add("What did one toilet say to the other?\n You look a bit flushed.");
        jokeList.add("Why did the picture go to jail?\n Because it was framed.");
        jokeList.add("What did one wall say to the other wall?\n I'll meet you at the corner.");
        jokeList.add("What do you call a boy named Lee that no one talks to?\n Lonely");
        jokeList.add("Why was the broom late?\n It over swept!");
        jokeList.add("What makes the calendar seem so popular?\n  Because it has a lot of dates!");
        jokeList.add("What is it that even the most careful person overlooks?\n Her nose!");


/*        jokeList.add("");
        jokeList.add("");
        jokeList.add("");
        jokeList.add("");*/


    }
}
