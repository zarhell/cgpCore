package com.mintic.proyecto.core.Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mintic.proyecto.core.commons.request.DocumentUploadBD;
import com.mintic.proyecto.core.commons.service.Utils;
import com.mintic.proyecto.core.search.domain.DocumentFetchDtoRS;
import com.mintic.proyecto.core.search.service.DownloadFileService;
import com.mintic.proyecto.core.upload.service.UploadFileService;



@RestController
@RequestMapping("/api/document")
public class DocumentStorageController {

        private static final Logger logger = LoggerFactory.getLogger(DocumentStorageController.class);

        @Autowired
        UploadFileService uploadFileService;

        @Autowired
        DownloadFileService downloadFileService;

        @PutMapping(value = "{id}")
        public ResponseEntity<DocumentUploadBD> documentUpload(
                        @PathVariable("id") String documentalSerial,
                        @RequestParam("file") MultipartFile file,
                        @RequestParam("request_body") String requestBody
                        ) throws FileNotFoundException, IOException {

                logger.info("Begin upload file.");
                
                return new ResponseEntity<>(uploadFileService.uploadFilesRS(documentalSerial, file, requestBody), HttpStatus.OK);

        }

        @GetMapping()
        public ResponseEntity<byte[]> documetDownload(
                        @RequestParam ("storage_id") Integer storageId, 
                        @RequestParam ("user_lend_code") String userLendCode) 
                        throws FileNotFoundException, IOException{

                logger.info("Begin download file.");

                DocumentFetchDtoRS documentFetch = downloadFileService.fetchDocument(storageId, userLendCode);

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData(documentFetch.getDocumentName(), documentFetch.getDocumentName());
                headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
                

          return new ResponseEntity<>(Utils.decodeToBase64(documentFetch.getInputStream()), headers, HttpStatus.OK);    
        }

       

}
