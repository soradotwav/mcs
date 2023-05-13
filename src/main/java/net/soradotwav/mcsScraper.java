package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class mcsScraper {

    /**
     * Returns an array of ArrayLists that contains metadata for a list of games.
     * The metadata includes game titles, platforms, scores, release dates, and links.
     * 
     * @param listUrl the URL of the Metacritic page that contains the list of games
     * @return an array of ArrayLists that contains metadata for each game in the list
     * @throws IOException if an I/O error occurs while connecting to the website
     */
    public static ArrayList<String>[] cacheList(String listUrl) throws IOException {

        // Initializing connection to website
        urlChecker.check(listUrl);
        ArrayList<String>[] completeList = new ArrayList[5];
        Document doc = Jsoup.connect(listUrl)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();

        // Titles //
        ArrayList<String> namesList = new ArrayList<String>();
        Elements names = doc.select("a.title > h3");

        for(Element name : names) {
            try {
                String nameText = name.text();
                if (nameText == null) {
                    throw new NullPointerException("Title value is null");
                }
                namesList.add(nameText);
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                namesList.add("N/A");
            }
        }

        // Platforms //

        ArrayList<String> platformsList = new ArrayList<String>();
        Elements platforms = doc.select("div.clamp-details > div.platform > span.data");

        for(Element platform : platforms) {
            try {
                String platformText = platform.text();
                if (platformText == null) {
                    throw new NullPointerException("Platform value is null");
                }
                platformsList.add(platformText);
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                platformsList.add("N/A");
                continue;
            }
        }

        // Scores //

        ArrayList<String> scoresList = new ArrayList<String>();
        Elements scores = doc.select("div.clamp-score-wrap > a.metascore_anchor");

        for(Element score : scores) {
            try {
                String scoreText = score.text();
                if (scoreText == null) {
                    throw new NullPointerException("Score value is null");
                }
                scoresList.add(scoreText);
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                scoresList.add("N/A");
            }
        }

        // Release Dates //

        ArrayList<String> datesList = new ArrayList<String>();
        Elements dates = doc.select("div.clamp-details > span");

        for(Element date : dates) {
            try {
                String dateText = date.text();
                if (dateText == null) {
                    throw new NullPointerException("Date value is null");
                }
                datesList.add(dateText);
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                datesList.add("N/A");
            }
        }

        // Links //

        ArrayList<String> linksList = new ArrayList<String>();
        Elements links = doc.select("a.title");
        int indx = 0;

        for(Element link: links) {
            try {
                String listLink = link.attr("href");
                if (listLink == null) {
                    throw new NullPointerException("Link value is null");
                }
                if (listLink.contains("+")) {
                    listLink = listLink.replace("+", "%2B");
                }
                linksList.add(indx, "https://www.metacritic.com" + listLink);
                indx++;
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                linksList.add("N/A");
            }
        }

        // Write everything to output array

        completeList[0] = namesList;
        completeList[1] = platformsList;
        completeList[2] = scoresList;
        completeList[3] = datesList;
        completeList[4] = linksList;

        return completeList;
    }

    /**
     * Returns an array of strings that contains metadata for a single game.
     * The metadata includes the game title, platform, score, release date, and link.
     * 
     * @param url the URL of the Metacritic page that contains the game's metadata
     * @return an array of strings that contains metadata for the game
     * @throws IOException if an I/O error occurs while connecting to the website
     */
    public static String[] cacheItem(String url) throws IOException {
        urlChecker.check(url);
        String[] gameDetails = new String[5];
        Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();

        try {
            gameDetails[0] = doc.selectFirst("div.product_title > a").text();
        } catch (NullPointerException e) {
            gameDetails[0] = "N/A";
        }

        try {
            gameDetails[1] = doc.selectFirst("div.product_title > span").text();
        } catch (NullPointerException e) {
            gameDetails[1] = "N/A";
        }

        try {
            gameDetails[2] = doc.selectFirst("a.metascore_anchor").text();
        } catch (NullPointerException e) {
            gameDetails[2] = "N/A";
        }

        try {
            gameDetails[3] = doc.selectFirst("li.summary_detail.release_data > span.data").text();
        } catch (NullPointerException e) {
            gameDetails[3] = "N/A";
        }

        gameDetails[4] = url;

        return gameDetails;
    }

}