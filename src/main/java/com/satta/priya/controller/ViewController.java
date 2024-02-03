package com.satta.priya.controller;

import com.satta.priya.model.Items;
import com.satta.priya.model.records;
import com.satta.priya.service.recordService;
import com.satta.priya.service.sattaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/satta")
public class ViewController {

    private final com.satta.priya.service.sattaService sattaService;
    private final  com.satta.priya.service.recordService recordService;

    @Autowired
    public ViewController(sattaService sattaService,recordService recordservice) {
        this.sattaService = sattaService;
        this.recordService = recordservice;
    }
    //@Autowired
    //public ViewController(recordsService recordsService) {
        //this.recordsService = recordsService;
    //}
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @GetMapping("/view")
    public String homepage(Model airModel) {
        List<Map<String, Object>> records = jdbcTemplate.queryForList("CALL GetItemRecords()");
        airModel.addAttribute("records", records);
        return "satta/home";
    }
}
