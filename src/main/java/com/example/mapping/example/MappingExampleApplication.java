package com.example.mapping.example;

import com.example.mapping.example.onetomany.Book;
import com.example.mapping.example.onetomany.BookRepository;
import com.example.mapping.example.onetoone.Address;
import com.example.mapping.example.onetoone.AddressRepository;
import com.example.mapping.example.onetoone.Library;
import com.example.mapping.example.onetoone.LibraryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@Log4j2
@SpringBootApplication
public class MappingExampleApplication implements CommandLineRunner {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BookRepository bookRepository;

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
        all.forEach(x->
                log.info(x.getLibrary())
                );

    }

    void manyToOne(){

        Address address = Address.builder()
                .location("HYS")
                .build();
        Library library = Library.builder()
                .name("ADV Java")
                .address(address)
                .build();

        Book book = Book.builder()
                .title("study")
                .library(library)
                .build();

        Book book1 = Book.builder()
                .title("study11")
                .library(library)
                .build();

        bookRepository.saveAll(Arrays.asList(book,book1));
        //final Library save = libraryRepository.save(library);


    }


    @Override
    public void run(String... args) throws Exception {
        save();
        findAll();
        manyToOne();

        log.info(addressRepository.getName());
    }
}
