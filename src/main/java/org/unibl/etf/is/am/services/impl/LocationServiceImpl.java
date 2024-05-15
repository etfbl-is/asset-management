package org.unibl.etf.is.am.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.is.am.base.CrudJpaService;
import org.unibl.etf.is.am.models.entities.LocationEntity;
import org.unibl.etf.is.am.repositories.LocationEntityRepository;
import org.unibl.etf.is.am.services.LocationService;

@Service
@Transactional
public class LocationServiceImpl extends CrudJpaService<LocationEntity, Integer> implements LocationService {

    public LocationServiceImpl(LocationEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, LocationEntity.class);
    }
}
