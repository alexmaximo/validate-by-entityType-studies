package com.validation.partner.repository;

import com.validation.partner.repository.entities.AttributeMetadata;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttributesMetadaRepository extends CrudRepository<AttributeMetadata, Long> {
    List<AttributeMetadata> findByModel(String model);
}
