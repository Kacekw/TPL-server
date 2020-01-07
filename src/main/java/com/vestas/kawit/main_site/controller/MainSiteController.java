package com.vestas.kawit.main_site.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainSiteController {

    @GetMapping
    public String index(){
        return "<b><center>Test serwera tpl</b></center>";
    }
}
