package ru.learning.second_part_java.Demchenko_Task5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.learning.second_part_java.Demchenko_Task5.Entities.Account_pool;

import static java.sql.Types.TIMESTAMP;

@SpringBootApplication
public class DemchenkoTask5Application {

	static Account_pool tmp_Account_pool1,tmp_Account_pool2;

	public static void main(String[] args) {

		ApplicationContext ctx=SpringApplication.run(DemchenkoTask5Application.class, args);

		// так как разработано в IDEA Community, то SQL файлы не допускаются для Docker,
		// заполним таблицы данными вручную
		InsertToDB InsDB_Bean=ctx.getBean(InsertToDB.class);

		InsDB_Bean.InsToAccount_pool("0022", "800", "15", "00", "03.012.002_47533_ComSoLd");
		InsDB_Bean.InsToAccount_pool("0021", "500", "13", "00", "02.001.005_45343_CoDowFF");

		tmp_Account_pool1=InsDB_Bean.sel1Account_Pool("03.012.002_47533_ComSoLd");
		tmp_Account_pool2=InsDB_Bean.sel1Account_Pool("02.001.005_45343_CoDowFF");

		InsDB_Bean.InsToAccount(tmp_Account_pool1.getId(),"475335516415314841861",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool1.getId(),"4753321651354151",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool1.getId(),"4753352543276345",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool2.getId(),"453432352436453276",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool2.getId(),"45343221651354151",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool2.getId(),"4534352543276345",false);

		InsDB_Bean.InsToTpp_ref_account_type("Клиентский");
		InsDB_Bean.InsToTpp_ref_account_type("Внутрибанковский");

		InsDB_Bean.InsToTpp_ref_product_class("03.012.002", "03", "Розничный бизнес", "012", "Драг. металлы", "002", "Хранение");
		InsDB_Bean.InsToTpp_ref_product_class("02.001.005", "02", "Розничный бизнес", "001", "Сырье", "005", "Продажа");

		InsDB_Bean.InsToTpp_ref_product_register_type("03.012.002_47533_ComSoLd", "Хранение ДМ.", "03.012.002", null,null,"Клиентский");
		InsDB_Bean.InsToTpp_ref_product_register_type("02.001.005_45343_CoDowFF", "Серебро. Выкуп.", "02.001.005", null,null, "Клиентский");

	}

}
