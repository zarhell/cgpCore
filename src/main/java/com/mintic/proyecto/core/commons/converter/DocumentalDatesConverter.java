package com.mintic.proyecto.core.commons.converter;

import javax.persistence.AttributeConverter;

import com.mintic.proyecto.core.commons.service.Utils;
import com.mintic.proyecto.core.search.domain.DocumentalLifeCycleDates;

public class DocumentalDatesConverter implements AttributeConverter<DocumentalLifeCycleDates, String>{

    @Override
    public String convertToDatabaseColumn(DocumentalLifeCycleDates documentDates) {
        return Utils.serializeObject(documentDates);
    }

    @Override
    public DocumentalLifeCycleDates convertToEntityAttribute(String jsonDates) {
        return Utils.deserializeObject(jsonDates, DocumentalLifeCycleDates.class);
    }
    
}
