package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;

public class mcs {

    private static ArrayList<String> gameTitles;
    private static ArrayList<String> gamePlatforms;
    private static ArrayList<String> gameScores;
    private static ArrayList<String> gameDates;
    private static ArrayList<String> gameLinks;

    public mcs() {

        gameTitles = new ArrayList<String>();
        gamePlatforms = new ArrayList<String>();
        gameScores = new ArrayList<String>();
        gameDates = new ArrayList<String>();
        gameLinks = new ArrayList<String>();

    }

    public void initialize(String listUrl) throws IOException {
        ArrayList<String>[] tempCache = MetaScraper.cacheList(listUrl);
        gameTitles = tempCache[0];
        gamePlatforms = tempCache[1];
        gameScores = tempCache[2];
        gameDates = tempCache[3];
        gameLinks = tempCache[4];
    }

    public ArrayList<String> getTitles() {
        return gameTitles;
    }

    public String getTitles(int index) {
        return gameTitles.get(index);
    }

    public ArrayList<String> getPlatforms() {
        return gamePlatforms;
    }

    public String getPlatforms(int index) {
        return gamePlatforms.get(index);
    }

    public ArrayList<String> getScores() {
        return gameScores;
    }

    public String getScores(int index) {
        return gameScores.get(index);
    }

    public ArrayList<String> getReleaseDates() {
        return gameDates;
    }

    public String getReleaseDates(int index) {
        return gameDates.get(index);
    }

    public ArrayList<String> getLinks() {
        return gameLinks;
    }

    public String getLinks(int indx) {
        return gameLinks.get(indx);
    }

    public void clear() {
        gameTitles = new ArrayList<String>();
        gamePlatforms = new ArrayList<String>();
        gameScores = new ArrayList<String>();
        gameDates = new ArrayList<String>();
        gameLinks = new ArrayList<String>();
    }

}