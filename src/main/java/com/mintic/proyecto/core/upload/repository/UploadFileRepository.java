package com.mintic.proyecto.core.upload.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mintic.proyecto.core.commons.domain.CoreSavedDocument;

@Repository
public interface UploadFileRepository extends JpaRepository<CoreSavedDocument, Integer>{

    
    @Query(value = "SELECT c FROM CoreSavedDocument c WHERE c.documentalSerial = ?1")
    Optional<CoreSavedDocument> findByDocumentalSerial(String serial);

    @Query(value = "SELECT c FROM CoreSavedDocument c WHERE c.storageId = ?1")
    Optional<CoreSavedDocument> findByStorageId(Integer storageId);

    
    
}
