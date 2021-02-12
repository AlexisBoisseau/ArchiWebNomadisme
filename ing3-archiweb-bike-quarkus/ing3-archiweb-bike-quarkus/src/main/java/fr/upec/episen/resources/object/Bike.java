package fr.upec.episen.resources.object;

import lombok.Data;

@Data
public class Bike {

    public Bike(){
        super();
    }

    public Bike(String model, Integer price, String identification, String owner) {
        this.model = model;
        this.price = price;
        this.identification = identification;
        this.owner = owner;
    }

    public Bike(String model, Integer price, String identification) {
        this.model = model;
        this.price = price;
        this.identification = identification;
    }

    private String model;
    private Integer price;
    private String identification;
    private String owner;
}
