package com.thechicks.conditionform.com.thechicks.conditionform.beans;

/**
 * Created by Leeseolhee on 2016. 4. 30..
 */
public class PillInfo {

    private int id;
    private String medi_ko_name; // 한글약이름
    private String medi_en_name; // 영문약이름
    private String image_url; // 이미지URL
    private String ingredient; // 성분명
    private String assortment; //전문/일반 //구분
    private String unitariness_or_complexness; // 단일/복합
    private String manufacture_assortment; //제조/수입사
    private String seller;//판매사
    private String formulation; //제형
    private String taking_route; // 투여경로
    private String welfare_category; //복지부분류
    private String insurance_code; //보험코드

    private String combination_prohibition; //병용금지
    private String age_prohibition; //연령금지
    private String pregnant_prohibition; //임부금지
    private String old_man_caution; //노인주의
    private String volume_and_treatment_period_caution; //용량/투여기간주의
    private String division_caution; //분할주의
    private String blood_donation_prohibition; //헌혈금기

    private String shape_info; //성상
    private String packing_unit; //포장단위
    private String storagint_method; //저장방법
    private String efficacy; //효능효과
    private String dosage; //용법용량
    private String precaution; //사용상주의사항
    private String medication_guide; //복약지도


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedi_ko_name() {
        return medi_ko_name;
    }

    public void setMedi_ko_name(String medi_ko_name) {
        this.medi_ko_name = medi_ko_name;
    }

    public String getMedi_en_name() {
        return medi_en_name;
    }

    public void setMedi_en_name(String medi_en_name) {
        this.medi_en_name = medi_en_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getAssortment() {
        return assortment;
    }

    public void setAssortment(String assortment) {
        this.assortment = assortment;
    }

    public String getUnitariness_or_complexness() {
        return unitariness_or_complexness;
    }

    public void setUnitariness_or_complexness(String unitariness_or_complexness) {
        this.unitariness_or_complexness = unitariness_or_complexness;
    }

    public String getManufacture_assortment() {
        return manufacture_assortment;
    }

    public void setManufacture_assortment(String manufacture_assortment) {
        this.manufacture_assortment = manufacture_assortment;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getTaking_route() {
        return taking_route;
    }

    public void setTaking_route(String taking_route) {
        this.taking_route = taking_route;
    }

    public String getWelfare_category() {
        return welfare_category;
    }

    public void setWelfare_category(String welfare_category) {
        this.welfare_category = welfare_category;
    }

    public String getInsurance_code() {
        return insurance_code;
    }

    public void setInsurance_code(String insurance_code) {
        this.insurance_code = insurance_code;
    }

    public String getCombination_prohibition() {
        return combination_prohibition;
    }

    public void setCombination_prohibition(String combination_prohibition) {
        this.combination_prohibition = combination_prohibition;
    }

    public String getAge_prohibition() {
        return age_prohibition;
    }

    public void setAge_prohibition(String age_prohibition) {
        this.age_prohibition = age_prohibition;
    }

    public String getPregnant_prohibition() {
        return pregnant_prohibition;
    }

    public void setPregnant_prohibition(String pregnant_prohibition) {
        this.pregnant_prohibition = pregnant_prohibition;
    }

    public String getOld_man_caution() {
        return old_man_caution;
    }

    public void setOld_man_caution(String old_man_caution) {
        this.old_man_caution = old_man_caution;
    }

    public String getVolume_and_treatment_period_caution() {
        return volume_and_treatment_period_caution;
    }

    public void setVolume_and_treatment_period_caution(String volume_and_treatment_period_caution) {
        this.volume_and_treatment_period_caution = volume_and_treatment_period_caution;
    }

    public String getDivision_caution() {
        return division_caution;
    }

    public void setDivision_caution(String division_caution) {
        this.division_caution = division_caution;
    }

    public String getBlood_donation_prohibition() {
        return blood_donation_prohibition;
    }

    public void setBlood_donation_prohibition(String blood_donation_prohibition) {
        this.blood_donation_prohibition = blood_donation_prohibition;
    }

    public String getShape_info() {
        return shape_info;
    }

    public void setShape_info(String shape_info) {
        this.shape_info = shape_info;
    }

    public String getPacking_unit() {
        return packing_unit;
    }

    public void setPacking_unit(String packing_unit) {
        this.packing_unit = packing_unit;
    }

    public String getStoragint_method() {
        return storagint_method;
    }

    public void setStoragint_method(String storagint_method) {
        this.storagint_method = storagint_method;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getPrecaution() {
        return precaution;
    }

    public void setPrecaution(String precaution) {
        this.precaution = precaution;
    }

    public String getMedication_guide() {
        return medication_guide;
    }

    public void setMedication_guide(String medication_guide) {
        this.medication_guide = medication_guide;
    }

}