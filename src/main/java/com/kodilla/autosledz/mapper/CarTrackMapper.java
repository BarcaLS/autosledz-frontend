package com.kodilla.autosledz.mapper;

import com.kodilla.autosledz.domain.Device;
import com.kodilla.autosledz.domain.DeviceDto;

import java.util.List;
import java.util.stream.Collectors;

public class CarTrackMapper {
    public static Device mapToDevice(final DeviceDto deviceDto) {
        return new Device (
                deviceDto.getId(),
                deviceDto.getName(),
                deviceDto.getUniqueId(),
                deviceDto.getLatitude(),
                deviceDto.getLongitude(),
                deviceDto.getDisplayName(),
                deviceDto.getCreated(),
                deviceDto.getUpdated()
        );
    }

    public static DeviceDto mapToDeviceDto(final Device device) {
        return new DeviceDto (
                device.getId(),
                device.getName(),
                device.getUniqueId(),
                device.getLatitude(),
                device.getLongitude(),
                device.getDisplayName(),
                device.getCreated(),
                device.getUpdated()
        );
    }

    public static List<DeviceDto> mapToDeviceDto(final List<Device> deviceList) {
        return deviceList.stream()
                .map(CarTrackMapper::mapToDeviceDto)
                .collect(Collectors.toList());
    }

    public static List<Device> mapToDevice(final List<DeviceDto> deviceList) {
        return deviceList.stream()
                .map(CarTrackMapper::mapToDevice)
                .collect(Collectors.toList());
    }
}
