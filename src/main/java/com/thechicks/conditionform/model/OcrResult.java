package com.thechicks.conditionform.model;

public class OcrResult {

    Pill pill;
    int quantity; //일 회 복용량
    int onedayDosage; //하루 복용 횟수
    int totalDayDosage; //총 복용 일수

    public OcrResult(){
        pill = new Pill();
        pill.setInsurance_code("0");
        quantity = 0;
        onedayDosage = 0;
        totalDayDosage = 0;
    }

    public Pill getPill() {
        return pill;
    }

    public void setPill(Pill pill) {
        this.pill = pill;
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
