package ru.learning.second_part_java.Demchenko_Task5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learning.second_part_java.Demchenko_Task5.Model.Model_EP;
import ru.learning.second_part_java.Demchenko_Task5.Services.Service_EP;


@RestController
@RequestMapping(value="/")
public class RestController_EP {

    String retValue;
    int statusRequest;
    @Autowired
    private Service_EP service_EP;

    @PostMapping(value = "corporate-settlement-instance/create")
    public ResponseEntity<String> createProdReg(@RequestBody Model_EP request) {
        retValue = service_EP.create_EP(request);
        System.out.println("retValue "+retValue);

        statusRequest = Integer.valueOf(retValue.substring(0, 3));
        retValue = retValue.substring(3);

        if (statusRequest == 400)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(retValue);

        if (statusRequest == 404)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retValue);

        return ResponseEntity.ok(retValue);

    }
}