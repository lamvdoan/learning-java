package builder_pattern.diner;

public class DinerBuilder {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private Integer zip;
    private Boolean hasSavedCreditCard;

    public DinerBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public DinerBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public DinerBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public DinerBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public DinerBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public DinerBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public DinerBuilder setZip(Integer zip) {
        this.zip = zip;
        return this;
    }

    public DinerBuilder setHasSavedCreditCard(Boolean hasSavedCreditCard) {
        this.hasSavedCreditCard = hasSavedCreditCard;
        return this;
    }

    public Diner build() {
        Diner diner = new Diner();
        diner.setFirstName(this.firstName);
        diner.setLastName(this.lastName);
        diner.setPhoneNumber(this.phoneNumber);
        diner.setAddress(this.address);
        diner.setCity(this.city);
        diner.setState(this.state);
        diner.setZip(this.zip);
        diner.setHasSavedCreditCard(this.hasSavedCreditCard);

        return diner;
    }
}
