package fr.upec.episen.resources;

import fr.upec.episen.resources.object.Bike;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;

@Path("/bikes")
public class BikeResource {

    @Inject
    @GrpcService("owner")
    fr.upec.episen.proto.OwnerGrpc.OwnerBlockingStub ownerGrpcService;

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

        ArrayList<Bike> bikesList = new ArrayList<>();
        bikesList.add(bike1);
        bikesList.add(bike2);
        bikesList.add(bike3);
        bikesList.add(bike4);
        bikesList.add(bike5);

        for (Bike bike:bikesList) {
            bike.setOwner(
                    ownerGrpcService.getOwnerName(
                            fr.upec.episen.proto.OwnerNameRequest.newBuilder()
                                    .setBikeID(bike.getIdentification())
                                    .build()
                    ).getName()
            );
            hashMap.put(bike.getIdentification(), bike);
        }

        /*hashMap.put(bike1.getIdentification(), bike1);
        hashMap.put(bike2.getIdentification(), bike2);
        hashMap.put(bike3.getIdentification(), bike3);
        hashMap.put(bike4.getIdentification(), bike4);
        hashMap.put(bike5.getIdentification(), bike5);*/

        return hashMap;

    }
}
