package ru.learning.second_part_java.Demchenko_Task5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.FileCopyUtils;
import ru.learning.second_part_java.Demchenko_Task5.DemchenkoTask5Application;

import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Scanner;

//import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;

@SpringBootTest(classes = DemchenkoTask5Application.class)
@AutoConfigureMockMvc
public class RestController_ProdRegTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("ТЕСТ: RestController_ProdRegTest")
    public void testRestController_ProdRegTest() throws Exception {
        ArrayList<String> stringsFromFile = new ArrayList<>(0);
        String requestJson;
        requestJson = "*";
        //***
        File file = new File("C:\\temp\\Create_ProdReg_200.json");

        System.out.println(file.getName());
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            stringsFromFile.add(sc.nextLine());
        }

        //***
        ListIterator<String> listIter = stringsFromFile.listIterator();
        while (listIter.hasNext()) {
            requestJson = requestJson + listIter.next() + "\n";
        }

        System.out.println("All is OK!!!");
        System.out.println(requestJson);
        requestJson = requestJson.substring(1);
        System.out.println("!!!All is OK!!!");
        // получили строку json с bad request
        String excpected = "Не заполнены параметры запроса: request.body: 'contractNumber'\n" +
                " instanceArrangement: \n" +
                " Строка 1: 'number'";
        // Отправляем запрос на обработку и проверяем статус ответа
        mockMvc.perform(MockMvcRequestBuilders.post("/corporate-settlement-account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\n\"data\": {\n\"accountId\":\"4\"\n}\n}"));

        // Повторная отправка того же запроса - должна вернуть ошибку
        mockMvc.perform(MockMvcRequestBuilders.post("/corporate-settlement-account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Параметр registryTypeCode тип регистра 03.012.002_47533_ComSoLd уже существует для ЭП с ИД  1"));

        file = new File("C:\\temp\\Create_ProdReg_400.json");
        sc = new Scanner(file);
        System.out.println(file.getName());
        stringsFromFile.clear();
        while (sc.hasNextLine()) {
            stringsFromFile.add(sc.nextLine());
        }

        //***
        requestJson="*";
        listIter = stringsFromFile.listIterator();
        while (listIter.hasNext()) {
            requestJson = requestJson + listIter.next() + "\n";
        }
        requestJson=requestJson.substring(1);

        // Отправка запроса с несуществующим значением кода продукта - выдает ошибку
        mockMvc.perform(MockMvcRequestBuilders.post("/corporate-settlement-account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("Код Продукта 03.012.002_47533_ComSoLd1 не найдено в Каталоге продуктов <postgres.tpp_ref_product_register_type> для данного типа Регистра"));

        // Отправка запроса с отсутствием обязательного параметра
        requestJson=requestJson.replaceAll("\"instanceId\":1,\n","");
        mockMvc.perform(MockMvcRequestBuilders.post("/corporate-settlement-account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Имя обязательного параметра InstanceId не заполнено"));

    }
}


