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
        return pillDao.getBySerchWord(searchWord);
    }

    public Pill getById(int id) {
        return pillDao.getById(id);
    }

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
