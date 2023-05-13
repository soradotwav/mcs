package net.soradotwav;

import java.io.IOException;

public class mcsItem {

    private String gameTitle;
    private String gamePlatform;
    private String gameScore;
    private String gameDate;
    private String gameLink;

    public mcsItem() {

        this.gameTitle = "";
        this.gamePlatform = "";
        this.gameScore = "";
        this.gameDate = "";

    }

    public void initializeItem(String url) throws IOException {
        String[] tempCache = MetaScraper.cacheItem(url);

        this.gameTitle = tempCache[0];
        this.gamePlatform= tempCache[1];
        this.gameScore = tempCache[2];
        this.gameDate = tempCache[3];
        this.gameLink = tempCache[4];
    }

    public String getTitle() {
        return this.gameTitle;
    }

    public String getPlatform() {
        return this.gamePlatform;
    }

    public String getScore() {
        return this.gameScore;
    }

    public String getReleaseDate() {
        return this.gameDate;
    }

    public String getLink() {
        return this.gameLink;
    }

    public void clear() {
        this.gameTitle = "";
        this.gamePlatform = "";
        this.gameScore = "";
        this.gameDate = "";
    }

}