package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MetaPlatform {
    
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
}