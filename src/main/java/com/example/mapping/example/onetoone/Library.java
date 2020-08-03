package com.example.mapping.example.onetoone;

import com.example.mapping.example.onetomany.Book;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"books","address"})
public class Library {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "library",cascade = CascadeType.ALL)
    private List<Book> books;

}