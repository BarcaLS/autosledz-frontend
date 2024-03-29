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
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class CarTrackClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarTrackClient.class);
    private static final String carTrackApiEndpoint = "http://example.com";
    private static final RestTemplate restTemplate = new RestTemplateBuilder().build();

    public static List<DeviceDto> getCarTrackDevices() {
        URI url = UriComponentsBuilder.fromHttpUrl(carTrackApiEndpoint + "/devices")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<DeviceDto[]> devicesResponse = restTemplate.exchange(url, HttpMethod.GET, entity, DeviceDto[].class);
            return Arrays.asList(ofNullable(devicesResponse.getBody()).orElse(new DeviceDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public static Device getCarTrackDevice(Long id) {
        URI url = UriComponentsBuilder.fromHttpUrl(carTrackApiEndpoint + "/devices/" + id)
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<Device> deviceResponse = restTemplate.exchange(url, HttpMethod.GET, entity, Device.class);
            return ofNullable(deviceResponse.getBody()).orElse(new Device());
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new Device();
        }
    }

    public static void createCarTrackDevice(Device device) {
        URI url = UriComponentsBuilder.fromHttpUrl(carTrackApiEndpoint + "/devices")
                .build()
                .encode()
                .toUri();
        try {
            DeviceDto deviceDto = new DeviceDto(0L, device.getName(), device.getUniqueId(), device.getLatitude(), device.getLongitude(), device.getDisplayName(), new Date(), new Date());
            restTemplate.postForObject(url, deviceDto, DeviceDto.class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static void deleteCarTrackDevice(Device device) {
        URI url = UriComponentsBuilder.fromHttpUrl(carTrackApiEndpoint + "/devices/" + device.getId())
                .build()
                .encode()
                .toUri();
        try {
            restTemplate.delete(url);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static void deleteDevices() {
        URI url = UriComponentsBuilder.fromHttpUrl(carTrackApiEndpoint + "/devices/deleteAll")
                .build()
                .encode()
                .toUri();
        try {
            restTemplate.delete(url);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static void updateCarTrackDevice(Device device) {
        URI url = UriComponentsBuilder.fromHttpUrl(carTrackApiEndpoint + "/devices")
                .build()
                .encode()
                .toUri();
        try {
            DeviceDto deviceDto = new DeviceDto(device.getId(), device.getName(), device.getUniqueId(), device.getLatitude(), device.getLongitude(), device.getDisplayName(), device.getCreated(), device.getUpdated());
            restTemplate.postForObject(url, deviceDto, DeviceDto.class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static List<Device> getTraccarDevices() {
        URI url = UriComponentsBuilder.fromHttpUrl(carTrackApiEndpoint + "/traccar/devices")
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

    public static Device updatePosition(Device device) {
        List<Device> carTrackDevices = CarTrackClient.getTraccarDevices();
        List<Device> carTrackFoundDevice = carTrackDevices.stream()
                .filter(d -> d.getUniqueId().equals(device.getUniqueId()))
                .collect(Collectors.toList());
        URI url = UriComponentsBuilder.fromHttpUrl(carTrackApiEndpoint + "/devices/" + carTrackFoundDevice.get(0).getId() + "/" + device.getId() + "/updatePosition")
                .build()
                .encode()
                .toUri();
        try {
            HttpEntity entity = createEntity();
            ResponseEntity<Device> deviceResponse = restTemplate.exchange(url, HttpMethod.GET, entity, Device.class);
            return ofNullable(deviceResponse.getBody()).orElse(new Device());
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new Device();
        }
    }

    public static HttpEntity createEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpEntity(headers);
    }
}
