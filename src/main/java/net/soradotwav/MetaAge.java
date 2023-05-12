package net.soradotwav;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class MetaAge {

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