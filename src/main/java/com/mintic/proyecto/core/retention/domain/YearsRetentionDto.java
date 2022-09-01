package com.mintic.proyecto.core.retention.domain;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class YearsRetentionDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer fileManagement;

    private Integer fileCentral;
    
}
