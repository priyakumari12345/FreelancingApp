package com.satta.priya.service;

import com.satta.priya.dao.sattaDao;
import com.satta.priya.model.Items;
import com.satta.priya.model.records;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sattaService {
    @Autowired
    sattaDao sattaDao;

    public List<Items> getAllSatta(){
        return sattaDao.findAll();
    }

    public void save(Items thesatta) {
        sattaDao.save(thesatta);
    }

}
