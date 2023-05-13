package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;

public class mcsList {

    private ArrayList<String> gameTitles;
    private ArrayList<String> gamePlatforms;
    private ArrayList<String> gameScores;
    private ArrayList<String> gameDates;
    private ArrayList<String> gameLinks;

    /**
     * Constructs a new mcsList object with empty ArrayLists for each metadata field.
     */
    public mcsList() {

        this.gameTitles = new ArrayList<String>();
        this.gamePlatforms = new ArrayList<String>();
        this.gameScores = new ArrayList<String>();
        this.gameDates = new ArrayList<String>();
        this.gameLinks = new ArrayList<String>();

    }

    /**
     * Initializes the mcsList object by scraping metadata for each game in a given list.
     * 
     * @param listUrl the URL of the Metacritic page that contains the list of games
     * @throws IOException if an I/O error occurs while connecting to the website
     */
    public void initializeList(String listUrl) throws IOException {
        ArrayList<String>[] tempCache = MetaScraper.cacheList(listUrl);
        this.gameTitles = tempCache[0];
        this.gamePlatforms = tempCache[1];
        this.gameScores = tempCache[2];
        this.gameDates = tempCache[3];
        this.gameLinks = tempCache[4];
    }

    // Titles //

    /**
     * Returns the game title for each game in the list.
     * 
     * @return an ArrayList of game titles
     */
    public ArrayList<String> getTitles() {
        return this.gameTitles;
    }

    /**
     * Returns the title of a game at a specified index from the list of games.
     * 
     * @param int index of specific game
     * @return String title of specific game
     */
    public String getTitles(int index) {
        return this.gameTitles.get(index);
    }

    // Platforms //

    /**
     * Returns the game platform for each game in the list.
     * 
     * @return an ArrayList of game platforms
     */
    public ArrayList<String> getPlatforms() {
        return this.gamePlatforms;
    }

    /**
     * Returns the platform of a game at a specified index from the list of games.
     * 
     * @param int index of specific game
     * @return String platform of specific game
     */
    public String getPlatforms(int index) {
        return this.gamePlatforms.get(index);
    }

    // Critic Scores //

    /**
     * Returns the game critic score for each game in the list.
     * 
     * @return an ArrayList of game critic scores
     */
    public ArrayList<String> getScores() {
        return this.gameScores;
    }

    /**
     * Returns the score of a game at a specified index from the list of games.
     * 
     * @param int index of specific game
     * @return String title of specific game
     */
    public String getScores(int index) {
        return this.gameScores.get(index);
    }

    // Release Dates //

    /**
     * Returns the game release date for each game in the list.
     * 
     * @return an ArrayList of game release dates
     */
    public ArrayList<String> getReleaseDates() {
        return this.gameDates;
    }

    /**
     * Returns the release date of a game at a specified index from the list of games.
     * 
     * @param int index of speciifc game
     * @return String release date of specific game
     */
    public String getReleaseDates(int index) {
        return this.gameDates.get(index);
    }

    // Links //

    /**
     * Returns the game link for each game in the list.
     * 
     * @return an ArrayList of game links
     */
    public ArrayList<String> getLinks() {
        return this.gameLinks;
    }

    /**
     * Returns the link of a game at a specified index from the list of games.
     * 
     * @param int index of speciifc game
     * @return String link of specific game
     */
    public String getLinks(int indx) {
        return this.gameLinks.get(indx);
    }

    /**
     * Clears the mcsList object with empty ArrayLists for each metadata field.
     */
    public void clear() {
        this.gameTitles = new ArrayList<String>();
        this.gamePlatforms = new ArrayList<String>();
        this.gameScores = new ArrayList<String>();
        this.gameDates = new ArrayList<String>();
        this.gameLinks = new ArrayList<String>();
    }
}
