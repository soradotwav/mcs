package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    private static String url = "https://www.metacritic.com/game/playstation-5/trackmania"; // Example game link
    private static String urlList = "https://www.metacritic.com/browse/games/release-date/coming-soon/pc/date"; // Example list link

    public static void main(String[] args) throws IOException {
        
        // Empty for testing

        // IMPORTANT: add catch for null score
        // IMPORTANT: implement method to only check each page once for all calls

        mcs gameList = new mcs();

        gameList.initialize(urlList);

        
       
        
        
    }

}
