package net.soradotwav;

public class UrlChecker {

    /**
    * This method checks if a given URL is valid for Metacritic games website.
    * @param url the URL to be checked.
    * @throws NullPointerException if the given URL is not valid for Metacritic games website.
    */
    public static void check(String url) {
        if(!url.contains("https://www.metacritic.com/game/" ) && !url.contains("https://www.metacritic.com/browse/games/")) {
            try {
                throw new NullPointerException("Invalid URL. Must contain 'https://www.metacritic.com/game/' or 'https://www.metacritic.com/browse/games/'");
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}