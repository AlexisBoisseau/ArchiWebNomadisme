package fr.upec.episen;

import fr.upec.episen.proto.OwnerGrpc;
import fr.upec.episen.proto.OwnerNameReply;
import fr.upec.episen.proto.OwnerNameRequest;
import fr.upec.episen.proto.OwnerUpdateRequest;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;
import java.util.HashMap;


@Singleton
public class OwnerGrpcService extends OwnerGrpc.OwnerImplBase {

    HashMap<String, String> hashMap = new HashMap<>();

    public OwnerGrpcService() {
        hashMap.put("AB-123-CD", "Zinédine ZIDANE");
        hashMap.put("PQ-647-RB", "Kylian MBAPPÉ");
        hashMap.put("AM-666-SD", "Guillaume TAOUDIAT");;
    }

    @Override
    public void getOwnerName(OwnerNameRequest request, StreamObserver<OwnerNameReply> responseObserver) {

        String bikeID = request.getBikeID();
        String name = "inconnu";

        if (hashMap.containsKey(bikeID)){
            name = hashMap.get(bikeID);
        }

        responseObserver.onNext(OwnerNameReply
                .newBuilder()
                .setName(name)
                .build()
        );

        responseObserver.onCompleted();
    }

    @Override
    public void updateOwner(OwnerUpdateRequest request, StreamObserver<fr.upec.episen.proto.OwnerUpdateReply> responseObserver) {
        String bikeID = request.getBikeID();
        String name = request.getName();
        hashMap.put(bikeID, name);

        String result = "false";
        if (hashMap.get(bikeID)==name){result="true";}

        responseObserver.onNext(fr.upec.episen.proto.OwnerUpdateReply
                .newBuilder()
                .setResult(result)
                .build()
        );

        responseObserver.onCompleted();
    }
}
