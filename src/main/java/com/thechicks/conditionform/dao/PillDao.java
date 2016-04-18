package com.thechicks.conditionform.dao;

import com.thechicks.conditionform.com.thechicks.conditionform.beans.Pill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 13..
 */


public interface PillDao {


    @Select("SELECT * FROM PILL")
    List<Pill> findAll();

    @Select("SELECT * FROM PILL WHERE medi_ko_name LIKE  CONCAT('%',#{mediName},'%')")
    List<Pill> getPillInfomationsByName(String mediName);

    @Select("SELECT * FROM PILL WHERE insurance_code LIKE CONCAT('%',#{insuranceCode},'%')")
    List<Pill> getPillInfomationsByInsuranceCode(String insuranceCode);

}
