package annotations;

public class Demo {

    public static void main(String... args) {
        String[] cities = { "New York", "Melbourne"};
        sort(cities);
        merge(cities);
        split(cities);
    }

    @ToDo(id = 1000, finishDate = "10/10/2020", coder = "John Doe")
    static void sort(Object[] cities) {

    }

    @ValueElementOnly(value = "1000, 10/10/2020, John Doe")
    static void merge(Object[] cities) {

    }

    @ValueElementOnly("1000, 10/10/2020, John Doe")
    static void split(Object[] cities) {

    }
}
