package com.thechicks.conditionform.model;

public class OcrResult {
    String pillInsuranceCode;
    String pillName;
    int quantity; //일 회 복용량
    int onedayDosage; //하루 복용 횟수
    int totalDayDosage; //총 복용 일수

    public String getPillInsuranceCode() {
        return pillInsuranceCode;
    }

    public void setPillInsuranceCode(String pillInsuranceCode) {
        this.pillInsuranceCode = pillInsuranceCode;
    }

    public String getPillName() {
        return pillName;
    }

    public void setPillName(String pillName) {
        this.pillName = pillName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOnedayDosage() {
        return onedayDosage;
    }

    public void setOnedayDosage(int onedayDosage) {
        this.onedayDosage = onedayDosage;
    }

    public int getTotalDayDosage() {
        return totalDayDosage;
    }

    public void setTotalDayDosage(int totalDayDosage) {
        this.totalDayDosage = totalDayDosage;
    }


}
