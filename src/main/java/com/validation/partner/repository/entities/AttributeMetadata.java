package com.validation.partner.repository.entities;

import com.validation.component.domain.FieldMeta;
import com.validation.partner.domain.enums.AttributeEntityType;
import com.validation.partner.domain.enums.AttributeType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "attributes_metadata")
public class AttributeMetadata implements FieldMeta {
    private String code;
    private AttributeType type;
    private AttributeEntityType entityType;
    private boolean required;
    private int minimum;
    private int maximum;
}
