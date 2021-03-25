package com.validation.partner.repository;

import com.validation.partner.domain.Partner;
import org.springframework.data.repository.CrudRepository;

public interface PartnerRepository extends CrudRepository<Partner, Long> {
}
