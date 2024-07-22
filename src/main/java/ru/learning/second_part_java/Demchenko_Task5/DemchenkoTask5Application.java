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

	static Account_pool tmp_Account_pool1,tmp_Account_pool2;
	static List<Tpp_ref_product_register_type> tmpListTpp_ref_product_register_type;
	static Tpp_ref_product_class tmpTpp_ref_product_class1, tmpTpp_ref_product_class2;
	static Tpp_ref_account_type tmpTpp_ref_account_type;

	public static void main(String[] args) {

		ApplicationContext ctx=SpringApplication.run(DemchenkoTask5Application.class, args);

		// так как разработано в IDEA Community, то SQL файлы не допускаются для Docker,
		// заполним таблицы данными вручную
		InsertToDB InsDB_Bean=ctx.getBean(InsertToDB.class);

		InsDB_Bean.InsToAccount_pool("0022", "800", "15", "00", "03.012.002_47533_ComSoLd");
		InsDB_Bean.InsToAccount_pool("0021", "500", "13", "00", "02.001.005_45343_CoDowFF");

		tmp_Account_pool1=InsDB_Bean.sel1Account_Pool("03.012.002_47533_ComSoLd");
		tmp_Account_pool2=InsDB_Bean.sel1Account_Pool("02.001.005_45343_CoDowFF");

		InsDB_Bean.InsToAccount(tmp_Account_pool1,"475335516415314841861",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool1,"4753321651354151",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool1,"4753352543276345",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool1,"40701810400000000001",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool2,"453432352436453276",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool2,"45343221651354151",false);
		InsDB_Bean.InsToAccount(tmp_Account_pool2,"4534352543276345",false);

		tmpTpp_ref_account_type=InsDB_Bean.InsToTpp_ref_account_type("Клиентский");
		InsDB_Bean.InsToTpp_ref_account_type("Внутрибанковский");

		tmpTpp_ref_product_class1=InsDB_Bean.InsToTpp_ref_product_class("03.012.002", "03", "Розничный бизнес", "012", "Драг. металлы", "002", "Хранение");
		InsDB_Bean.InsToTpp_ref_product_register_type("03.012.002_47533_ComSoLd", "Хранение ДМ.", tmpTpp_ref_product_class1, null,null,tmpTpp_ref_account_type);

		tmpTpp_ref_product_class2=InsDB_Bean.InsToTpp_ref_product_class("02.001.005", "02", "Розничный бизнес", "001", "Сырье", "005", "Продажа");
		InsDB_Bean.InsToTpp_ref_product_register_type("02.001.005_45343_CoDowFF", "Серебро. Выкуп.", tmpTpp_ref_product_class2, null,null, tmpTpp_ref_account_type);

		tmpListTpp_ref_product_register_type=InsDB_Bean.sel1Tpp_ref_product_register_type(tmpTpp_ref_product_class1.getId());
		for(Tpp_ref_product_register_type f : tmpListTpp_ref_product_register_type)
		    InsDB_Bean.InsToTpp_product_register(BigInteger.valueOf(1),f, BigInteger.valueOf(123123),"RUB", States.OPEN,"numb_acc1");

		tmpListTpp_ref_product_register_type=InsDB_Bean.sel1Tpp_ref_product_register_type(tmpTpp_ref_product_class2.getId());
		for(Tpp_ref_product_register_type f : tmpListTpp_ref_product_register_type)
			{
			InsDB_Bean.InsToTpp_product_register(BigInteger.valueOf(1),f,BigInteger.valueOf(123124),"USD",States.RESERVED,"numb_acc2");
			InsDB_Bean.InsToTpp_product_register(BigInteger.valueOf(3),f,BigInteger.valueOf(123125),"EUR",States.CLOSED,"numb_acc3");
			}

	}

}
