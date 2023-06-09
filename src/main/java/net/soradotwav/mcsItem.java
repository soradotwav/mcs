package net.soradotwav;

import java.io.IOException;

public class McsItem {

    private String gameTitle;
    private String gamePlatform;
    private String gameScore;
    private String gameDate;
    private String gameLink;

    /**
     * Constructs a new mcItem object with empty Strings for each metadata field.
     */
    public McsItem() {

        this.gameTitle = "";
        this.gamePlatform = "";
        this.gameScore = "";
        this.gameDate = "";
    }

    /**
     * Initializes the mcsItem object by scraping metadata from the games url.
     * 
     * @param url the URL of the Metacritic page that contains the game
     * @throws IOException if an I/O error occurs while connecting to the website
     */
    public void initializeItem(String url) throws IOException {
        String[] tempCache = McsScraper.cacheItem(url);

        this.gameTitle = tempCache[0];
        this.gamePlatform= tempCache[1];
        this.gameScore = tempCache[2];
        this.gameDate = tempCache[3];
        this.gameLink = tempCache[4];
    }

    /**
     * Returns the title of the initialized game
     * 
     * @return String of the game title 
     */
    public String getTitle() {
        return gameTitle;
    }

    /**
     * Returns the platform of the initialized game
     * 
     * @return String of the game platform 
     */
    public String getPlatform() {
        return gamePlatform;
    }

    /**
     * Returns the score of the initialized game
     * 
     * @return String of the game score 
     */
    public String getScore() {
        return gameScore;
    }

    /**
     * Returns the release date of the initialized game
     * 
     * @return String of the game release date 
     */
    public String getReleaseDate() {
        return gameDate;
    }

    /**
     * Returns the link of the initialized game
     * 
     * @return String of the game link 
     */
    public String getLink() {
        return gameLink;
    }

    /**
     * Clears the mcsItem object with empty Strings for each metadata field.
     */
    public void clear() {
        this.gameTitle = "";
        this.gamePlatform = "";
        this.gameScore = "";
        this.gameDate = "";
    }

}