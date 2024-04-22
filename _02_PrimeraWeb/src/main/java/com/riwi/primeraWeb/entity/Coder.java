package com.riwi.primeraWeb.entity;

import jakarta.persistence.*;


//Entity indica que esta clase será una entidad y podrá ser mapeada
@Entity

//Table nos permite dar configuraciones a la tabla

@Table(name="coders")
public class Coder {

    /* Agregando propiedades al atributo ID */
    /* El @Id indica que el atributo siguiente será la llave primaria */
    /* El GeneratedValue permite que el ID sea autoincrementable*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String clan;

    public Coder() {}

    public Coder(Long id, String name, Integer age, String clan) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clan = clan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "Coder\n" +
                "id: " + id +
                ", name: " + name +
                ", age: " + age +
                ", clan: " + clan  +
                "\n----------------------------------------------------------------\n";
    }
}
