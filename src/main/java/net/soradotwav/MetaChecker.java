package net.soradotwav;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class MetaChecker {

    // Scores //
    public static int getScoresFromList(String urlList, int index) throws IOException {
        ArrayList<String> linkList = MetaScraper.getLinks(urlList);
        ArrayList<Integer> scoreList = new ArrayList<Integer>();

        for (String url : linkList) {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();

            Element score = doc.selectFirst("a.metascore_anchor");
            scoreList.add(Integer.parseInt(score.text()));
        }

        return scoreList.get(index);
    }

    public static ArrayList<Integer> getListOfScores(String urlList) throws IOException {
        ArrayList<String> linkList = MetaScraper.getLinks(urlList);
        ArrayList<Integer> scoreList = new ArrayList<Integer>();

        for (String url : linkList) {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();

            Element score = doc.selectFirst("a.metascore_anchor");
            scoreList.add(Integer.parseInt(score.text()));
        }

        return scoreList;
    }

    public static int getScoreFromURL(String url) throws IOException {
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer("http://www.metacritic.com")
                .get();

        Element score = doc.selectFirst("a.metascore_anchor");
        
        return Integer.parseInt(score.text()); 
    }


    // Titles //
    public static String getTitleFromURL(String url) throws IOException {
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer("http://www.metacritic.com")
                .get();

        Element title = doc.selectFirst("div.product_title > a");
        return title.text();
        
    }

    public static String getTitlesFromList(String urlList, int index) throws IOException {
        ArrayList<String> linkList = MetaScraper.getLinks(urlList);
        ArrayList<String> titleList = new ArrayList<String>();

        for (String url : linkList) {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();

            Element title = doc.selectFirst("div.product_title > a");
            titleList.add(title.text());
        }

        return titleList.get(index);
    }

    public static ArrayList<String> getListOfTitles(String urlList) throws IOException {
        ArrayList<String> linkList = MetaScraper.getLinks(urlList);
        ArrayList<String> titleList = new ArrayList<String>();

        for (String url : linkList) {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();

            Element title = doc.selectFirst("div.product_title > a");
            titleList.add(title.text());
        }

        return titleList;
    }

    // Platform //
    public static String getPlatformFromURL(String url) throws IOException {
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer("http://www.metacritic.com")
                .get();

        Element platform = doc.selectFirst("div.product_title > span > a");
        return platform.text();
        
    }

    public static String getPlatformFromList(String urlList, int index) throws IOException {
        ArrayList<String> linkList = MetaScraper.getLinks(urlList);
        ArrayList<String> platformList = new ArrayList<String>();

        for (String url : linkList) {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();

            Element title = doc.selectFirst("div.product_title > span > a");
            platformList.add(title.text());
        }

        return platformList.get(index);
    }

    public static ArrayList<String> getListOfPlatforms(String urlList) throws IOException {
        ArrayList<String> linkList = MetaScraper.getLinks(urlList);
        ArrayList<String> platformList = new ArrayList<String>();

        for (String url : linkList) {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();

            Element title = doc.selectFirst("div.product_title > span > a");
            platformList.add(title.text());
        }

        return platformList;
    }

    // Age rating
    private static String ageErrorMessage = "No Age Rating.";

    public static String getARFromURLold(String url) throws IOException {
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer("http://www.metacritic.com")
                .get();

        Element ageRating = doc.selectFirst("li.summary_detail.product_rating > span.data");
        return ageRating.text();
        
    }
    
    public static String getARFromURL(String url) throws IOException {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.metacritic.com")
                    .get();
    
            Element ageRating = doc.selectFirst("li.summary_detail.product_rating > span.data");
            if (ageRating == null) {
                throw new NullPointerException("No age rating found for URL: " + url);
                
            }
            return ageRating.text();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            return ageErrorMessage;
        }
    }
    
    public static String getARFromList(String urlList, int index) throws IOException {
        ArrayList<String> linkList = MetaScraper.getLinks(urlList);
        ArrayList<String> ageRatingList = new ArrayList<String>();
    
        for (String url : linkList) {
            try {
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.metacritic.com")
                        .get();
    
                Element ageRating = doc.selectFirst("li.summary_detail.product_rating > span.data");
                if (ageRating == null) {
                    ageRatingList.add(ageErrorMessage);
                    throw new NullPointerException("No age rating found for URL: " + url);
                }
                ageRatingList.add(ageRating.text());
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
    
        return ageRatingList.get(index);
    }

    public static ArrayList<String> getListOfAR(String urlList) throws IOException {
        ArrayList<String> linkList = MetaScraper.getLinks(urlList);
        ArrayList<String> ageRatingList = new ArrayList<String>();
    
        for (String url : linkList) {
            try {
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.metacritic.com")
                        .get();
    
                Element ageRating = doc.selectFirst("li.summary_detail.product_rating > span.data");
                if (ageRating == null) {
                    ageRatingList.add(ageErrorMessage);
                    throw new NullPointerException("No age rating found for URL: " + url);
                }
                ageRatingList.add(ageRating.text());
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
    
        return ageRatingList;
    }
    

}
