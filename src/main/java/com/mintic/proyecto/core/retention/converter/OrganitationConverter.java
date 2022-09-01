package com.mintic.proyecto.core.retention.converter;

import javax.persistence.AttributeConverter;

import com.mintic.proyecto.core.commons.service.Utils;
import com.mintic.proyecto.core.retention.domain.OrganitationDto;

public class OrganitationConverter implements AttributeConverter<OrganitationDto, String>{

    @Override
    public String convertToDatabaseColumn(OrganitationDto organitation) {
        return Utils.serializeObject(organitation);
    }

    @Override
    public OrganitationDto convertToEntityAttribute(String jsonConfig) {
        return Utils.deserializeObject(jsonConfig, OrganitationDto.class);
    }
    
}
