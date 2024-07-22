package ru.learning.second_part_java.Demchenko_Task5.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;


// Поля
//  id serial PRIMARY KEY,
//  account_pool_id integer,
//  account_number VARCHAR(25),
//  bussy BOOLEAN

@Entity
@Data
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    public Account(Account_pool account_pool_id, String account_number,boolean bussy){
        this.account_pool_id = account_pool_id;
        this.account_number = account_number;
        this.bussy=bussy;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //@Column(name = "account_pool_id")
    //Integer account_pool_id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "account_pool_id")
    @Getter
    @Setter
    private Account_pool account_pool_id;

    @Column(name = "account_number", columnDefinition = "varchar(25)")
    String account_number;

    @Column(name = "bussy")
    boolean bussy;

    //@OneToMany(mappedBy = "user1", cascade = CascadeType.ALL, orphanRemoval = true)
    //@Getter //!!!!
    //@Setter //!!!!
    //Set<Logins> logins;

}
