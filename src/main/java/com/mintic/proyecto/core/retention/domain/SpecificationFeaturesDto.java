package com.mintic.proyecto.core.retention.domain;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class SpecificationFeaturesDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer code;

    private Integer subCode;

    private DocumentalSerialDto coreDocumentalSerial;

   
}
