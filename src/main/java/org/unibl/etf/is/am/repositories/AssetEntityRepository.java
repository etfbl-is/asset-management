package org.unibl.etf.is.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.is.am.models.entities.AssetEntity;

public interface AssetEntityRepository extends JpaRepository<AssetEntity, Integer> {
}
