package com.kodilla.autosledz.domain;

import com.kodilla.autosledz.service.CarTrackService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeviceService {
    private Set<Device> devices;
    private static DeviceService deviceService;

    private DeviceService() {
        this.devices = getDevices();
    }

    public static DeviceService getInstance() {
        if (deviceService == null) {
            deviceService = new DeviceService();
        }
        return deviceService;
    }

    public Set getDevices() {
        CarTrackService carTrackService = new CarTrackService();
        List<Device> devices = carTrackService.fetchCarTrackDevices();
        return new HashSet<>(devices);
    }

    public Set findByName(String name) {
        return devices.stream().filter(device -> device.getName().contains(name)).collect(Collectors.toSet());
    }

    public void save(Device device) {
        CarTrackService.createCarTrackDevice(device);
    }

    public void delete(Device device) {
        this.devices.remove(device);
    }
}
