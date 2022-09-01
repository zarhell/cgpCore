package com.mintic.proyecto.core.commons.converter;

import javax.persistence.AttributeConverter;

import com.mintic.proyecto.core.commons.domain.DocumentAreaDto;
import com.mintic.proyecto.core.commons.service.Utils;

public class DocumentalAreaConverter implements AttributeConverter<DocumentAreaDto, String>{

    @Override
    public String convertToDatabaseColumn(DocumentAreaDto documentArea) {
        return Utils.serializeObject(documentArea);
    }

    @Override
    public DocumentAreaDto convertToEntityAttribute(String jsonArea) {
        return Utils.deserializeObject(jsonArea, DocumentAreaDto.class);
    }
    
}
