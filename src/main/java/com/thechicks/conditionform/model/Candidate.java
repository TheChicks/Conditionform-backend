package com.thechicks.conditionform.model;

/**
 * Created by Leeseolhee on 2016. 5. 31..
 */
public class Candidate {
    private String splitedPillName;
    private String searchedPillName;
    private int distance;

    public Candidate(String searchedPillName, String splitedStr, int distance) {
        this.searchedPillName = searchedPillName;
        this.splitedPillName = splitedStr;
        this.distance = distance;
    }

    public String getSplitedPillName() {
        return splitedPillName;
    }

    public String getSearchedPillName() {
        return searchedPillName;
    }

    public int getDistance() {
        return distance;
    }


}
