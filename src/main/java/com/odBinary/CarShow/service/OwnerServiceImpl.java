package com.odBinary.CarShow.service;

import com.odBinary.CarShow.entity.Owner;
import com.odBinary.CarShow.exception.ResourceNotFoundException;
import com.odBinary.CarShow.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;


    @Override
    public Owner getOwner(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id: " + id));
    }

    @Override
    public Owner getOwner(String firstName) {
        return (Owner) ownerRepository.findOwnerByFirstName(firstName)
                .orElseThrow(()->new ResourceNotFoundException("Owner not found with name "+firstName));
    }

    @Override
    public List<Owner> getOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner saveOwner(Owner owner) {
        return  ownerRepository.save(owner);
    }

    @Override
    public Owner updateOwner(Long id, Owner owner) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if(optionalOwner.isPresent()){
//            optionalOwner.get().setOwnerId(id);
            optionalOwner.get().setFirstName(owner.getFirstName());
            optionalOwner.get().setLastName(owner.getLastName());
            return ownerRepository.save(optionalOwner.get());
        }else throw  new ResourceNotFoundException("Owner not found with id: " + id);

    }



    /////////////
//    @Override
//    public List<Owner> getOwners() {
//        return (List<Owner>) OwnerRepository.findAll();
//    }
//
//    @Override
//    public Owner getOwnerById(Long id) { Optional<Owner> OwnerPicked = OwnerRepository.findById(id);
//        if (OwnerPicked.isPresent()){
//            return OwnerPicked.get();
//        } else {
//            throw new ResourceNotFoundException("Owner with " +id + " is absent!, call in the sub?!");
//        }
//    }
//
//    @Override
//    public Owner updateOwner(Long id, Owner Owner) {
//        Optional<Owner>optionalOwner = OwnerRepository.findById(id);
//        if(optionalOwner.isPresent()){
//            optionalOwner.get().setOwnerId(Owner.getOwnerId());
//            optionalOwner.get().setFirstName(Owner.getFirstName());
//            optionalOwner.get().setLastName(Owner.getLastName());
//            return OwnerRepository.save(optionalOwner.get());
//
//        }else {
//            throw new ResourceNotFoundException("Owner with " +id + " is absent! Call principle!");
//        }
//    }
//
//    @Override
//    public Owner saveOwner(Owner Owner) {
//        return OwnerRepository.save(Owner);
//    }
//    @Override
//    public void deleteOwner(Long id) {
//        OwnerRepository.deleteById(id);
//    }
//

}
