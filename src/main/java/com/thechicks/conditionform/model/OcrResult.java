package com.thechicks.conditionform.model;

public class OcrResult {
    String pillInsuranceCode;
    String pillName;
    String quantity; //일 회 복용량
    String onedayDosage; //하루 복용 횟수
    String totalDayDosage; //총 복용 일수

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOnedayDosage() {
        return onedayDosage;
    }

    public void setOnedayDosage(String onedayDosage) {
        this.onedayDosage = onedayDosage;
    }

    public String getTotalDayDosage() {
        return totalDayDosage;
    }

    public void setTotalDayDosage(String totalDayDosage) {
        this.totalDayDosage = totalDayDosage;
    }
}
