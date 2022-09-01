package com.mintic.proyecto.core.commons.converter;

import javax.persistence.AttributeConverter;

import com.mintic.proyecto.core.commons.domain.DocumentalUserDto;
import com.mintic.proyecto.core.commons.service.Utils;

public class DocumentalUserConverter implements AttributeConverter<DocumentalUserDto, String>{

    @Override
    public String convertToDatabaseColumn(DocumentalUserDto documentalUser) {
        return Utils.serializeObject(documentalUser);
    }

    @Override
    public DocumentalUserDto convertToEntityAttribute(String jsonUser) {
        return Utils.deserializeObject(jsonUser, DocumentalUserDto.class);
    }
    
}
