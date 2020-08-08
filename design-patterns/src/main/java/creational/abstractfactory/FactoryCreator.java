package creational.abstractfactory;

public class FactoryCreator {

    public static AbstractDeviceFactory getFactory(FactoryType factoryType) {
        switch (factoryType){
            case LAPTOP:
                return new LaptopFactory();
            case MOBILE:
                return new MobileFactory();

        }

        throw new RuntimeException("Invalid factory "+factoryType);
    }
}
