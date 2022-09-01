package com.mintic.proyecto.core.commons.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mintic.proyecto.core.commons.converter.DocumentalAreaConverter;
import com.mintic.proyecto.core.commons.converter.DocumentalDatesConverter;
import com.mintic.proyecto.core.commons.converter.DocumentalUserConverter;
import com.mintic.proyecto.core.search.domain.DocumentalLifeCycleDates;
import com.mintic.proyecto.core.search.domain.EnumCorrespondenceType;
import com.mintic.proyecto.core.search.domain.EnumDocumentPriority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="core_saved_document")
@JsonNaming(SnakeCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
public class CoreSavedDocument implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "documental_serial")
    private String documentalSerial;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private EnumDocumentType documentType;

    @Convert(converter = DocumentalAreaConverter.class)
    @Column(name = "document_area")
    private DocumentAreaDto documentArea;

    @Convert(converter = DocumentalUserConverter.class)
    @Column(name = "documental_user")
    private DocumentalUserDto documentalUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "correspondence_type")
    private EnumCorrespondenceType correspondenceType;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_priority")
    private EnumDocumentPriority documentPriority;

    @Column(name = "printed_tag")
    private String printedTag;

    @Convert(converter = DocumentalDatesConverter.class)
    @Column(name = "documental_dates")
    private DocumentalLifeCycleDates documentalDates;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "observations")
    private String observations;

    @Column(name = "storage_id")
    private Integer storageId;
    

}