package com.kodilla.autosledz.service;

import com.kodilla.autosledz.cartrack.client.CarTrackClient;
import com.kodilla.autosledz.domain.Device;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarTrackService {
    private final CarTrackClient carTrackClient;

    public List<Device> fetchCarTrackDevices() { return carTrackClient.getCarTrackDevices(); }

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
