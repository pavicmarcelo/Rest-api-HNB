package com.rest.restapihnb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data // geter i seteri, toString...
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@NonNull
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;

    //@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Column(name = "product_id")
    private Long productId;

}
