package com.mintic.proyecto.core.upload.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.mintic.proyecto.core.commons.request.DocumentUploadBD;

public interface UploadFileService {

    public DocumentUploadBD uploadFilesRS(String documentalSerial, MultipartFile file, String requestBody) throws FileNotFoundException, IOException;
    
}
