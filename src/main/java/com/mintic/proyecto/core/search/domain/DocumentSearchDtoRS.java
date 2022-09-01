package com.mintic.proyecto.core.search.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mintic.proyecto.core.commons.domain.DocumentAreaDto;
import com.mintic.proyecto.core.commons.domain.DocumentalUserDto;
import com.mintic.proyecto.core.commons.domain.EnumDocumentType;

import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class DocumentSearchDtoRS implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime documentalCreateDate;

    private String documentalSerial;

    private EnumDocumentType documentType;

    private DocumentAreaDto documentArea;

    private DocumentalUserDto userLocation;

    private EnumCorrespondenceType correspondenceType;

    private String UserName;

    
}
