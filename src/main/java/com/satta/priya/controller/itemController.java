package com.satta.priya.controller;

import com.satta.priya.model.Items;
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
@RequestMapping("/satta")
public class itemController {
    @Autowired
    sattaService sattaService;
    @GetMapping("/all")
    public String listSatta(Model theModel){
        List<Items> thesatta=sattaService.getAllSatta();
        theModel.addAttribute("satta",thesatta);
        return "satta/sattaList";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Items sattaitem=new Items();
        theModel.addAttribute("satta",sattaitem);
        return "satta/satta-form";
    }
    @PostMapping("/save")
    public String savesatta(@ModelAttribute("satta") Items thesatta){
        sattaService.save(thesatta);
        return "redirect:/satta/all";
    }
}
