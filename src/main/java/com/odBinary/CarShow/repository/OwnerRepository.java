package com.odBinary.CarShow.repository;

import com.odBinary.CarShow.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Optional<Object> findOwnerByFirstName(String firstName);
}