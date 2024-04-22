package com.riwi.operaciones.controller;

import com.riwi.operaciones.entity.Operations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationsController {

    @PostMapping(path = "/add")
    public String add(@RequestBody Operations operations){
        String message = String.valueOf(operations.getNum1() + operations.getNum2());

        return operations.getNum1() +  " + " + operations.getNum2() + " = " + message;
    }

    @PostMapping(path = "/subtract")
    public String subtract(@RequestBody Operations operations){
        String message = String.valueOf(operations.getNum1() - operations.getNum2());

        return operations.getNum1() +  " - " + operations.getNum2() + " = " + message;
    }

    @PostMapping(path = "/multiplication")
    public String multiplication(@RequestBody Operations operations){
        String message = String.valueOf(operations.getNum1() * operations.getNum2());

        return operations.getNum1() +  " * " + operations.getNum2() + " = " + message;
    }

    @PostMapping(path = "/split")
    public String split(@RequestBody Operations operations){

        if(operations.getNum2() == 0){
            return "No se puede dividir numeros entre cero";
        }

        String message = String.valueOf(operations.getNum1() / operations.getNum2());

        return operations.getNum1() +  " / " + operations.getNum2() + " = " + message;
    }

    @PostMapping(path = "/module")
    public String module(@RequestBody Operations operations){
        String message = String.valueOf(operations.getNum1() % operations.getNum2());

        return "El módulo de " + operations.getNum1() + " dividido por " + operations.getNum2() + " es: " + message;

    }
}
