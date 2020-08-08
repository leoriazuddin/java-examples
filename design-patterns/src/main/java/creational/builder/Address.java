package creational.builder;

public class Address {
    private final String street;
    private final int zip;
    private final String city;
    private final String state;
    private final int streetNumber;

    public String getStreet() {
        return street;
    }

    public int getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    private Address(Builder builder) {
        this.street = builder.street;
        this.zip = builder.zip;
        this.city = builder.city;
        this.state = builder.state;
        this.streetNumber = builder.streetNumber;
    }

    public static class Builder {

        private String street;
        private int zip;
        private String city;
        private String state;
        private int streetNumber;

        public Builder street(final String street) {
            this.street = street;
            return this;
        }

        public Builder zip(final int zip) {
            this.zip = zip;
            return this;
        }

        public Builder city(final String city) {
            this.city = city;
            return this;
        }

        public Builder state(final String state) {
            this.state = state;
            return this;
        }

        public Builder streetNumber(final int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
