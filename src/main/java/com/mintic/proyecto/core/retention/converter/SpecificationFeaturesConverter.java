package com.mintic.proyecto.core.retention.converter;

import javax.persistence.AttributeConverter;

import com.mintic.proyecto.core.commons.service.Utils;
import com.mintic.proyecto.core.retention.domain.SpecificationFeaturesDto;

public class SpecificationFeaturesConverter implements AttributeConverter<SpecificationFeaturesDto, String>{

    @Override
    public String convertToDatabaseColumn(SpecificationFeaturesDto specificationFeatures) {
        return Utils.serializeObject(specificationFeatures);
    }

    @Override
    public SpecificationFeaturesDto convertToEntityAttribute(String jsonConfig) {
        return Utils.deserializeObject(jsonConfig, SpecificationFeaturesDto.class);
    }
    
}
