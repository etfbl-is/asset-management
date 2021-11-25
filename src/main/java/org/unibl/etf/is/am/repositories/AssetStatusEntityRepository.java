package org.unibl.etf.is.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.is.am.models.entities.AssetStatusEntity;

public interface AssetStatusEntityRepository extends JpaRepository<AssetStatusEntity,Integer> {
}