package com.mintic.proyecto.core.retention.domain;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mintic.proyecto.core.retention.converter.OrganitationConverter;
import com.mintic.proyecto.core.retention.converter.SpecificationFeaturesConverter;
import com.mintic.proyecto.core.retention.converter.YearsRetentionDtoConverter;

import lombok.Data;

@Data
@Entity
@Table(name="core_documental_retention")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoreDocumentalRetention {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Convert(converter = OrganitationConverter.class)
    @Column(name = "organitation")
    private OrganitationDto  organitation;

    @Column(name = "dependency_code")
    private String dependencyCode;

    @Convert(converter = SpecificationFeaturesConverter.class)
    @Column(name = "specification_features")
    private SpecificationFeaturesDto specificationFeatures;

    @Convert(converter = YearsRetentionDtoConverter.class)
    @Column(name = "years_retention")
    private YearsRetentionDto yearsRetention;

    @Column(name = "support_type")
    @Enumerated(EnumType.STRING)
    private EnumSupportType supportType;

    @Column(name = "final_disposition")
    @Enumerated(EnumType.STRING)
    private EnumFinalDisposition finalDisposition;

    @Column(name = "procedure")
    private String procedure;

   
}
