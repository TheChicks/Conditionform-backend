package com.thechicks.conditionform.service;

import com.thechicks.conditionform.dao.PillDao;
import com.thechicks.conditionform.model.Pill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 5. 5..
 */

@Service
@Transactional
public class PillService {

    @Autowired
    PillDao pillDao;

    public List<Pill> findAll() {
        return pillDao.findAll();
    }

    public List<Pill> getBySerchWord(String searchWord) {

        List<Pill> pillList =  pillDao.getBySerchWord(searchWord);


        for(int i = 0; i < pillList.size(); i++) {

            //영문약이름, 이미지URL, 성분명, 전문/일반, 단일/복합, 제조/수입사, 판매사, 제형, 투여경로, 식약처 분류, 보험코드
            if(pillList.get(i).getEn_name() == null) pillList.get(i).setEn_name("없음");
            if(pillList.get(i).getImage_url() == null) pillList.get(i).setImage_url("없음");
            if(pillList.get(i).getIngredient() == null) pillList.get(i).setIngredient("없음");
            if(pillList.get(i).getAssortment() == null) pillList.get(i).setAssortment("없음");
            if(pillList.get(i).getUnitariness_or_complexness() == null) pillList.get(i).setUnitariness_or_complexness("없음");
            if(pillList.get(i).getManufacture_assortment() == null) pillList.get(i).setManufacture_assortment("없음");
            if(pillList.get(i).getSeller() == null) pillList.get(i).setSeller("없음");
            if(pillList.get(i).getFormulation() == null) pillList.get(i).setFormulation("없음");
            if(pillList.get(i).getTaking_route() == null) pillList.get(i).setTaking_route("없음");
            if(pillList.get(i).getKorea_food_and_drug_administration_category() == null) pillList.get(i).setKorea_food_and_drug_administration_category("없음");
            if(pillList.get(i).getInsurance_code() == null) pillList.get(i).setInsurance_code("없음");



            //병용금지, 연령금기, 임부금기, 노인주의, 용량/투여기간주의, 분할주의, 헌혈금지
            if(pillList.get(i).getCombination_taboo() == null) pillList.get(i).setCombination_taboo("없음");
            if(pillList.get(i).getAge_taboo() == null) pillList.get(i).setAge_taboo("없음");
            if(pillList.get(i).getPregnant_taboo() == null) pillList.get(i).setPregnant_taboo("없음");
            if(pillList.get(i).getOld_man_caution() == null) pillList.get(i).setOld_man_caution("없음");
            if(pillList.get(i).getVolume_and_treatment_period_caution() == null) pillList.get(i).setVolume_and_treatment_period_caution("없음");
            if(pillList.get(i).getDivision_caution() == null) pillList.get(i).setDivision_caution("없음");
            if(pillList.get(i).getBlood_donation_prohibition() == null) pillList.get(i).setBlood_donation_prohibition("없음");


            // 성상, 포장단위, 저장방법, 효능효과, 용법용량, 사용상주의사항, 복약지도
            if(pillList.get(i).getShape_info() == null) pillList.get(i).setShape_info("없음");
            if(pillList.get(i).getPacking_unit() == null) pillList.get(i).setPacking_unit("없음");
            if(pillList.get(i).getStoragint_method() == null) pillList.get(i).setStoragint_method("없음");
            if(pillList.get(i).getEfficacy() == null) pillList.get(i).setEfficacy("없음");
            if(pillList.get(i).getDosage() == null) pillList.get(i).setDosage("없음");
            if(pillList.get(i).getPrecaution() == null) pillList.get(i).setPrecaution("없음");
            if(pillList.get(i).getMedication_guide() == null) pillList.get(i).setMedication_guide("없음");

        }

        return pillList;

    }


    public Pill getById(int id) {
        return pillDao.getById(id);
    }

    public int getByLastId() {return pillDao.getByLastId();}

    public void insert(Pill pill) {
        pillDao.insert(pill);
    }

    public void update(Pill pill) {
        pillDao.update(pill);
    }

    public void delete(int id) {
        pillDao.delete(id);
    }





}
