package net.soradotwav;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MetaScraper {

    public static ArrayList<String> getLinks(String url) throws IOException {
        ArrayList<String> linksList = new ArrayList<String>();
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a.title");

        int indx = 0;

        for(Element link: links) {

            String listLink = link.attr("href");

            if (listLink.contains("+")) {
                listLink = listLink.replace("+", "%2B");
            }

            linksList.add(indx, "https://www.metacritic.com" + listLink);
            indx++;

        }

        return linksList;
    }

}