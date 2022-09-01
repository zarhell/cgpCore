package com.mintic.proyecto.core.upload.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.mintic.proyecto.core.commons.constans.ConstansCore;
import com.mintic.proyecto.core.commons.domain.CoreSavedDocument;
import com.mintic.proyecto.core.commons.request.DocumentUploadBD;
import com.mintic.proyecto.core.commons.service.GcpCredentialsService;
import com.mintic.proyecto.core.commons.service.Utils;
import com.mintic.proyecto.core.upload.repository.UploadFileRepository;

@Service
public class UploadFileServiceImpl implements UploadFileService{

    private static final Logger logger = LoggerFactory.getLogger(UploadFileServiceImpl.class);

   
    private UploadFileRepository repository; 
    
    
    private GcpCredentialsService gcpCredentials;

        
    public UploadFileServiceImpl(UploadFileRepository repository, GcpCredentialsService gcpCredentials) {
        this.repository = repository;
        this.gcpCredentials = gcpCredentials;
    }

    @Override
    public DocumentUploadBD uploadFilesRS(String documentalSerial, MultipartFile file, String requestBody) throws FileNotFoundException, IOException {

               
        CoreSavedDocument documentToProcess = repository.findByDocumentalSerial(documentalSerial).orElse(new CoreSavedDocument());


        DocumentUploadBD document = Utils.deserializeObject(requestBody, DocumentUploadBD.class);
            
        BeanUtils.copyProperties(document.getDocumentProperties(), documentToProcess);

        Storage storage = gcpCredentials.getCredentialsStorage(ConstansCore.BUCKET_NAME);

        BlobId blobId = getBucketIdToSave(file, documentToProcess);

        BlobInfo info = BlobInfo.newBuilder(blobId).build();
        storage.create(info, file.getBytes());

        Blob blobRetrieved = storage.get(blobId);

        String retrievedBloidId = blobRetrieved.getGeneratedId().split("/")[2];
        Long generation = Long.parseLong(retrievedBloidId); 
        
        Integer storageId = Math.abs(generation.intValue());

     
        documentToProcess.setStorageId(storageId);
        documentToProcess.setDocumentalSerial(documentalSerial);
        documentToProcess.setDocumentName(file.getOriginalFilename());
        repository.save(documentToProcess);
         
  
        BeanUtils.copyProperties(documentToProcess, document);

        document.setExtraProps("documental_serial", documentalSerial);
        document.setExtraProps("documental_storage_id", documentToProcess.getStorageId());

        logger.info("End upload file. Name: [{}], Content-Tyle: [{}]", file.getOriginalFilename(), file.getContentType());
        
        return document;
    }

    private BlobId getBucketIdToSave(MultipartFile file, CoreSavedDocument documentToProcess) {
        if (Objects.nonNull(documentToProcess.getStorageId())) {
                          
           return  BlobId.of(
                ConstansCore.BUCKET_NAME, "ver " + 
                documentToProcess.getStorageId() + 
                1 + " " + 
                file.getOriginalFilename());

        }

        return BlobId.of(ConstansCore.BUCKET_NAME, file.getOriginalFilename());

    }

}