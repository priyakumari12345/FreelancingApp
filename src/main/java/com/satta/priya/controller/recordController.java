package com.satta.priya.controller;

import com.satta.priya.model.Items;
import com.satta.priya.model.records;
import com.satta.priya.service.recordService;
import com.satta.priya.service.sattaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/records")
public class recordController {
    @Autowired
    recordService recordservice;

    private final sattaService sattaService;

    @Autowired
    public recordController(sattaService sattaService) {
        this.sattaService = sattaService;
    }

    @GetMapping("/all")
    public String allRecords(Model theModel){
        List<records> therecords=recordservice.allRecords();
        theModel.addAttribute("records",therecords);
        return "satta/records-list";
    }
    @GetMapping("/FormToAddRecords")
    public String FormToAddRecords(Model theModel,Model secondModel){
        List<Items> thesatta=sattaService.getAllSatta();
        theModel.addAttribute("sattarecords",thesatta);
        records therecord=new records();
        secondModel.addAttribute("records",therecord);
        return "satta/records-form";
    }
    @PostMapping("/save")
    public String saverecords(@ModelAttribute("records") records therecord) {
        //records existingRecord = recordservice.findBySid(therecord.getSid());


        recordservice.save(therecord);

        return "redirect:/records/all";
    }

}
