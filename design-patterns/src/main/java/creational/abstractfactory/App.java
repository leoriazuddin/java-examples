package creational.abstractfactory;

public class App {

    public static void main(String[] args) {

        Device dell = FactoryCreator.getFactory(FactoryType.LAPTOP).getDevice(DeviceType.DELL);
        Device hp = FactoryCreator.getFactory(FactoryType.LAPTOP).getDevice(DeviceType.HP);

        Device nokia = FactoryCreator.getFactory(FactoryType.MOBILE).getDevice(DeviceType.NOKIA);
        Device iPhone = FactoryCreator.getFactory(FactoryType.MOBILE).getDevice(DeviceType.IPHONE);
    }
}
