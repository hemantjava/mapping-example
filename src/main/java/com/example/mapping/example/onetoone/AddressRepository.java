package com.example.mapping.example.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    //Projection partial date
    @Query("SELECT location FROM Address")
    List<String> getName();
}
