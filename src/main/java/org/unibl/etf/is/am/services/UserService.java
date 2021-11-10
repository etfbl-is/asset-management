package org.unibl.etf.is.am.services;

import org.springframework.stereotype.Service;
import org.unibl.etf.is.am.models.User;
import org.unibl.etf.is.am.repositories.UserDAO;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;


    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }
}
