package com.example.creley.Classes;

public class RealEstate {
    private String id ;
    private String type ;
    private String wilaya;
    private String town ;
    private String township ;
    private String periodType ;
    private int nbFloor ;
    private int nbRoom ;
    private float  surface;
    private  int nbBathroom ;
    private int furniture ; // 0 --> no Furniture , 1 --> there is Furniture
    private float price ;
    private String authorID ;
    private String imgUri ;

    public RealEstate() {
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public RealEstate(String id, int nbFloor, String type, int nbRoom, float surface, int nbBathroom, int furniture, String wilaya, String town , String township , float price, String periodType , String authorID , String imgUri) {
        this.id = id;
        this.nbFloor = nbFloor;
        this.type = type;
        this.nbRoom = nbRoom;
        this.surface = surface;
        this.nbBathroom = nbBathroom;
        this.furniture = furniture;
        this.wilaya = wilaya;
        this.town = town;
        this.price = price;
        this.periodType = periodType;
        this.township = township ;
        this.authorID = authorID ;
        this.imgUri = imgUri ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNbFloor() {
        return nbFloor;
    }

    public void setNbFloor(int nbFloor) {
        this.nbFloor = nbFloor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbRoom() {
        return nbRoom;
    }

    public void setNbRoom(int nbRoom) {
        this.nbRoom = nbRoom;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public int getNbBathroom() {
        return nbBathroom;
    }

    public void setNbBathroom(int nbBathroom) {
        this.nbBathroom = nbBathroom;
    }

    public int getFurniture() {
        return furniture;
    }

    public void setFurniture(int furniture) {
        this.furniture = furniture;
    }

    public String getWilaya() {
        return wilaya;
    }

    public void setWilaya(String wilaya) {
        this.wilaya = wilaya;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }
}
