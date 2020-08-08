package creational.abstractfactory;

public class LaptopFactory extends AbstractDeviceFactory {
    @Override
    Device getDevice(DeviceType deviceType) {

        switch (deviceType) {
            case HP:
                return new Hp("1", "some");
            case DELL:
                return new Dell("2", "dell");
        }

        return null;
    }
}
