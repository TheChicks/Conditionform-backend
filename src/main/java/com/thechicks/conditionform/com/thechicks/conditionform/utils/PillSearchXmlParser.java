package com.thechicks.conditionform.com.thechicks.conditionform.utils;

/**
 * Created by Leeseolhee on 2016. 4. 23..
 */
public class PillSearchXmlParser {

//
//    public static final String TAG = "NaverSearch";
//    private static final String BASE_URL = "https://openapi.naver.com/v1/search/encyc.xml?";
//    private static final int START = 1;
//    private static final int DISPLAY = 100;
//    private static final String XNaverClientId = "ddOD4kMTcs7eD5zKcVza";
//    public static final String naverAPIPW = "quYHjezmvp";
//
//    private static final class PARAM {
//        private static final String QUERY = "query=";
//        private static final String START = "&start=";
//        private static final String DISPLAY = "&display";
//    }
//
////    private static PillSearchXmlParser instance;
//
//
////    public static PillSearchXmlParser getInstance() {
////        synchronized (PillSearchXmlParser.class) {
////            if (instance == null) {
////                instance = new PillSearchXmlParser();
////            }
////            return instance;
////        }
////    }
////
////    private PillSearchXmlParser() {
////        try {
////
////        }catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//
//    public static List<Pill> getSearchPillSerchInfoList(String searchStr) {
//
//        List<Pill> pills = new ArrayList<Pill>();
//
//        try {
//
//            String addr = BASE_URL + PARAM.QUERY + URLEncoder.encode(searchStr, "utf-8") + PARAM.START + START + PARAM.DISPLAY + DISPLAY;
//
//            URL url = new URL(addr);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestProperty("X-Naver-Client-Id", XNaverClientId); //발급받은 ID
//            connection.setRequestProperty("X-Naver-Client-Secret", naverAPIPW);// 발급받은 PW
//            connection.setRequestProperty("Content-Type", "application/xml"); // 받을요청타입
//
//            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            Document document = documentBuilder.parse(connection.getInputStream());
//            NodeList nodeList = document.getElementsByTagName("item");
//
//                Pill pill = new Pill();
//
//                for (Node node = nodeList.item(0).getFirstChild(); node != null; node = node.getNextSibling()) {
//
//                    String nodeName = node.getNodeName();
//
//                    if (nodeName.equals("title")) {
//                        System.out.println(node.getTextContent());
//                        pill.setMedi_ko_name(node.getTextContent());
//                    } else if (nodeName.equals("link")) {
//                        System.out.println(node.getTextContent());
//                        pill.setLink(node.getTextContent());
//                    } else if (nodeName.equals("thumbnail")) {
//                        System.out.println(node.getTextContent());
//                        pill.setImage_url(node.getTextContent());
//                    }
//
//                }
//
//                pills.add(pill);
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        return  pills;
//
//    }


}
