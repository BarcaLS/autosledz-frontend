package com.kodilla.autosledz.domain;

import com.kodilla.autosledz.mapper.CarTrackMapper;
import com.kodilla.autosledz.service.CarTrackService;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DeviceService {
    private Set<Device> setDevices;
    private static DeviceService deviceService;

    private DeviceService() {
        this.setDevices = getDevices();
    }

    public static DeviceService getInstance() {
        if (deviceService == null) {
            deviceService = new DeviceService();
        }
        return deviceService;
    }

    public Set getDevices() {
        List<Device> devices = CarTrackMapper.mapToDevice(CarTrackService.fetchCarTrackDevices());
        return new HashSet<>(devices);
    }

    public Set findByName(String name) {
        List<Device> devices = CarTrackMapper.mapToDevice(CarTrackService.fetchCarTrackDevices());
        return devices.stream()
                .filter(device -> Objects.nonNull(device.getName()))
                .filter(device -> device.getName().contains(name))
                .collect(Collectors.toSet());
    }

    public void save(Device device) {
        if(device.getId() != 0) {
            CarTrackService.updateCarTrackDevice(device);
        } else {
            CarTrackService.createCarTrackDevice(device);
        }
    }

    public void delete(Device device) { CarTrackService.deleteCarTrackDevice(device); }

    public void deleteDevices() { CarTrackService.deleteDevices(); }

    public void updatePosition(Device device) { CarTrackService.updatePosition(device); }
}
