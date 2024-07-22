package ru.learning.second_part_java.Demchenko_Task5.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


// Поля
//	id serial PRIMARY KEY ,
//	product_id BIGINT,
//    type VARCHAR(100) NOT NULL,
//    account BIGINT,
//    currency_code VARCHAR(30),
//    state VARCHAR(50),
//    account_number VARCHAR(25)

@Entity
@Data
@Table(name = "tpp_product_register")
@AllArgsConstructor
@NoArgsConstructor
public class Tpp_product_register {

    public Tpp_product_register(BigInteger product_id,
                                Tpp_ref_product_register_type type,
                                BigInteger account,
                                String currency_code,
                                String state,
                                String account_number){

        this.product_id=product_id;
        this.type=type;
        this.account=account;
        this.currency_code=currency_code;
        this.state=state;
        this.account_number=account_number;

    }

    //	id serial PRIMARY KEY ,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //	product_id BIGINT,
    @Column(name = "product_id")
    BigInteger product_id;

    //type VARCHAR(100) NOT NULL,
    //@Column(name = "type", nullable = false, columnDefinition = "varchar(100)")
    //@NonNull
    //String type;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "type")
    @Getter
    @Setter
    private Tpp_ref_product_register_type type;

    //account BIGINT,
    @Column(name = "account")
    BigInteger account;

    //currency_code VARCHAR(30),
    @Column(name = "currency_code", columnDefinition = "varchar(30)")
    String currency_code;

    //state VARCHAR(50),
    @Column(name = "state", columnDefinition = "varchar(50)")
    String state;

    //account_number VARCHAR(25)
    @Column(name = "account_number", columnDefinition = "varchar(25)")
    String account_number;

}
