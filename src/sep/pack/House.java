package sep.pack;

public class House {
    private int year;
    private int flore;
    private Address address = new Address();
    private static int count = 0;

    public House() {
        count++;
    }


    public House(int year, int flore, Address address) {
        this.year = year;
        this.flore = flore;
        this.address = address;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getFlore() {
        return flore;
    }

    public void setFlore(int flore) {
        this.flore = flore;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFullInfo() {
        return year + " года постройки,  этажность " + flore + ". " + address.getFullAddress();
    }

    public void setStreet(String newstreet) {
        address.setStreet(newstreet);
    }

    public void setHouseNumber(int newHouseNumber) {
        address.setHouseNumber(newHouseNumber);
    }

    public void setHousing(int newHousing) {
        address.setHousing(newHousing);
    }


}
