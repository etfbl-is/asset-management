package org.unibl.etf.is.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.is.am.models.entities.AssetTypeEntity;

public interface AssetTypeEntityRepository extends JpaRepository<AssetTypeEntity, Integer> {
    Boolean existsByName(String name);

    Boolean existsByNameAndIdNot(String name, Integer id);
}
