package com.mintic.proyecto.core.search.domain;

import java.io.InputStream;
import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class DocumentFetchDtoRS implements Serializable {

    private static final long serialVersionUID = 1L;

    private String inputStream;

    private String documentName;

    
}
