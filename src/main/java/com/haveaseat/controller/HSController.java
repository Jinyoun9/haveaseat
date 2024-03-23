package com.haveaseat.controller;

import com.haveaseat.entity.Resstatus;
import com.haveaseat.service.HSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class HSController {

    @Autowired
    private HSService hsService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("restaurantlist", hsService.restaurantList());
        model.addAttribute("rstatuslist", hsService.restaurantstatusList());
        return "index";
    }
    @GetMapping("/checkin")
    public String checkin(Model model){
        model.addAttribute("restaurantlist", hsService.restaurantList());
        model.addAttribute("rstatuslist", hsService.restaurantstatusList());
        return "checkin";
    }
    @PostMapping("/checkinpro/{id}")
    public String checkinPro(@PathVariable("id")int id, Resstatus resstatus, Model model) throws IOException {
            Resstatus rsTemp = hsService.rstatusView(id);
            hsService.write(rsTemp);
            model.addAttribute("message", "좌석이 추가되었습니다.");
            model.addAttribute("destUrl", "/index");
            return "message";
    }
}
