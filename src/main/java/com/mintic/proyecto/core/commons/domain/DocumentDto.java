package com.mintic.proyecto.core.commons.domain;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mintic.proyecto.core.search.domain.DocumentalLifeCycleDates;
import com.mintic.proyecto.core.search.domain.EnumCorrespondenceType;
import com.mintic.proyecto.core.search.domain.EnumDocumentPriority;

import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class DocumentDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private EnumDocumentType documentType;

    private DocumentAreaDto documentArea;

    private DocumentalUserDto documentalUser;

    private EnumCorrespondenceType correspondenceType;

    private EnumDocumentPriority documentPriority;

    private String printedTag;

    private DocumentalLifeCycleDates documentalDates;

    private String documentName;

    private String observations;

}
