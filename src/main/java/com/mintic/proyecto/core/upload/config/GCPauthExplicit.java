package com.mintic.proyecto.core.upload.config;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class GCPauthExplicit {

    static void authExplicit(String jsonPath) throws IOException {
    
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("gcp-key.json"));;
              
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
      
        System.out.println("Buckets:");
        Page<Bucket> buckets = storage.list();
        for (Bucket bucket : buckets.iterateAll()) {
          System.out.println(bucket.toString());
        }
      }
    
}
