import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.FileCopyUtils;
import ru.learning.second_part_java.Demchenko_Task5.Controllers.RestController_EP;
import ru.learning.second_part_java.Demchenko_Task5.DemchenkoTask5Application;
import ru.learning.second_part_java.Demchenko_Task5.Model.Model_EP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = DemchenkoTask5Application.class)
@AutoConfigureMockMvc
public class RestController_EPTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName( "ТЕСТ: RestController_EPTest")
    public void testRestController_EPTest () throws Exception {
        ArrayList<String> stringsFromFile=new ArrayList<>(0);
        String requestJson;
        requestJson="*";
        //***
        File file = new File("C:\\temp\\CreateInstanceRequest_200.json");

        System.out.println(file.getName());
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            stringsFromFile.add(sc.nextLine());
                }

    //***
        ListIterator<String> listIter = stringsFromFile.listIterator();
        while(listIter.hasNext()){
            requestJson=requestJson+listIter.next()+"\n";
        }

        System.out.println("All is OK!!!");
        System.out.println(requestJson);
        requestJson=requestJson.substring(1);
        System.out.println("!!!All is OK!!!");
        // получили строку json с bad request
        String excpected = "Не заполнены параметры запроса: request.body: 'contractNumber'\n" +
                " instanceArrangement: \n" +
                " Строка 1: 'number'";
        // Отправляем запрос на обработку и проверяем статус ответа
        mockMvc.perform(MockMvcRequestBuilders.post("/corporate-settlement-instance/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        // Повторная отправка такого же запроса должна привести к ошибке
        mockMvc.perform(MockMvcRequestBuilders.post("/corporate-settlement-instance/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Параметр ContractNumber № договора 002/2023_NSO уже существует\n для ЭП с ИД=1Параметр № Дополнительного соглашения (сделки) Number 270 уже существует для ЭП с ИД 1"));

        // отправка без одного из обязательных реквизитов - приводит к ошибке
        requestJson=requestJson.replaceAll("\"mdmCode\":\"15\",\n","");
        mockMvc.perform(MockMvcRequestBuilders.post("/corporate-settlement-instance/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Имя обязательного параметра не заполнено:\nMdmCode\n"));

        file = new File("C:\\temp\\CreateInstanceRequest_404.json");

        sc = new Scanner(file);
        stringsFromFile.clear();
        while (sc.hasNextLine()) {
            stringsFromFile.add(sc.nextLine());
        }

        //***
        requestJson="*";
        listIter = stringsFromFile.listIterator();
        while(listIter.hasNext()){
            requestJson=requestJson+listIter.next()+"\n";
        }

        requestJson=requestJson.substring(1);

        // Отправка с ошибочным кодом продукта должна привести к ошибке
        mockMvc.perform(MockMvcRequestBuilders.post("/corporate-settlement-instance/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("КодПродукта 03.012.002 не найдено в Каталоге продуктов tpp_ref_product_class"));

        file = new File("C:\\temp\\CreateInstanceRequest_400.json");

        sc = new Scanner(file);
        stringsFromFile.clear();
        while (sc.hasNextLine()) {
            stringsFromFile.add(sc.nextLine());
        }

        //***
        requestJson="*";
        listIter = stringsFromFile.listIterator();
        while(listIter.hasNext()){
            requestJson=requestJson+listIter.next()+"\n";
        }

        requestJson=requestJson.substring(1);

        // ошибка - такое доп соглашение уже есть для продукта
        mockMvc.perform(MockMvcRequestBuilders.post("/corporate-settlement-instance/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Параметр № Дополнительного соглашения (сделки) Number 270 уже существует для ЭП с ИД 1"));
    }

}
