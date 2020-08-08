package creational.abstractfactory;

public class Nokia extends Device {
    private final String ram;
    private final String processor;


    public Nokia(final String ram, final String processor) {
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
        return String.format("Nokia [ram= %s, processor= %s]", this.ram, this.processor);
    }
}
