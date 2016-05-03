package com.thechicks.conditionform.dao;

import com.thechicks.conditionform.com.thechicks.conditionform.models.Pill;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 13..
 */

@Repository
public interface PillDao {


    @Select("SELECT * FROM PILL")
    List<Pill> findAll();

    @Select("SELECT * FROM PILL WHERE ko_name LIKE CONCAT('%',#{searchWord},'%') OR insurance_code LIKE CONCAT('%',#{searchWord},'%')")
    List<Pill> getPillInfomations(String searchWord);

    @Select("SELECT * FROM PILL WHERE ID = #{id}")
    Pill getPillInfomationById(int id);


    @Insert("INSERT INTO PILL (ko_name, en_name, image_url, ingredient, assortment, unitariness_or_complexness, manufacture_assortment," +
            "seller, formulation, taking_route, korea_food_and_drug_administration_category, insurance_code, combination_taboo, age_taboo, pregnant_taboo," +
            "old_man_caution, volume_and_treatment_period_caution, division_caution, blood_donation_prohibition, shape_info, packing_unit, storagint_method, efficacy, dosage, precaution, medication_guide) VALUES" +
            " (#{ko_name}, #{en_name}, #{image_url}, #{ingredient}, #{assortment}, #{unitariness_or_complexness}, #{manufacture_assortment}, #{seller}," +
            "#{formulation}, #{taking_route}, #{korea_food_and_drug_administration_category}, #{insurance_code}, #{combination_taboo}, #{age_taboo}, #{pregnant_taboo}, #{old_man_caution}, #{volume_and_treatment_period_caution}, #{division_caution}, #{blood_donation_prohibition}, #{shape_info}, #{packing_unit}, " +
            "#{storagint_method}, #{efficacy}, #{dosage}, #{precaution}, #{medication_guide})")
    void insertPill(Pill pill);


    @Update("UPDATE PILL SET ko_name = #{ko_name}, en_name = #{en_name}, image_url = #{image_url}, ingredient = #{ingredient}, assortment = #{assortment}, unitariness_or_complexness = #{unitariness_or_complexness}, manufacture_assortment = #{manufacture_assortment}," +
            "seller = #{seller}, formulation = #{formulation}, taking_route = #{taking_route}, korea_food_and_drug_administration_category = #{korea_food_and_drug_administration_category}, insurance_code = #{insurance_code}, combination_taboo = #{combination_taboo}, age_taboo = #{age_taboo}, pregnant_taboo = #{pregnant_taboo}, " +
            "old_man_caution = #{old_man_caution}, volume_and_treatment_period_caution = #{volume_and_treatment_period_caution}, division_caution = #{division_caution} , blood_donation_prohibition = #{blood_donation_prohibition}, shape_info = #{shape_info}," +
            "packing_unit = #{packing_unit}, storagint_method = #{storagint_method}, efficacy = #{efficacy}, dosage = #{dosage}, precaution = #{precaution}, medication_guide = #{medication_guide} WHERE ID = #{id}")
    void updatePill(Pill pill);

    @Delete("DELETE FROM PILL WHERE ID = #{id}")
    void deletePill(int id);
}
