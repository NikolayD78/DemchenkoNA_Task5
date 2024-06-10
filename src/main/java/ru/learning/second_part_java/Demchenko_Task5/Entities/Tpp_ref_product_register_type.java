package ru.learning.second_part_java.Demchenko_Task5.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// Поля
//	internal_id serial PRIMARY KEY ,
//    value VARCHAR(100) UNIQUE NOT NULL,
//    register_type_name VARCHAR(100) NOT NULL,
//    product_class_code VARCHAR(100) NOT NULL,
//    register_type_start_date TIMESTAMP,
//    register_type_end_date TIMESTAMP,
//    account_type VARCHAR(100)


@Entity
@Data
@Table(name = "Tpp_ref_product_register_type")
public class Tpp_ref_product_register_type {

    public Tpp_ref_product_register_type(String value,String register_type_name, String product_class_code, Date register_type_start_date, Date register_type_end_date, String account_type)
    {
        this.value=value;
        this.register_type_name=register_type_name;
        this.product_class_code=product_class_code;
        this.register_type_start_date=register_type_start_date;
        this.register_type_end_date=register_type_end_date;
        this.account_type=account_type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //	value VARCHAR(100) UNIQUE NOT NULL,
    @Column(name = "value", unique=true, nullable = false, columnDefinition = "varchar(100)")
    String value;

    //register_type_name VARCHAR(100) NOT NULL,
    @Column(name = "register_type_name", nullable = false, columnDefinition = "varchar(100)")
    String register_type_name;

    //product_class_code VARCHAR(100) NOT NULL,
    @Column(name = "product_class_code", nullable = false, columnDefinition = "varchar(100)")
    String product_class_code;

    //register_type_start_date TIMESTAMP,
    @Column(name = "register_type_start_date")
    Date register_type_start_date;

    //register_type_end_date TIMESTAMP,
    @Column(name = "register_type_end_date")
    Date register_type_end_date;

    //account_type VARCHAR(100)
    @Column(name = "account_type", columnDefinition = "varchar(100)")
    String account_type;

}
