package com.thechicks.conditionform.ocr;


import java.util.*;

/**
 * Created by Leeseolhee on 2016. 5. 26..
 */
public class ResultFilter {


    private char[] CONSONANT =
		/*ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅅ ㅆ ㅇ ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ ㅎ */
            {0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
                    0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
    private char[] VOWEL =
		/*ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ*/
            {0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158,
                    0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160,	0x3161,	0x3162,
                    0x3163};
    /*X ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ*/
    private char[] FINALCONSONANT =
            {0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a,
                    0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145,
                    0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};

    private class Candidate {

        private String splitedPillName;
        private String searchedPillName;
        private int distance;

        public Candidate(String searchedPillName, String splitedStr, int distance) {
            this.searchedPillName = searchedPillName;
            this.splitedPillName = splitedStr;
            this.distance = distance;
        }
    }



    public void getFliteredPillName(String pillName) {

        List<String> splitedStr = Split(pillName);
        List<String> searchedPillName = new ArrayList<>(); // 쿼리를 던져서 약 후보들을 가져온다. => 했다고 가정.
        searchedPillName = new ArrayList<>(new HashSet<>(searchedPillName)); // 중복 제거
        List<Candidate> candidates = new ArrayList<>();

        for(int i = 0; i < splitedStr.size(); i++) {
            for(int j = 0; j < searchedPillName.size(); j++) {

                //자음모음종성으로 나눈다.
                //List<Character> s1 = Division("하이에틴정");
                //List<Character> s2 = Division("하이에틴정");

                candidates.add(new Candidate(splitedStr.get(i), searchedPillName.get(j), getDistance(splitedStr.get(i), searchedPillName.get(j))));
            }
        }

        // splitedStr와 약 후보들을 비교하면서 가장 비슷한 약 후보를 찾는다.

    }

    private List<String> Split(String str) {

        List<String> splitedStr = new ArrayList<>();

        if(str.length() >= 3) {
            splitedStr.add(str);
            splitedStr.add(str.substring(1));
            splitedStr.add(str.substring(2));
            splitedStr.add(str.substring(0,str.length()-1));
            splitedStr.add(str.substring(0,str.length()-2));
        }

        return splitedStr;
    }


    private List<Character> CharacterDivision(String str) {

        int j = 0;
        List<Character> division = new ArrayList<>();

        System.out.println(str);

        for(int i = 0 ; i < str.length();i++)
        {
            Map<String, Integer> map = new HashMap<>();
            char test = str.charAt(i);

            if(test >= 0xAC00)
            {
                //자음 모음 분리
                char uniVal = (char) (test - 0xAC00);
                char cho = (char) (((uniVal - (uniVal % 28))/28)/21);
                char jun = (char) (((uniVal - (uniVal % 28))/28)%21);
                char jon = (char) (uniVal %28);

                System.out.println(""+ CONSONANT[cho]);
                System.out.println(""+ VOWEL[jun]);
                if((char)jon != 0x0000)
                    System.out.println(""+ FINALCONSONANT[jon]);

                division.add(j++,CONSONANT[cho]);
                division.add(j++, VOWEL[jun]);
                if((char)jon != 0x0000)
                    division.add(j++, FINALCONSONANT[jon]);

            }
        }

        return division;
    }


    //    public static int getDistance(List<Character> s1, List<Character> s2) {
//
//        int distance;
//        int len = (s1.size() > s2.size())? s1.size() : s2.size();
//
//        for(int i = 0; i < len; i++) {
//
//            if (s1.get(i - 1) != s2.get(j - 1)) {
//                match = 1;
//            }
//
//        }
//
//
//        return distance;
//
//    }



    //ToDo: 모음자음으로 비교할것, 거리는 단어 길이에 따라서 달리 측정,
    public int getDistance(String s1, String s2) {
        int longStrLen = s1.length() + 1;
        int shortStrLen = s2.length() + 1;

        // 긴 단어 만큼 크기가 나올 것이므로, 가장 긴단어 에 맞춰 Cost를 계산
        int[] cost = new int[longStrLen];
        int[] newcost = new int[longStrLen];

        // 초기 비용을 가장 긴 배열에 맞춰서 초기화 시킨다.
        for (int i = 0; i < longStrLen; i++) {
            cost[i] = i;
        }

        // 짧은 배열을 한바퀴 돈다.
        for (int j = 1; j < shortStrLen; j++) {
            // 초기 Cost는 1, 2, 3, 4...
            newcost[0] = j;

            // 긴 배열을 한바퀴 돈다.
            for (int i = 1; i < longStrLen; i++) {
                // 원소가 같으면 0, 아니면 1
                int match = 0;
                System.out.println(s1.charAt(i - 1) + ", "+ s2.charAt(j - 1));
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    match = 1;
                }

                // 대체, 삽입, 삭제의 비용을 계산한다.
                int replace = cost[i - 1] + match;
                int insert = cost[i] + 1;
                int delete = newcost[i - 1] + 1;

                // 가장 작은 값을 비용에 넣는다.
                newcost[i] = Math.min(Math.min(insert, delete), replace);
            }

            // 기존 코스트 & 새 코스트 스위칭
            int[] temp = cost;
            cost = newcost;
            newcost = temp;
        }

        // 가장 마지막값 리턴
        return cost[longStrLen - 1];
    }




}


