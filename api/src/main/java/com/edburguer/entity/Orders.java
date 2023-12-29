package com.edburguer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Address addresses;


    private Integer status;

    private Integer payment;

    @Column(name = "receive_type")
    private Integer receiveType;

    private String cpf;

    private Double price;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductOrders> productOrder = new ArrayList<>();

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public Payment getPayment() {
        return Payment.valueOf(payment);
    }

    public ReceiveType getReceiveType() {
        return ReceiveType.valueOf(receiveType);
    }

    public void addProductOrders(ProductOrders entity) {
        if(productOrder == null) productOrder = new ArrayList<>();

        this.productOrder.add(entity);
    }
}

/*

package com.edburguer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Address addresses;


    private Integer status;

    private Integer payment;

    @Column(name = "receive_type")
    private Integer receiveType;

    private String cpf;

    private Double price;

    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    private List<ProductOrders> productOrder = new ArrayList<>();

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public Payment getPayment() {
        return Payment.valueOf(payment);
    }

    public ReceiveType getReceiveType() {
        return ReceiveType.valueOf(receiveType);
    }
}


 */