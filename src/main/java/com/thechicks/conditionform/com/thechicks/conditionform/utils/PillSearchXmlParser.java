package com.thechicks.conditionform.com.thechicks.conditionform.utils;

import com.thechicks.conditionform.com.thechicks.conditionform.beans.Pill;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
/**
 * Created by Leeseolhee on 2016. 4. 23..
 */
public class PillSearchXmlParser {


    public static final String TAG = "NaverSearch";
    private static final String BASE_URL = "https://openapi.naver.com/v1/search/encyc.xml?";
    private static final int START = 1;
    private static final int DISPLAY = 100;
    private static final String XNaverClientId = "ddOD4kMTcs7eD5zKcVza";
    public static final String naverAPIPW = "quYHjezmvp";

    private static final class PARAM {
        private static final String QUERY = "query=";
        private static final String START = "&start=";
        private static final String DISPLAY = "&display";
    }

    private static PillSearchXmlParser instance;
    private DocumentBuilder documentBuilder;


    public static PillSearchXmlParser getInstance() {
        synchronized (PillSearchXmlParser.class) {
            if (instance == null) {
                instance = new PillSearchXmlParser();
            }
            return instance;
        }
    }

    private PillSearchXmlParser() {
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Pill getSearchPillLink(String input) {

        Pill pill = new Pill();


        try {

            String addr = BASE_URL + PARAM.QUERY + URLEncoder.encode(input, "utf-8") + PARAM.START + START + PARAM.DISPLAY + DISPLAY;

            URL url = new URL(addr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Naver-Client-Id", XNaverClientId); //발급받은 ID
            connection.setRequestProperty("X-Naver-Client-Secret", naverAPIPW);// 발급받은 PW
            connection.setRequestProperty("Content-Type", "application/xml"); // 받을요청타입


            Document document = documentBuilder.parse(connection.getInputStream());
            NodeList nodeList = document.getElementsByTagName("item");


            for (Node node = nodeList.item(0).getFirstChild(); node != null; node = node.getNextSibling()) {

                String nodeName = node.getNodeName();

                if(nodeName.equals("title")) {
                    System.out.println(node.getTextContent());
                    pill.setMedi_ko_name(node.getTextContent());
                }else if(nodeName.equals("link")) {
                    System.out.println(node.getTextContent());
                    pill.setLink(node.getTextContent());
                }else if(nodeName.equals("thumbnail")) {
                    System.out.println(node.getTextContent());
                    pill.setImage_url(node.getTextContent());
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return  pill;

    }


}
