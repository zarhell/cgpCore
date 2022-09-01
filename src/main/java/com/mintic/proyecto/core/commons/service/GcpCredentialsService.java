package com.mintic.proyecto.core.commons.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Service
public class GcpCredentialsService {

    private static final Logger logger = LoggerFactory.getLogger(GcpCredentialsService.class);
    
    public Storage getCredentialsStorage (String bucketName) throws FileNotFoundException, IOException{

        logger.info("Setting Credentials to bucket:::" + bucketName);

        Credentials credentials = GoogleCredentials
        .fromStream(new FileInputStream("src/main/resources/gcp-key.json"));
        
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials)
                .setProjectId(bucketName).build().getService();

        logger.debug("storage details" + storage.toString());
        
        return storage;
    }
}
