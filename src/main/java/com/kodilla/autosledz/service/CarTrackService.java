package com.kodilla.autosledz.service;

import com.kodilla.autosledz.cartrack.client.CarTrackClient;
import com.kodilla.autosledz.domain.Device;

import java.util.List;

public class CarTrackService {
    public static List<Device> fetchCarTrackDevices() { return CarTrackClient.getCarTrackDevices(); }

    public static void createCarTrackDevice(Device device) { CarTrackClient.createCarTrackDevice(device); }

    /*public List<TraccarUserDto> fetchTraccarUsers() { return traccarClient.getTraccarUsers(); }

    public List<TraccarPositionDto> fetchTraccarPositions() { return traccarClient.getTraccarPositions(); }

    public TraccarServerDto fetchTraccarServer() { return traccarClient.getTraccarServer(); }

    public List<TraccarGroupDto> fetchTraccarGroups() { return traccarClient.getTraccarGroups(); }

    public List<TraccarNotificationDto> fetchTraccarNotifications() { return traccarClient.getTraccarNotifications(); }

    public List<TraccarGeofenceDto> fetchTraccarGeofences() { return traccarClient.getTraccarGeofences(); }

    public List<TraccarCalendarDto> fetchTraccarCalendars() { return traccarClient.getTraccarCalendars(); }

    public List<TraccarCommandDto> fetchTraccarCommands() { return traccarClient.getTraccarCommands(); }

    public List<TraccarDriverDto> fetchTraccarDrivers() { return traccarClient.getTraccarDrivers(); }*/
}
