package creational.abstractfactory;

public abstract class AbstractDeviceFactory {
    abstract Device getDevice(DeviceType deviceType);
}
