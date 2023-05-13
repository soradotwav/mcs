package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;

public class mcsList {

    private ArrayList<String> gameTitles;
    private ArrayList<String> gamePlatforms;
    private ArrayList<String> gameScores;
    private ArrayList<String> gameDates;
    private ArrayList<String> gameLinks;

    public mcsList() {

        this.gameTitles = new ArrayList<String>();
        this.gamePlatforms = new ArrayList<String>();
        this.gameScores = new ArrayList<String>();
        this.gameDates = new ArrayList<String>();
        this.gameLinks = new ArrayList<String>();

    }

    public void initializeList(String listUrl) throws IOException {
        ArrayList<String>[] tempCache = MetaScraper.cacheList(listUrl);
        this.gameTitles = tempCache[0];
        this.gamePlatforms = tempCache[1];
        this.gameScores = tempCache[2];
        this.gameDates = tempCache[3];
        this.gameLinks = tempCache[4];
    }

    public ArrayList<String> getTitles() {
        return this.gameTitles;
    }

    public String getTitles(int index) {
        return this.gameTitles.get(index);
    }

    public ArrayList<String> getPlatforms() {
        return this.gamePlatforms;
    }

    public String getPlatforms(int index) {
        return this.gamePlatforms.get(index);
    }

    public ArrayList<String> getScores() {
        return this.gameScores;
    }

    public String getScores(int index) {
        return this.gameScores.get(index);
    }

    public ArrayList<String> getReleaseDates() {
        return this.gameDates;
    }

    public String getReleaseDates(int index) {
        return this.gameDates.get(index);
    }

    public ArrayList<String> getLinks() {
        return this.gameLinks;
    }

    public String getLinks(int indx) {
        return this.gameLinks.get(indx);
    }

    public void clear() {
        this.gameTitles = new ArrayList<String>();
        this.gamePlatforms = new ArrayList<String>();
        this.gameScores = new ArrayList<String>();
        this.gameDates = new ArrayList<String>();
        this.gameLinks = new ArrayList<String>();
    }
}
