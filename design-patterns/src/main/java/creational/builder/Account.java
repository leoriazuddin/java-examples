package creational.builder;

public class Account {

    private final String id;
    private final Name name;
    private final Address address;
    private final String email;

    public String getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    private Account(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.email = builder.email;
    }

    public static class Builder {
        private String id;
        private String email;
        private Name name;
        private Address address;

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder name(final Name name) {
            this.name = name;
            return this;
        }

        public Builder address(final Address address) {
            this.address = address;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }

}
