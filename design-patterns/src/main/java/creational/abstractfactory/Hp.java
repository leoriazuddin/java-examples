package creational.abstractfactory;

public class Hp extends Device {
    private final String ram;
    private final String processor;


    public Hp(final String ram, final String processor) {
        this.ram = ram;
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public String getProcessor() {
        return processor;
    }


    @Override
    public String getDetails() {
        return String.format("Hp [ram= %s, processor= %s]", this.ram, this.processor);
    }
}
