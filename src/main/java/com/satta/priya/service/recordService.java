package com.satta.priya.service;

import com.satta.priya.dao.recordDao;
import com.satta.priya.model.records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class recordService {
    @Autowired
    recordDao recorddao;


    public List<records> allRecords() {
        return recorddao.findAll();
    }

    public void save(records therecord) {
        recorddao.save(therecord);
    }

//    public records findBySid(Integer sid) {
//        Optional<records> optionalRecords = recorddao.findBySid(sid);
//        return optionalRecords.orElse(null);
//    }


}
