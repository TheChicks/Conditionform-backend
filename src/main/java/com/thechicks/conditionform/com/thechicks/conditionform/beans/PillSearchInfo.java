package com.thechicks.conditionform.com.thechicks.conditionform.beans;

/**
 * Created by Leeseolhee on 2016. 4. 22..
 */
public class PillSearchInfo {

    private String no;
    private String mediKoName;
    private String link;
    private String imageUrl;
    private String insuranceCode;

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getMediKoName() {
        return mediKoName;
    }

    public void setMediKoName(String mediKoName) {
        this.mediKoName = mediKoName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

/*

<item>
     <title>타이레놀이알서방정</title>
     <link>http://openapi.naver.com/l?AAAD2MQQqDMBRETxOX8vOTRlxkUSmCpcT2CEFjI5jYxrQlPX3jpjAD8wZmni8TkhRc1ADZhQ1mkjbGB2FHgm1WNMFtpddvE8phdbkxPoZUeusJa8d16EbCTkg5MFoRFMO884ECwE46mvsaUvcviygpF5QhcIaiqgsn8dx8+v35qieLelQ5KnX5bjNfeoLNLW9/FRo/aqkAAAA=</link>
     <description>[외형정보] · 성상 : 백색의 장방형 필름코팅정제 · 제형 : 필름코팅정 · 모양 : 장방형 · 색상 : 하양 · 식별표기 : TYLENOLER [성분정보] 아세트아미노펜 650mg [저장방법] 밀폐용기 실온보관 [효능효과] 해열... </description>
     <thumbnail>http://dbscthumb.phinf.naver.net/3323_000_1/20140711144958373_ZGW84GJ8L.jpg/A11A4380A006101.jpg?type=w450_fst#450x245</thumbnail>
</item>

* */