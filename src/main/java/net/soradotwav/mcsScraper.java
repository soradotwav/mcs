package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class McsScraper {

    private static Document doc = null;

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
        UrlChecker.checkMain(listUrl);
        ArrayList<String>[] completeList = new ArrayList[5];
        doc = UrlChecker.checkConnect(listUrl);

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

    private static String[] gameDetails = new String[5];

    /**
     * Returns an array of strings that contains metadata for a single game.
     * The metadata includes the game title, platform, score, release date, and link.
     * 
     * @param url the URL of the Metacritic page that contains the game's metadata
     * @return an array of strings that contains metadata for the game
     * @throws IOException if an I/O error occurs while connecting to the website
     */
    public static String[] cacheItem(String url) throws IOException {
        UrlChecker.checkMain(url);
        doc = UrlChecker.checkConnect(url);

        getVal("div.product_title > a", 0);
        getVal("div.product_title > span", 1);
        getVal("a.metascore_anchor", 2);
        getVal("li.summary_detail.release_data > span.data", 3);

        gameDetails[4] = url;

        return gameDetails;
    }

    public static void getVal(String cssQuery, int index) {

        try {
            gameDetails[index] = doc.selectFirst(cssQuery).text();
        } catch (NullPointerException e) {
            gameDetails[index] = "N/A";
        }
    }
}