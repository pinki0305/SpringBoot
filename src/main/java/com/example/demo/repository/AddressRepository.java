package com.example.demo.repository;

import com.example.demo.entitites.Address;
import com.example.demo.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer>
{

    Address findById(int id);
}
