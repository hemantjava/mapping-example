package com.example.mapping.example.onetomany;


import com.example.mapping.example.onetoone.Library;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Builder
@Data
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="library_id",referencedColumnName = "id")
    private Library library;


}