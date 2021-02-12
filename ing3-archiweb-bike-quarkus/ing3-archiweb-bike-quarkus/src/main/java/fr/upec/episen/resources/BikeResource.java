package fr.upec.episen.resources;

import fr.upec.episen.resources.object.Bike;
import fr.upec.episen.resources.object.Notes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Path("/bikes")
public class BikeResource {

    /**
     * Exposer une méthode getAll renvoyant une liste de bikes
     * depuis la route /bikes
     */

    public HashMap<String, Bike> hashMap =new HashMap<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String,Bike> getAllBikes(){

        Bike bike1 = new Bike("VTT maître des montagnes 200", 500,  "AB-123-CD");
        Bike bike2 = new Bike("VTT maître des montagnes 200", 500,  "WX-987-YZ");
        Bike bike3 = new Bike("VTT maître des ruelles 300", 450,  "FH-659-GG");
        Bike bike4 = new Bike("VTT électrique", 700,  "PQ-647-RB");
        Bike bike5 = new Bike("VTT classique", 362,  "AM-666-SD");

        hashMap.put(bike1.getIdentification(), bike1);
        hashMap.put(bike2.getIdentification(), bike2);
        hashMap.put(bike3.getIdentification(), bike3);
        hashMap.put(bike4.getIdentification(), bike4);
        hashMap.put(bike5.getIdentification(), bike5);

        return hashMap;

    }
}
