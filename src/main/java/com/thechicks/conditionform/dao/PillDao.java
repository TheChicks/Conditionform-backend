package com.thechicks.conditionform.dao;

import com.thechicks.conditionform.com.thechicks.conditionform.beans.Pill;
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

    @Select("SELECT * FROM PILL WHERE medi_ko_name LIKE  CONCAT('%',#{mediName},'%')")
    List<Pill> getPillInfomationsByName(String mediName);

    @Select("SELECT * FROM PILL WHERE insurance_code LIKE CONCAT('%',#{insuranceCode},'%')")
    List<Pill> getPillInfomationsByInsuranceCode(String insuranceCode);


    @Insert("INSERT INTO PILL (medi_ko_name, medi_en_name, link, image_url, category_welfare, assortment, manufacture_assort, manufacture_assort_manufacturer," +
            "insurance_code, pregnant_rating, age_prohibit, shape_info_appearance, shape_info_formulation, shape_info_shape, shape_info_color, shape_info_idmark," +
            "ingredient_info, storagint_method, efficacy, dosage, precaution) VALUES (#{medi_ko_name}, #{medi_en_name}, #{link}, #{image_url}, #{category_welfare}, #{assortment}, #{manufacture_assort}, #{manufacture_assort_manufacturer}," +
            "#{insurance_code}, #{pregnant_rating}, #{age_prohibit}, #{shape_info_appearance}, #{shape_info_formulation}, #{shape_info_shape}, #{shape_info_color}, #{shape_info_idmark}, #{ingredient_info}, #{storagint_method}, #{efficacy}, #{dosage}, #{precaution})")
    void insertPill(Pill pill);


    @Update("UPDATE PILL SET medi_ko_name = #{medi_ko_name}, medi_en_name = #{medi_en_name}, link = #{link}, image_url = #{image_url}, category_welfare = #{category_welfare}, assortment = #{assortment}, manufacture_assort = #{manufacture_assort}, manufacture_assort_manufacturer = #{manufacture_assort_manufacturer}," +
            "insurance_code = #{insurance_code}, pregnant_rating = #{pregnant_rating}, age_prohibit = #{age_prohibit}, shape_info_appearance = #{shape_info_appearance}, shape_info_formulation = #{shape_info_formulation}, shape_info_shape = #{shape_info_shape}, shape_info_color = #{shape_info_color}, shape_info_idmark = #{shape_info_idmark}, " +
            "ingredient_info = #{ingredient_info}, storagint_method = #{storagint_method}, efficacy = #{efficacy} , dosage = #{dosage}, precaution = #{precaution} WHERE ID = #{id}")
    void updatePill(Pill pill);

    @Delete("DELETE FROM PILL WHERE ID = #{updateId}")
    void deletePill(int updateId);


}
