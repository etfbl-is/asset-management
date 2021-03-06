package org.unibl.etf.is.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.is.am.models.entities.UserEntity;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsernameAndStatus(String username, UserEntity.Status status);

    Boolean existsByUsername(String username);

    Boolean existsByUsernameAndIdNot(String username, Integer id);
}
