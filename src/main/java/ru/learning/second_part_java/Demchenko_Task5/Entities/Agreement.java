package ru.learning.second_part_java.Demchenko_Task5.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


// Поля
//	id serial PRIMARY KEY,
//	product_id integer,
//	general_agreement_id VARCHAR(50),
//	supplementary_agreement_id VARCHAR(50),
//	arrangement_type VARCHAR(50),
//	sheduler_job_id BIGINT,
//	number VARCHAR(50),
//  opening_date TIMESTAMP,
//  closing_date TIMESTAMP,
//  cancel_date TIMESTAMP,
//  validity_duration BIGINT,
//  cancellation_reason VARCHAR(100),
//  status VARCHAR(50),
//  interest_calculation_date TIMESTAMP,
//  interest_rate DECIMAL,
//  coefficient DECIMAL,
//  coefficient_action VARCHAR(50),
//  minimum_interest_rate DECIMAL,
//  minimum_interest_rate_coefficient DECIMAL,
//  minimum_interest_rate_coefficient_action VARCHAR(50),
//  maximal_interest_rate DECIMAL,
//  maximal_interest_rate_coefficient_action VARCHAR(50)
// -->  maximal_interest_rate_coefficient DECIMAL,

@Entity
@Data
@Table(name = "Agreement")
public class Agreement {

    public Agreement(Integer product_id,
                     String general_agreement_id,
                     String supplementary_agreement_id,
                     String arrangement_type,
                     BigInteger sheduler_job_id,
                     String number,
                     Date opening_date,
                     Date closing_date,
                     Date cancel_date,
                     BigInteger validity_duration,
                     String cancellation_reason,
                     String status,
                     Date interest_calculation_date,
                     Double interest_rate,
                     Double coefficient,
                     String coefficient_action,
                     Double minimum_interest_rate,
                     Double minimum_interest_rate_coefficient,
                     String minimum_interest_rate_coefficient_action,
                     Double maximal_interest_rate,
                     Double maximal_interest_rate_coefficient,
                     String maximal_interest_rate_coefficient_action){
        this.product_id=product_id;
        this.general_agreement_id=general_agreement_id;
        this.supplementary_agreement_id=supplementary_agreement_id;
        this.arrangement_type=arrangement_type;
        this.sheduler_job_id=sheduler_job_id;
        this.number=number;
        this.opening_date=opening_date;
        this.closing_date=closing_date;
        this.cancel_date=cancel_date;
        this.validity_duration=validity_duration;
        this.cancellation_reason=cancellation_reason;
        this.status=status;
        this.interest_calculation_date=interest_calculation_date;
        this.interest_rate=interest_rate;
        this.coefficient=coefficient;
        this.coefficient_action=coefficient_action;
        this.minimum_interest_rate=minimum_interest_rate;
        this.minimum_interest_rate_coefficient=minimum_interest_rate_coefficient;
        this.minimum_interest_rate_coefficient_action=minimum_interest_rate_coefficient_action;
        this.maximal_interest_rate=maximal_interest_rate;
        this.maximal_interest_rate_coefficient=maximal_interest_rate_coefficient;
        this.maximal_interest_rate_coefficient_action=maximal_interest_rate_coefficient_action;

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Column(name = "product_id")
    Integer product_id;

    @Column(name = "general_agreement_id", columnDefinition = "varchar(50)")
    String general_agreement_id;

    @Column(name = "supplementary_agreement_id", columnDefinition = "varchar(50)")
    String supplementary_agreement_id;

    @Column(name = "arrangement_type", columnDefinition = "varchar(50)")
    String arrangement_type;

    @Column(name = "sheduler_job_id")
    BigInteger sheduler_job_id;

    @Column(name = "number" , columnDefinition = "varchar(50)")
    String number;

    @Column(name = "opening_date")
    Date opening_date;

    @Column(name = "closing_date")
    Date closing_date;

    @Column(name = "cancel_date")
    Date cancel_date;

    @Column(name = "validity_duration")
    BigInteger validity_duration;

    @Column(name = "cancellation_reason", columnDefinition = "varchar(100)")
    String cancellation_reason;

    @Column(name = "status" , columnDefinition = "varchar(50)")
    String status;

    @Column(name = "interest_calculation_date")
    Date interest_calculation_date;

    @Column(name = "interest_rate")
    Double interest_rate;

    @Column(name = "coefficient")
    Double coefficient;

    @Column(name = "coefficient_action" , columnDefinition = "varchar(50)")
    String coefficient_action;

    @Column(name = "minimum_interest_rate")
    Double minimum_interest_rate;

    @Column(name = "minimum_interest_rate_coefficient")
    Double minimum_interest_rate_coefficient;

    @Column(name = "minimum_interest_rate_coefficient_action",  columnDefinition = "varchar(50)")
    String minimum_interest_rate_coefficient_action;

    @Column(name = "maximal_interest_rate")
    Double maximal_interest_rate;

    @Column(name = "maximal_interest_rate_coefficient")
    Double maximal_interest_rate_coefficient;

    @Column(name = "maximal_interest_rate_coefficient_action", columnDefinition = "varchar(50)")
    String maximal_interest_rate_coefficient_action;

    //@OneToMany(mappedBy = "user1", cascade = CascadeType.ALL, orphanRemoval = true)
    //@Getter //!!!!
    //@Setter //!!!!
    //Set<Logins> logins;

}
