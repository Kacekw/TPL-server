package com.vestas.kawit.main_site.controller;

import com.vestas.kawit.logger.service.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RequestMapping("/")
@Controller
public class MainSiteController {

    private final Logging logging;

    @Autowired
    public MainSiteController(Logging logging) {
        this.logging = logging;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.setViewName("index");
        return modelAndView; // resources/templates/index.html
    }

    //TODO make use of it someday
/*    public String getClientHostName(HttpServletRequest request){
        try{
            String clientAdress = request.getRemoteAddr();
            InetAddress inetAddress = InetAddress.getByName(clientAdress);
            return inetAddress.getHostName();
        }
        catch(UnknownHostException e){
            return e.getMessage();
        }
    }*/
}
