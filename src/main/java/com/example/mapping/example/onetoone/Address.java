package com.example.mapping.example.onetoone;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String location;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Library library;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}