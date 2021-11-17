package org.unibl.etf.is.am.services;

import org.unibl.etf.is.am.models.Location;
import org.unibl.etf.is.am.models.SingleLocation;
import org.unibl.etf.is.am.exceptions.NotFoundException;

import java.util.List;

public interface LocationService {
    List<Location> findAll();
    SingleLocation findById(Integer id) throws NotFoundException;
}
