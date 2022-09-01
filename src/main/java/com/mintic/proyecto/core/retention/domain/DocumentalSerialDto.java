package com.mintic.proyecto.core.retention.domain;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class DocumentalSerialDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String subSerial;

    private String documentalTypes;

}
