package ar.edu.utn.frba.ddsi.countries_api_consume.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rest-countries")
@Data
public class RestCountriesProperties {
    private String baseUrl;
}

