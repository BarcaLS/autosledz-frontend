package com.kodilla.autosledz.cartrack.client;

import com.kodilla.autosledz.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static java.util.Optional.ofNullable;

public class CarTrackClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarTrackClient.class);
    private static final String carTrackApiEndpoint = "https://shrouded-hollows-51087.herokuapp.com/v1";
    private static final RestTemplate restTemplate = new RestTemplateBuilder().build();

    public static List<Device> getCarTrackDevices() {
        URI url = UriComponentsBuilder.fromHttpUrl(carTrackApiEndpoint + "/devices")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<Device[]> devicesResponse = restTemplate.exchange(url, HttpMethod.GET, entity, Device[].class);
            return Arrays.asList(ofNullable(devicesResponse.getBody()).orElse(new Device[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    /*public List<TraccarUserDto> getTraccarUsers() {
        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/users")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<TraccarUserDto[]> usersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, TraccarUserDto[].class);
            return Arrays.asList(ofNullable(usersResponse.getBody()).orElse(new TraccarUserDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<TraccarPositionDto> getTraccarPositions() {
        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/positions")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<TraccarPositionDto[]> usersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, TraccarPositionDto[].class);
            return Arrays.asList(ofNullable(usersResponse.getBody()).orElse(new TraccarPositionDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public TraccarServerDto getTraccarServer() {
        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/server")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<TraccarServerDto> usersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, TraccarServerDto.class);
            return ofNullable(usersResponse.getBody()).orElse(new TraccarServerDto());
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new TraccarServerDto();
        }
    }

    public List<TraccarGroupDto> getTraccarGroups() {
        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/groups")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<TraccarGroupDto[]> usersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, TraccarGroupDto[].class);
            return Arrays.asList(ofNullable(usersResponse.getBody()).orElse(new TraccarGroupDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<TraccarNotificationDto> getTraccarNotifications() {
        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/notifications")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<TraccarNotificationDto[]> usersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, TraccarNotificationDto[].class);
            return Arrays.asList(ofNullable(usersResponse.getBody()).orElse(new TraccarNotificationDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<TraccarGeofenceDto> getTraccarGeofences() {
        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/geofences")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<TraccarGeofenceDto[]> usersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, TraccarGeofenceDto[].class);
            return Arrays.asList(ofNullable(usersResponse.getBody()).orElse(new TraccarGeofenceDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<TraccarCalendarDto> getTraccarCalendars() {
        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/calendars")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<TraccarCalendarDto[]> usersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, TraccarCalendarDto[].class);
            return Arrays.asList(ofNullable(usersResponse.getBody()).orElse(new TraccarCalendarDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<TraccarCommandDto> getTraccarCommands() {
        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/commands")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<TraccarCommandDto[]> usersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, TraccarCommandDto[].class);
            return Arrays.asList(ofNullable(usersResponse.getBody()).orElse(new TraccarCommandDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<TraccarDriverDto> getTraccarDrivers() {
        URI url = UriComponentsBuilder.fromHttpUrl(traccarConfig.getTraccarApiEndpoint() + "/drivers")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<TraccarDriverDto[]> usersResponse = restTemplate.exchange(url, HttpMethod.GET, entity, TraccarDriverDto[].class);
            return Arrays.asList(ofNullable(usersResponse.getBody()).orElse(new TraccarDriverDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }*/

    public static HttpEntity createEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpEntity(headers);
    }
}
