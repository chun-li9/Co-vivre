package com.Covivre.Covivre.Service;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class WebCrawService {
    private CloseableHttpClient client = HttpClients.createDefault();

    public ArrayList<String> getCases() throws IOException {
        ArrayList<String> result = new ArrayList<String>();

        String demandName = "https://santemontreal.qc.ca/en/public/coronavirus-covid-19/situation-of-the-coronavirus-covid-19-in-montreal/";
        CloseableHttpClient foo = HttpClients.createDefault();
        HttpGet get = new HttpGet(demandName);
        CloseableHttpResponse response = foo.execute(get);
        StatusLine line = response.getStatusLine();
        System.out.println(line.getStatusCode());
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity,"utf-8");
        
        response.close();
        foo.close();

//        System.out.println(html);
        System.out.println("start to initialize the jsoup class-------------------");
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("contenttable");
        //System.out.println(elements.toString());

        String[] lines = elements.toString().split("\n");
        ArrayList<String> data = new ArrayList<>();
        int count = 0;
        for(int i=0;i<lines.length;i++){
            if(lines[i].contains("Total for Montréal")){
                count = i+1;
                break;
            }
            //System.out.println(lines[i]);
        }
        for(int i=0;i<5;i++){
            data.add(lines[i+count]);
        }
        for(int i=0;i<data.size();i++){
            String[] aLine = data.get(i).split("<");
            result.add(aLine[2].split(">")[1]);
        }
        String death = "";
        for(String eachLine:lines){
            if(eachLine.contains("Number of deaths")){
                death = eachLine;
                break;
            }
        }
        death = death.split("h3")[1].replaceAll("[></]","");

        String recovered = "";
        for(String eachLine:lines){
            if(eachLine.contains("Recovered cases")){
                recovered = eachLine;
                break;
            }
        }
        recovered = recovered.split("h3")[1].replaceAll("[></]","");

        result.add(death);
        result.add(recovered);
        return result;
    }

    public ArrayList<String> getCityName(String postalCode) throws IOException {
        String[] cities = {"Ahuntsic+Cartierville","Anjou","Anjou","Beaconsfield","Côte+des+Neiges+Notre+Dame+de+Grâce",
        "Côte+Saint+Luc","Dollard+des+Ormeaux","Dorval","Hampstead","Kirkland","Lachine","Lachine",
        "L'Île+Bizard+Sainte+Geneviève","Mercier+Hochelaga+Maisonneuve","Montréal+Est","Montréal+Nord",
        "Montréal+Ouest","Mont-Royal","Outremont","Pierrefonds+Roxboro","Plateau+Mont+Royal",
        "Pointe+Claire","Rivière+des+Prairies+Pointe+aux+ Trembles","Rosemont+La Petite Patrie","Sainte+Anne+de+Bellevue",
        "Saint+Laurent","Saint+Léonard","Senneville","Sud+Ouest","Verdun","Ville+Marie","Villeray+Saint+Michel+Parc+Extension",
        "Westmount"};

        String[] cityTwo = {"Anjou"};




        return null;
    }

    public static void main(String[] args) throws IOException {
        WebCrawService webCrawService= new WebCrawService();
        //System.out.println(webCrawService.getCases());
        webCrawService.getCityName("post");
    }
}
