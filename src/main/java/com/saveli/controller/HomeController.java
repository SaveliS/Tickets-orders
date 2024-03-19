package com.saveli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saveli.service.CustomerService;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("allUserList", customerService.getAllCustomer());
        System.out.println("Couter user: " + customerService.getAllCustomer().iterator().hasNext());
        return "start";
    }
}
