package creational.builder;

public class App {
    public static void main(String[] args) {
        Name name = new Name.Builder().fName("fname").lName("lName").build();
        Address address = new Address.Builder().city("ss").state("CA").street("street").streetNumber(232).zip(903843).build();
        Account account = new Account.Builder().address(address).name(name).id("test").email("email@email.com").build();
    }
}
