package org.unibl.etf.is.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.is.am.models.entities.AssetEntity;
import org.unibl.etf.is.am.models.AssetNameType;

import java.util.List;

public interface AssetEntityRepository extends JpaRepository<AssetEntity, Integer> {
    List<AssetEntity> getAllByLocation_Id(Integer id);

    @Query("SELECT new org.unibl.etf.is.am.models.AssetNameType(a.name,a.assetType.name) from AssetEntity a")
    List<AssetNameType> getAllNameTypes();
}
