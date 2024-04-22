package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;




/*Indica que esta clase sera un controlador */ 
@Controller

/*RequestMapping Crea la ruta base del controlador*/ 
@RequestMapping("/controller")
public class holaMundo {

    /*GetMapping crea una ruta especifica para el metodo*/ 
    @GetMapping("/holaMundo")    

    /*ResponseBody nos permite responder en el navegador */
    @ResponseBody
    public String mostrarMensaje(){
        return "Hola Mundo";
    }

    @GetMapping("/suma")
    @ResponseBody
    public Integer suma(){

        Integer num1 = 2;
        Integer num2 = 5;

        Integer suma = num1 + num2;

        return suma;
    }

    @GetMapping("/sumar")
    @ResponseBody
    public String sumar(){

        Integer a = 2, b = 4;

        return String.valueOf(a + b);
    }



}