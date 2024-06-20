package ru.learning.second_part_java.Demchenko_Task5.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ru.learning.second_part_java.Demchenko_Task5.Model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learning.second_part_java.Demchenko_Task5.Services.Service_ProdReg;

@RestController
@RequestMapping(value="/")
public class RestController_ProdReg {

    @Autowired
    private Service_ProdReg service_prodReg;

@PostMapping(value="corporate-settlement-account/create")
public ResponseEntity<String> createProdReg(@RequestBody Model_ProdReg request)
{ return ResponseEntity.ok(service_prodReg.create_ProdReg(request));}

}
