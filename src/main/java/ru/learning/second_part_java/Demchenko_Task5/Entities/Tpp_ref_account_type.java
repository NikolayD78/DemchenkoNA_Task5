package ru.learning.second_part_java.Demchenko_Task5.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

// прагмы
// nullable = false, columnDefinition = "varchar(45)"

// Поля
//	internal_id serial PRIMARY KEY ,
//	value VARCHAR(100) UNIQUE NOT NULL

@Entity
@Data
@Table(name = "tpp_ref_account_type")
@AllArgsConstructor
@NoArgsConstructor
public class Tpp_ref_account_type {

    public Tpp_ref_account_type(String value){
        this.value=value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    Integer id;

    @Column(name = "value", unique=true, nullable = false, columnDefinition = "varchar(100)")
    @Getter
    @Setter
    String value;

// ***************
// СВЯЗИ
// ***************

@OneToMany(mappedBy = "account_type", cascade = CascadeType.ALL, orphanRemoval = true)
@Getter //!!!!
@Setter //!!!!
Set<Tpp_ref_product_register_type> tpp_ref_product_register_type;

}
