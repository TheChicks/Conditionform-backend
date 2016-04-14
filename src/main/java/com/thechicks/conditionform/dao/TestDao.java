package com.thechicks.conditionform.dao;

import com.thechicks.conditionform.com.thechicks.conditionform.beans.Test;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Created by Leeseolhee on 2016. 4. 14..
 */
public class TestDao {

    @Autowired
    private JdbcTemplate template;


    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Test> findAll() {
        String query = "SELECT * FROM TEST";
        RowMapper<Test> mapper = new BeanPropertyRowMapper<Test>(Test.class);
        return this.template.query(query, mapper);
    }



}
