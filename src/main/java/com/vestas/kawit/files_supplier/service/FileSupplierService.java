package com.vestas.kawit.files_supplier.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileSupplierService {

    //TODO make a config file to store locations

    public ResponseEntity<Resource> getFile() {
        String pathToYDriveFile = "\\\\DKRDSDFSROOT10\\Data\\_WFS\\PL_SDC_TPL\\SAP manuale i skrypty\\KAWIT\\KawitScriptingEngine.vbs";
        File fileOnYDrive = new File(pathToYDriveFile);
        Resource resource = new FileSystemResource(fileOnYDrive);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
