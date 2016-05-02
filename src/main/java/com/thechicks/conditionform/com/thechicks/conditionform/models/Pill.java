package com.thechicks.conditionform.com.thechicks.conditionform.models;

/**
 * Created by Leeseolhee on 2016. 4. 30..
 */
public class Pill {

    private int id;
    private String ko_name; // 한글약이름
    private String en_name; // 영문약이름
    private String image_url; // 이미지URL
    private String ingredient; // 성분명
    private String assortment; //전문/일반 //구분
    private String unitariness_or_complexness; // 단일/복합
    private String manufacture_assortment; //제조/수입사
    private String seller;//판매사
    private String formulation; //제형
    private String taking_route; // 투여경로
    private String korea_food_and_drug_administration_category; //식약처 분류
    private String insurance_code; //보험코드

    private String combination_taboo; //병용금기
    private String age_taboo; //연령금기
    private String pregnant_taboo; //임부금기
    private String old_man_caution; //노인주의
    private String volume_and_treatment_period_caution; //용량/투여기간주의
    private String division_caution; //분할주의
    private String blood_donation_prohibition; //헌혈금지

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

    public String getKo_name() {
        return ko_name;
    }

    public void setKo_name(String ko_name) {
        this.ko_name = ko_name;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
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

    public String getKorea_food_and_drug_administration_category() {
        return korea_food_and_drug_administration_category;
    }

    public void setKorea_food_and_drug_administration_category(String korea_food_and_drug_administration_category) {
        this.korea_food_and_drug_administration_category = korea_food_and_drug_administration_category;
    }

    public String getInsurance_code() {
        return insurance_code;
    }

    public void setInsurance_code(String insurance_code) {
        this.insurance_code = insurance_code;
    }

    public String getCombination_taboo() {
        return combination_taboo;
    }

    public void setCombination_taboo(String combination_taboo) {
        this.combination_taboo = combination_taboo;
    }

    public String getAge_taboo() {
        return age_taboo;
    }

    public void setAge_taboo(String age_taboo) {
        this.age_taboo = age_taboo;
    }

    public String getPregnant_taboo() {
        return pregnant_taboo;
    }

    public void setPregnant_taboo(String pregnant_taboo) {
        this.pregnant_taboo = pregnant_taboo;
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