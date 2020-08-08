package creational.builder;

public class Name {
    private final String fName;
    private final String lName;

    private Name(Builder builder) {
        this.fName = builder.fName;
        this.lName = builder.lName;
    }

    public static class Builder {
        private String fName;
        private String lName;

        public Builder fName(final String fName) {
            this.fName = fName;
            return this;
        }

        public Builder lName(final String lName) {
            this.lName = lName;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }
}
