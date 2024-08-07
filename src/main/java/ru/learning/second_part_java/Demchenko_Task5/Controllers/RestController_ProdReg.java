package ru.learning.second_part_java.Demchenko_Task5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import ru.learning.second_part_java.Demchenko_Task5.Model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learning.second_part_java.Demchenko_Task5.Services.Service_ProdReg;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestController
@RequestMapping(value="/")
public class RestController_ProdReg {

    String retValue;
    int statusRequest;
    @Autowired
    private Service_ProdReg service_prodReg;

    @PostMapping(value = "corporate-settlement-account/create")
    public ResponseEntity<String> createProdReg(@RequestBody Model_ProdReg request) {
        try{
            retValue = service_prodReg.create_ProdReg(request);
            }
        catch (Exception e)
        {
            StringWriter err_msg=new StringWriter();
            e.printStackTrace(new PrintWriter(err_msg));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()+"\n"+err_msg);
        }

        statusRequest = Integer.valueOf(retValue.substring(0, 3));
        retValue = retValue.substring(3);

        if (statusRequest == 400)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(retValue);

        if (statusRequest == 404)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retValue);

        return ResponseEntity.ok(retValue);

    }
}