package com.mintic.proyecto.core.commons.domain;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class DocumentAreaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String originalAreaCode;

    private String destinationAreaCode;

    private String areaName;

    
}
