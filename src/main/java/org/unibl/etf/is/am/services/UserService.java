package org.unibl.etf.is.am.services;

import org.unibl.etf.is.am.base.CrudService;
import org.unibl.etf.is.am.models.dto.User;
import org.unibl.etf.is.am.models.requests.ChangeRoleRequest;
import org.unibl.etf.is.am.models.requests.ChangeStatusRequest;
import org.unibl.etf.is.am.models.requests.SignUpRequest;
import org.unibl.etf.is.am.models.requests.UserUpdateRequest;

public interface UserService extends CrudService<Integer> {
    void signUp(SignUpRequest request);

    void changeStatus(Integer userId, ChangeStatusRequest request);

    void changeRole(Integer userId, ChangeRoleRequest request);

    User update(Integer id, UserUpdateRequest user);
}
