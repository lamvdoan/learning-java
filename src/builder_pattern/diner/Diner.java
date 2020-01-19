package builder_pattern.diner;

public class Diner {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private Integer zip;
    private Boolean hasSavedCreditCard;

    public void printInfo() {
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("phoneNumber: " + phoneNumber);
        System.out.println("address: " + address);
        System.out.println("city: " + city);
        System.out.println("state: " + state);
        System.out.println("zip: " + zip);
        System.out.println("hasSavedCreditCard: " + hasSavedCreditCard);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Boolean getHasSavedCreditCard() {
        return hasSavedCreditCard;
    }

    public void setHasSavedCreditCard(Boolean hasSavedCreditCard) {
        this.hasSavedCreditCard = hasSavedCreditCard;
    }
}
