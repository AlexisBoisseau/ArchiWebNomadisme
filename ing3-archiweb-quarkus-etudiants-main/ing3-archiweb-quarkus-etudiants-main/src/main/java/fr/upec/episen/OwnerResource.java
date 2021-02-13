package fr.upec.episen;

import fr.upec.episen.proto.OwnerUpdateReply;
import fr.upec.episen.proto.OwnerUpdateRequest;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/owners")
public class OwnerResource {

    @Inject
    @GrpcService("owner")
    fr.upec.episen.proto.OwnerGrpc.OwnerBlockingStub ownerGrpcService;

    @PUT
    @Path("{bikeID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateOwner(BikeUpdateOwnerRequest request, @PathParam("bikeID") String bikeID){

        OwnerUpdateReply resultPut = ownerGrpcService.updateOwner(
                OwnerUpdateRequest.newBuilder()
                        .setBikeID(bikeID)
                        .setName(request.getOwner())
                        .build()
        );

        return resultPut.getResult();
    }
}
