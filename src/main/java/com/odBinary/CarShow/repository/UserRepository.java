package com.odBinary.CarShow.repository;

import com.odBinary.CarShow.entity.Owner;
import com.odBinary.CarShow.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
}