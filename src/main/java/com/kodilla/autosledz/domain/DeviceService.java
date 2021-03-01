package com.kodilla.autosledz.domain;

import com.kodilla.autosledz.service.CarTrackService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeviceService {
    private Set<Device> devices;
    private static DeviceService deviceService;
    private static CarTrackService carTrackService;

    private DeviceService() {
        this.devices = getData();
    }

    public static DeviceService getInstance() {
        if (deviceService == null) {
            deviceService = new DeviceService();
        }
        return deviceService;
    }

    public Set getDevices() {
        return new HashSet<>(devices);
    }

    public void addDevice(Device device) {
        this.devices.add(device);
    }

    public Set getData() {
        List<Device> result = carTrackService.fetchCarTrackDevices();
        return new HashSet<>(result);

        /*Set devices = new HashSet<>();
        devices.add(new Device(0L, "auto Marcina", "DW234", 20.3443F, 30.23F, "takietam", new Date(), new Date()));
        return devices;*/
    }

    public Set findByName(String name) {
        return devices.stream().filter(device -> device.getName().contains(name)).collect(Collectors.toSet());
    }

    public void save(Device device) {
        this.devices.add(device);
    }

    public void delete(Device device) {
        this.devices.remove(device);
    }
}
