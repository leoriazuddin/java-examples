package creational.abstractfactory;

public class Dell extends Device {
    private final String ram;
    private final String processor;


    public Dell(final String ram, final String processor) {
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
        return String.format("Dell [ram= %s, processor= %s]", this.ram, this.processor);
    }
}
