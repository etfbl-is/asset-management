package org.unibl.etf.is.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.is.am.models.Location;
import org.unibl.etf.is.am.models.SingleLocation;
import org.unibl.etf.is.am.services.LocationService;
import org.unibl.etf.is.am.exceptions.NotFoundException;
import org.unibl.etf.is.am.repositories.LocationEntityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final ModelMapper modelMapper;

    private final LocationEntityRepository repository;

    public LocationServiceImpl(LocationEntityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Location> findAll() {
        return repository.findAll().stream().map(l->modelMapper.map(l,Location.class)).collect(Collectors.toList());
    }

    @Override
    public SingleLocation findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new),SingleLocation.class);
    }
}
