package com.kodilla.autosledz.service;

import com.kodilla.autosledz.cartrack.client.CarTrackClient;
import com.kodilla.autosledz.domain.Device;
import com.kodilla.autosledz.domain.DeviceDto;

import java.util.List;

public class CarTrackService {
    public static List<DeviceDto> fetchCarTrackDevices() { return CarTrackClient.getCarTrackDevices(); }

    public static Device fetchCarTrackDevice(Long id) { return CarTrackClient.getCarTrackDevice(id); }

    public static void createCarTrackDevice(Device device) { CarTrackClient.createCarTrackDevice(device); }

    public static void deleteCarTrackDevice(Device device) { CarTrackClient.deleteCarTrackDevice(device); }

    public static void updateCarTrackDevice(Device device) { CarTrackClient.updateCarTrackDevice(device); }

    public static void updatePosition(Device device) { CarTrackClient.updatePosition(device); }
}
