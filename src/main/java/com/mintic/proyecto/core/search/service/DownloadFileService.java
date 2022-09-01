package com.mintic.proyecto.core.search.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.mintic.proyecto.core.search.domain.DocumentFetchDtoRS;

public interface DownloadFileService {

    public DocumentFetchDtoRS fetchDocument(Integer storageId, String userLendCode) 
        throws FileNotFoundException, IOException;
    
} 