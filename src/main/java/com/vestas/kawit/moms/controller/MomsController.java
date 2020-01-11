package com.vestas.kawit.moms.controller;

import com.vestas.kawit.moms.service.MomsUploadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/moms")
public class MomsController {

    private final MomsUploadingService momsUploadingService;

    @Autowired
    public MomsController(MomsUploadingService momsUploadingService) {
        this.momsUploadingService = momsUploadingService;
    }

    @GetMapping
    public ModelAndView upload(){
        return momsUploadingService.upload();
    }

    @PostMapping
    public String uploadFile(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
        momsUploadingService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message", String.format("File %s succesfully updated!", file.getOriginalFilename()));

        return "redirect:/moms"; //redirects to the same page with FlashAttribute set
    }

}
