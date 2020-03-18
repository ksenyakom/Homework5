package sep.pack;

public class Address {
    private String street;
    private int houseNumber;
    private Integer housing;


    public Address() {

    }

    public Address(String street, int houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.housing = housing;
    }

    public Address(String street, int houseNumber, Integer housing) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.housing = housing;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {

        this.houseNumber = houseNumber;
    }

    public Integer getHousing() {
        return housing;
    }

    public void setHousing(Integer housing) {
        this.housing = housing;
    }


    public String getFullAddress() {
        String s;

        if (housing != null) {
            s = "Адрес: ул." + street + ", дом " + houseNumber + ", корпус " + housing;
        }
        else     s = "Адрес: ул." + street + ", дом " + houseNumber;
        return s;
    }
}
