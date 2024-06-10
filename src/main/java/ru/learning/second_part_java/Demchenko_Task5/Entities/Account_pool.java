package ru.learning.second_part_java.Demchenko_Task5.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;


// Поля
//  id serial PRIMARY KEY,
//  branch_code VARCHAR(50),
//  currency_code VARCHAR(30),
//  mdm_code VARCHAR(50),
//  priority_code VARCHAR(30),
//  registry_type_code VARCHAR(50)

@Entity
@Data
@Table(name = "Account_pool")
@AllArgsConstructor
@NoArgsConstructor
public class Account_pool {

    public Account_pool(String branch_code, String currency_code,String mdm_code,String priority_code,String registry_type_code){
        this.branch_code=branch_code;
        this.currency_code=currency_code;
        this.mdm_code=mdm_code;
        this.priority_code=priority_code;
        this.registry_type_code=registry_type_code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "branch_code", columnDefinition = "varchar(50)")
    String branch_code;

    @Column(name = "currency_code",columnDefinition = "varchar(30)")
    String currency_code;

    @Column(name = "mdm_code", columnDefinition = "varchar(50)")
    String mdm_code;

    @Column(name = "priority_code", columnDefinition = "varchar(30)")
    String priority_code;

    @Column(name = "registry_type_code", columnDefinition = "varchar(50)")
    String registry_type_code;

    //@OneToMany(mappedBy = "user1", cascade = CascadeType.ALL, orphanRemoval = true)
    //@Getter //!!!!
    //@Setter //!!!!
    //Set<Logins> logins;

}
