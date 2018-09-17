package com.hannesnyberg.vegetableAPI.Model;

import javax.persistence.*;

@Entity
public class Vegetable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;
    private String name;
    private Long price;

    public Vegetable(){
        super();
    }

    public Vegetable(String name, Long price) {
        super();
        this.name = name;
        this.price = price;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
