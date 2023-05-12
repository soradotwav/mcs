package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MetaTitle {
    
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
}