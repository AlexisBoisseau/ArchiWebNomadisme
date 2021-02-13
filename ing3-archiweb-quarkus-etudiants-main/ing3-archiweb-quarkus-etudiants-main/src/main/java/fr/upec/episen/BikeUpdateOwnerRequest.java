package fr.upec.episen;

public class BikeUpdateOwnerRequest {

    public String owner;

    public BikeUpdateOwnerRequest() {
    }
    public BikeUpdateOwnerRequest(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
