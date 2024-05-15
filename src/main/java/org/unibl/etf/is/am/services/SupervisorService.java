package org.unibl.etf.is.am.services;

import org.unibl.etf.is.am.models.dto.User;

import java.util.List;

public interface SupervisorService {
    void deleteSupervisor(Integer locationId, Integer userId);

    void addSupervisor(Integer locationId, Integer userId);

    List<User> getAllByLocationId(Integer id);
}
