package com.riwi.primeraWeb.services;

import com.riwi.primeraWeb.entity.Coder;
import com.riwi.primeraWeb.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/*Indica que esta clase será un servicio*/
@Service
public class CoderService {

    /* Autowired le indica a spring boot que esto es una inyeccion de dependecias*/
    @Autowired
    private CoderRepository coderRepository;

    /*Metodo para listar los coders de forma paginada*/

    public Page<Coder> findPaginated(Integer page, Integer size){
        if (page < 0) {
            page = 1;
        }
        /*Crear objeto de paginacion*/

        Pageable pageable = PageRequest.of(page, size);

        return this.coderRepository.findAll(pageable);

    }

    public void delete(Long id){

        this.coderRepository.deleteById(id);

    }

    //Servicio para actualizar un coder
    public Coder update(Long id, Coder coder){

        //Buscar al coder con ese id
        Coder coderDB = this.findById(id);

        //Verifica si esxiste
        if (coderDB == null) return null;

        //Actualizar el coder antiguo
        coderDB = coder;

        //Guardarlo
        return this.coderRepository.save(coderDB);
    }

    public Coder findById(Long id){
        return this.coderRepository.findById(id).orElse(null);
    }


    /* Servicio para guardar un nuevo coder */
    public Coder insert(Coder coder){
        return this.coderRepository.save(coder);
    }

    /* Servicio para listar todos los coders */
    public List<Coder> findAll(){
        return this.coderRepository.findAll();
    }

}
