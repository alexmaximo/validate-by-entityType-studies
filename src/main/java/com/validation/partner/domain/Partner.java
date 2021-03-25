package com.validation.partner.domain;

import lombok.Data;

import java.util.List;

@Data
public class Partner {
    private String model;
    private List<AttributeValue> attributeValueList;
    private List<Brand> brandList;
    private List<Contributors> contributorsList;
}
