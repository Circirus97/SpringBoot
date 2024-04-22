package com.riwi.primeraWeb.controller;

import com.riwi.primeraWeb.entity.Coder;
import com.riwi.primeraWeb.services.CoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class CoderController {

    @Autowired
    private CoderService coderService;

    /*Metodo para mostrar la vista y enviarle la lista coders */
    @GetMapping
    public String showViewGetAll(Model model,
                                 @RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "3") Integer size){

        /* Llamo el servicio y guardo la lista de coders*/
        Page<Coder> list = this.coderService.findPaginated(page -1, size);
        model.addAttribute("coderList", list); //Llave - valor
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", list.getTotalPages());

        /* Se debe retornar el nombre exacto de la vista html*/
        return "viewCoder";
    }

    @GetMapping("/form")
    public String showViewFormCoder(Model model){

        model.addAttribute("coder", new Coder());
        model.addAttribute("action", "/coder/create");

        return "viewForm";

    }

    /* Metodo para insertar un coder mediante el verbo POST */
    /* ModelAttribute se encarga de obtener la información enviada desde la vista*/
    @PostMapping("/coder/create")
    public String createCoder(@ModelAttribute Coder coder){

        /*Llamamos al servicio enviandole el coder a insertar*/
        this.coderService.insert(coder);

        return "redirect:/";

    }


    //Metodo para mostrar el formulario de actualizar un coder
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Long id, Model model){

        Coder coderFind = this.coderService.findById(id);
        model.addAttribute("coder", coderFind);

        model.addAttribute("action", "/edit/" + id);

        return "viewForm";
    }

    @PostMapping("/edit/{id}")
    public String updateCoder(@PathVariable Long id, @ModelAttribute Coder coder){
        this.coderService.update(id, coder);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCoder(@PathVariable Long id){
        this.coderService.delete(id);

        return "redirect:/";
    }



}
