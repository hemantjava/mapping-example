package com.example.mapping.example;

import com.example.mapping.example.onetoone.Address;
import com.example.mapping.example.onetoone.AddressRepository;
import com.example.mapping.example.onetoone.Library;
import com.example.mapping.example.onetoone.LibraryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Log4j2
@SpringBootApplication
public class MappingExampleApplication implements CommandLineRunner {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(MappingExampleApplication.class, args);
    }

    void save() {

        final Address address = Address.builder()
                .location("BLR")
                .build();

        final Library library = Library.builder()
                .name("java")
                .address(address)
                .build();
        final Library save = libraryRepository.save(library);
        log.info(save);
    }

    void findAll() {
        List<Address> all = addressRepository.findAll();
        log.info(all);

    }


    @Override
    public void run(String... args) throws Exception {
        save();
        findAll();
    }
}
