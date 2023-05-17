package com.odBinary.CarShow.service;

import com.odBinary.CarShow.entity.Owner;

import java.util.List;

public interface OwnerService {

    Owner getOwner(Long id);
    Owner getOwner(String firstName);
    List<Owner> getOwners();
    void deleteOwner(Long id);
    Owner saveOwner(Owner owner);
    Owner updateOwner(Long id, Owner owner);

//    List<Owner> getOwners();
//
//    Owner getOwnerById(Long id);
//
//    //update Owner by id
//    Owner updateOwner(Long id,Owner Owner);
//
//    //create a Owner
//    Owner saveOwner(Owner Owner);
//
//    //DEL
//    void deleteOwner(Long id);
}
