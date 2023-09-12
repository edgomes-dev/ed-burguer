package com.edburguer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Address> addresses  = new ArrayList<>();

    public void addAddress(Address data) {
        this.addresses.add(data);
    }
}
