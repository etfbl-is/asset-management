package org.unibl.etf.is.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.is.am.exceptions.ConflictException;
import org.unibl.etf.is.am.exceptions.NotFoundException;
import org.unibl.etf.is.am.models.dto.User;
import org.unibl.etf.is.am.models.entities.LocationEntity;
import org.unibl.etf.is.am.models.entities.UserEntity;
import org.unibl.etf.is.am.services.LocationService;
import org.unibl.etf.is.am.services.SupervisorService;
import org.unibl.etf.is.am.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class SupervisorServiceImpl implements SupervisorService {

    private final LocationService locationService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public SupervisorServiceImpl(UserService userService, LocationService locationService, ModelMapper modelMapper) {
        this.userService = userService;
        this.locationService = locationService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void deleteSupervisor(Integer locationId, Integer userId) {
        UserEntity supervisor = userService.findById(userId, UserEntity.class);
        LocationEntity location = locationService.findById(locationId, LocationEntity.class);
        if (!location.getLocationSupervisors().contains(supervisor))
            throw new NotFoundException();
        location.getLocationSupervisors().remove(supervisor);
        locationService.update(locationId, location, LocationEntity.class);
    }

    @Override
    public void addSupervisor(Integer locationId, Integer userId) {
        LocationEntity location = locationService.findById(locationId, LocationEntity.class);
        List<UserEntity> supervisors = location.getLocationSupervisors();
        UserEntity supervisor = userService.findById(userId, UserEntity.class);
        if (supervisors.contains(supervisor))
            throw new ConflictException();
        supervisors.add(supervisor);
        location.setLocationSupervisors(supervisors);
        locationService.update(locationId, location, LocationEntity.class);
    }

    @Override
    public List<User> getAllByLocationId(Integer id) {
        LocationEntity location = locationService.findById(id, LocationEntity.class);
        return location.getLocationSupervisors().stream().map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
    }
}
