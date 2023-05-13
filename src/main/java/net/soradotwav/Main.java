package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    private static String urlList = "https://www.metacritic.com/browse/games/release-date/new-releases/all/date"; // <-- Example list link

    public static void main(String[] args) throws IOException {
        
        // Empty for testing; below example //

        mcs gameList = new mcs(); // <-- create new list object

        gameList.initialize(urlList); // <-- initialize scraper and save data in cache

        String gameTitle1 = gameList.getTitles(5); // <-- get a title from the list at an index
        ArrayList<String> titleList = gameList.getTitles(); // <-- get a list of all the titles

        // Do whatever you want with it //

        // above works for Titles(), ReleaseDates(), Platforms(), Scores() and Links() //

        
       
        
        
    }

}
