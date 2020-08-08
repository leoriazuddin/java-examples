package creational.abstractfactory;

public class MobileFactory extends AbstractDeviceFactory {
    @Override
    Device getDevice(DeviceType deviceType) {

        switch (deviceType) {
            case IPHONE:
                return new Iphone("1", "Iphone");
            case NOKIA:
                return new Nokia("2", "nokia");
        }

        return null;
    }
}
