package ru.learning.second_part_java.Demchenko_Task5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Account_pool;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_ref_account_type;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_ref_product_class;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Tpp_ref_product_register_type;
import ru.learning.second_part_java.Demchenko_Task5.Enums.States;

import java.math.BigInteger;
import java.util.List;

import static java.sql.Types.TIMESTAMP;

@SpringBootApplication
public class DemchenkoTask5Application {


	static public ApplicationContext ctx;
	static public InsertToDB InsDB_Bean;

	public static void main(String[] args) {

		ctx=SpringApplication.run(DemchenkoTask5Application.class, args);
		InsDB_Bean=ctx.getBean(InsertToDB.class);
		InsDB_Bean.init_DB();// так как разработано в IDEA Community, то SQL файлы не допускаются для Docker,
		                     // заполним таблицы данными вручную
	}

}
