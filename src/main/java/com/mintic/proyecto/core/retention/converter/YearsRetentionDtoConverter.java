package com.mintic.proyecto.core.retention.converter;

import javax.persistence.AttributeConverter;

import com.mintic.proyecto.core.commons.service.Utils;
import com.mintic.proyecto.core.retention.domain.YearsRetentionDto;

public class YearsRetentionDtoConverter implements AttributeConverter<YearsRetentionDto, String>{

    @Override
    public String convertToDatabaseColumn(YearsRetentionDto yearsRetention) {
        return Utils.serializeObject(yearsRetention);
    }

    @Override
    public YearsRetentionDto convertToEntityAttribute(String jsonConfig) {
        return Utils.deserializeObject(jsonConfig, YearsRetentionDto.class);
    }
    
}
