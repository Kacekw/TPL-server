package com.vestas.kawit.moms.service;

import com.vestas.kawit.windows_layer.power_point.PowerPointLayer;
import com.vestas.kawit.web_error_handler.exceptions.FileStorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class MomsUploadingService {

    private final PowerPointLayer powerPointLayer = new PowerPointLayer();

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    public ModelAndView upload(){
        ModelAndView uploadModelView = new ModelAndView("Upload");
        uploadModelView.setViewName("moms/upload");
        return uploadModelView;
    }

    public void uploadFile(MultipartFile file) {
        try{
            Path fileLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), fileLocation, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(fileLocation.toString());
            powerPointLayer.runPresentation(fileLocation.toString());
        }catch (Exception e){
            e.printStackTrace();
            throw new FileStorageException(String.format("%s %s. %s", "Could not upload the file", file.getOriginalFilename(), "Try again."));
        }
    }
}
