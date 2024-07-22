package ru.learning.second_part_java.Demchenko_Task5.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


//  Поля
//	id serial PRIMARY KEY,
//  product_code_id BIGINT,
//  client_id BIGINT,
//  type VARCHAR(50),
//  number VARCHAR(50),
//  priority BIGINT,
//  date_of_conclusion TIMESTAMP,
//  start_date_time TIMESTAMP,
//  end_date_time TIMESTAMP,
//  days BIGINT,
//  penalty_rate DECIMAL,
//  nso DECIMAL,
//  threshold_amount DECIMAL,
//  requisite_type VARCHAR(50),
//  interest_rate_type VARCHAR(50),
//  tax_rate DECIMAL,
//  reasone_close VARCHAR(100),
//  state VARCHAR(50)


@Entity
@Data
@Table(name = "tpp_product")
@AllArgsConstructor
@NoArgsConstructor
public class Tpp_product {

    public Tpp_product(BigInteger product_code_id,
                       BigInteger client_id,
                       String type,
                       String number,
                       BigInteger priority,
                       Date date_of_conclusion,
                       Date start_date_time,
                       Date end_date_time,
                       BigInteger days,
                       Double penalty_rate,
                       Double nso,
                       Double threshold_amount,
                       String requisite_type,
                       String interest_rate_type,
                       Double tax_rate,
                       String reasone_close,
                       String state){

        this.product_code_id=product_code_id;
        this.client_id=client_id;
        this.type=type;
        this.number=number;
        this.priority=priority;
        this.date_of_conclusion=date_of_conclusion;
        this.start_date_time=start_date_time;
        this.end_date_time=end_date_time;
        this.days=days;
        this.penalty_rate=penalty_rate;
        this.nso=nso;
        this.threshold_amount=threshold_amount;
        this.requisite_type=requisite_type;
        this.interest_rate_type=interest_rate_type;
        this.tax_rate=tax_rate;
        this.reasone_close=reasone_close;
        this.state=state;
    }

    //	id serial PRIMARY KEY,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //	product_code_id BIGINT,
    @Column(name = "product_code_id")
    BigInteger product_code_id;

    //	client_id BIGINT,
    @Column(name = "client_id")
    BigInteger client_id;

    //	type VARCHAR(50),
    @Column(name = "type", columnDefinition = "varchar(50)")
    String type;

    //	number VARCHAR(50),
    @Column(name = "number", columnDefinition = "varchar(50)")
    String number;

    //	priority BIGINT,
    @Column(name = "priority")
    BigInteger priority;

    //	date_of_conclusion TIMESTAMP,
    @Column(name = "date_of_conclusion")
    Date date_of_conclusion;

    //	start_date_time TIMESTAMP,
    @Column(name = "start_date_time")
    Date start_date_time;

    //	end_date_time TIMESTAMP,
    @Column(name = "end_date_time")
    Date end_date_time;

    //	days BIGINT,
    @Column(name = "days")
    BigInteger days;

    //	penalty_rate DECIMAL,
    @Column(name = "penalty_rate")
    Double penalty_rate;

    //	nso DECIMAL,
    @Column(name = "nso")
    Double nso;

    //	threshold_amount DECIMAL,
    @Column(name = "threshold_amount")
    Double threshold_amount;

    //	requisite_type VARCHAR(50),
    @Column(name = "requisite_type", columnDefinition = "varchar(50)")
    String requisite_type;

    //	interest_rate_type VARCHAR(50),
    @Column(name = "interest_rate_type", columnDefinition = "varchar(50)")
    String interest_rate_type;

    //	tax_rate DECIMAL,
    @Column(name = "tax_rate")
    Double tax_rate;

    //	reasone_close VARCHAR(100),
    @Column(name = "reasone_close", columnDefinition = "varchar(100)")
    String reasone_close;

    //    state VARCHAR(50)
    @Column(name = "state", columnDefinition = "varchar(50)")
    String state;

// ****************
// СВЯЗИ
// ****************
@OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL, orphanRemoval = true)
@Getter //!!!!
@Setter //!!!!
Set<Agreement> agreement;

}
