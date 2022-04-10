package com.kaminski.demoapi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RateSearchRepository extends JpaRepository<RateSearch, Integer> {
}
