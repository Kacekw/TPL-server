/*
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

    */
/**
 * MOMs Controller purpose is to download a file containing PowerPoint presentation and run it on a screen, as the application runs on a local
 * computer connected to big screen, one of it's purposes is to display .pptx presentations with wide spectre of statistics, metering etc.
 * <p>
 * Unlike the client application, there is no need to provide mechanisms of deploying and loading libraries that make it possible to connect to windows ROT tables.
 * Application is started once by the administrator on a previously prepared machine.
 *//*


    private final MomsUploadingService momsUploadingService;

    @Autowired
    public MomsController(MomsUploadingService momsUploadingService) {
        this.momsUploadingService = momsUploadingService;
    }

    @GetMapping
    public ModelAndView upload() {
        return momsUploadingService.upload();
    }

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        momsUploadingService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message", String.format("File %s succesfully updated!", file.getOriginalFilename()));

        return "redirect:/moms"; //redirects to the same page with FlashAttribute set
    }

}
*/
