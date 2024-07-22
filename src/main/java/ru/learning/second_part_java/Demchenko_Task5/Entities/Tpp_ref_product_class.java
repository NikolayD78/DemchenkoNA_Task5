package ru.learning.second_part_java.Demchenko_Task5.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;


// Поля
//	internal_id serial PRIMARY KEY ,
//	internal_id serial PRIMARY KEY ,
//  value VARCHAR(100) UNIQUE NOT NULL,
//  gbi_code VARCHAR(50),
//  gbi_name VARCHAR(100),
//  product_row_code VARCHAR(50),
//  product_row_name VARCHAR(100),
//  subclass_code VARCHAR(50),
//  subclass_name VARCHAR(100)

@Entity
@Data
@Table(name = "tpp_ref_product_class")
@AllArgsConstructor
@NoArgsConstructor
public class Tpp_ref_product_class {

    public Tpp_ref_product_class(    String value,
                                     String gbi_code,
                                     String gbi_name,
                                     String product_row_code,
                                     String product_row_name,
                                     String subclass_code,
                                     String subclass_name){
        this.value=value;
        this.gbi_code=gbi_code;
        this.gbi_name=gbi_name;
        this.product_row_code=product_row_code;
        this.product_row_name=product_row_name;
        this.subclass_code=subclass_code;
        this.subclass_name=subclass_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //	value VARCHAR(100) UNIQUE NOT NULL,
    @Column(name = "value", columnDefinition = "varchar(100)")
    String value;

    //	gbi_code VARCHAR(50),
    @Column(name = "gbi_code", columnDefinition = "varchar(50)")
    String gbi_code;

    //	gbi_name VARCHAR(100),
    @Column(name = "gbi_name", columnDefinition = "varchar(100)")
    String gbi_name;

    //	product_row_code VARCHAR(50),
    @Column(name = "product_row_code", columnDefinition = "varchar(50)")
    String product_row_code;

    //  product_row_name VARCHAR(100),
    @Column(name = "product_row_name", columnDefinition = "varchar(100)")
    String product_row_name;

    //  subclass_code VARCHAR(50),
    @Column(name = "subclass_code", columnDefinition = "varchar(50)")
    String subclass_code;

    //  subclass_name VARCHAR(100)
    @Column(name = "subclass_name", columnDefinition = "varchar(100)")
    String subclass_name;

    // СВЯЗИ!!!

    @OneToMany(mappedBy = "product_class_code", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter //!!!!
    @Setter //!!!!
    Set<Tpp_ref_product_register_type> tpp_ref_product_register_type;

}
