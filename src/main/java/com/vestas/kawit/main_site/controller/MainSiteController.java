package com.vestas.kawit.main_site.controller;

import com.vestas.kawit.logger.service.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/")
public class MainSiteController {

    private final Logging logging;

    @Autowired
    public MainSiteController(Logging logging) {
        this.logging = logging;
    }

    @GetMapping
    public String index(HttpServletRequest request){
        System.out.println(getClientHostName(request));
        return "<b><center>Test serwera tpl</b></center>";
    }

    public String getClientHostName(HttpServletRequest request){
        try{
            String clientAdress = request.getRemoteAddr();
            InetAddress inetAddress = InetAddress.getByName(clientAdress);
            return inetAddress.getHostName();
        }
        catch(UnknownHostException e){
            return e.getMessage();
        }
    }
}
