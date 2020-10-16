package com.vestas.kawit.files_supplier.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Optional;

@Service
public class FileSupplierService {

    //TODO make a config file to store locations
    private String pathToScriptFile = "\\\\N56977\\ScriptSharedCatalog\\KawitScriptingEngine.vbs";
    private File scriptFile = new File(pathToScriptFile);

    public ResponseEntity<Resource> getFile() {
        Resource resource = new FileSystemResource(scriptFile);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    public ResponseEntity<Object> checkVersion() {
        Optional tmpRelease = releaseNumberOfLocalFile();
        if (tmpRelease.isPresent()){
            return new ResponseEntity<>(tmpRelease.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Release could not be found", HttpStatus.NOT_FOUND);
    }

    private Optional releaseNumberOfLocalFile() {
        Optional response = Optional.empty();
        try {
            BufferedReader br = new BufferedReader(new FileReader(scriptFile));
            String st;
            while ((st = br.readLine()) != null) {
                if (st.contains("release = ")) {
                    response = Optional.of(Integer.parseInt(st.replace("release = ", "")));
                    return response;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
