package net.soradotwav;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class MetaScore {

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
}
