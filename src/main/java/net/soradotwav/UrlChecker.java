package net.soradotwav;

import java.io.IOException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UrlChecker {

    /**
    * This method checks if a given URL is valid for Metacritic games website.
    * @param url the URL to be checked.
    * @throws IllegalArgumentException if the given URL is not valid for Metacritic games website.
    */
    public static void checkMain(String url) {
        if(!url.startsWith("https://www.metacritic.com/game/" ) && !url.startsWith("https://www.metacritic.com/browse/games/")) {
            try {
                throw new IllegalArgumentException("Invalid URL. Must start with 'https://www.metacritic.com/game/' or 'https://www.metacritic.com/browse/games/'");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    /**
    * Checks if a given URL for the Metacritic games website is connectable and returns a valid document of the webpage.
    * @param url the URL to be checked and retrieved
    * @return the document of the retrieved webpage
    * @throws IOException if an I/O error occurs while connecting to the website
    */

    public static Document checkConnect(String url) throws IOException {
        Document doc = null;
        try {
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();
        } catch (HttpStatusException e) {
            System.out.println("Invalid Metacritic URL. URL does not exist");
            System.exit(1);
        }
        return doc;
    }
}