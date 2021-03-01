package com.kodilla.autosledz.cartrack.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CarTrackConfig {
    @Value("${cartrack.api.endpoint.prod}")
    private String carTrackApiEndpoint;
}
