package com.vestas.kawit.files_supplier.controller;


import com.vestas.kawit.files_supplier.service.FileSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/files")
@Controller
public class FileSupplierController {

    private FileSupplierService fileSupplierService;

    @Autowired
    public FileSupplierController(FileSupplierService fileSupplierService) {
        this.fileSupplierService = fileSupplierService;
    }

    @GetMapping(value = "/scripting/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getFile() {
        return fileSupplierService.getFile();
    }
}
