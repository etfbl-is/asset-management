package org.unibl.etf.is.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.is.am.models.entities.LocationEntity;

public interface LocationEntityRepository extends JpaRepository<LocationEntity, Integer> {
}
