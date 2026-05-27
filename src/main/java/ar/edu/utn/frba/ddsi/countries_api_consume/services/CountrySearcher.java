package ar.edu.utn.frba.ddsi.countries_api_consume.services;

import ar.edu.utn.frba.ddsi.countries_api_consume.config.RestCountriesProperties;
import ar.edu.utn.frba.ddsi.countries_api_consume.services.dto.Country;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class CountrySearcher {
    private RestTemplate restTemplate;
    private RestCountriesProperties properties;

    public CountrySearcher(RestTemplate restTemplate, RestCountriesProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }


    public List<Country> searchAll(){
        URI uri = UriComponentsBuilder
                .fromUriString(properties.getBaseUrl())
                .path("/all")
                .queryParam("fields","name,capital,region,subregion")
                .build()
                .toUri();

        Country[] countries = restTemplate.getForObject(uri,Country[].class);
        //deberiamos insertar esto en un try catch, porque puede explortar, no
        //handelleamos los errors

        return countries == null ? List.of() : Arrays.asList(countries);
    }

    public Optional<Country> searchByName(String name) {
        URI uri = UriComponentsBuilder
                .fromUriString(properties.getBaseUrl())
                .path("/name/{name}")
                .buildAndExpand(name)
                .toUri();

        Country[] country = restTemplate.getForObject(uri, Country[].class);

        if (country == null || country.length == 0) {
            return Optional.empty();
        }

        return Optional.of(country[0]);
    }

    public List<Country> searchByRegion(String region){
        URI uri = UriComponentsBuilder
                .fromUriString(properties.getBaseUrl())
                .path("/region/{region}")
                .buildAndExpand(region)
                .toUri();

        Country[] countries = restTemplate.getForObject(uri,Country[].class);

        return countries == null ? List.of() : Arrays.asList(countries);
    }

    public List<Country> searchBySubRegion(String SubRegion){
        URI uri = UriComponentsBuilder
                .fromUriString(properties.getBaseUrl())
                .path("/subregion/{subregion}")
                .buildAndExpand(SubRegion)
                .toUri();

        Country[] countries = restTemplate.getForObject(uri,Country[].class);

        return countries == null ? List.of() : Arrays.asList(countries);
    }

    public Optional<Country> searchByCapital(String capital) {
        URI uri = UriComponentsBuilder
                .fromUriString(properties.getBaseUrl())
                .path("/capital/{capital}")
                .buildAndExpand(capital)
                .toUri();

        Country[] country = restTemplate.getForObject(uri, Country[].class);

        if (country == null || country.length == 0) {
            return Optional.empty();
        }

        return Optional.of(country[0]);
    }

    public List<Country> searchByCurrency(String currency){
        URI uri = UriComponentsBuilder
                .fromUriString(properties.getBaseUrl())
                .path("/currency/{currency}")
                .buildAndExpand(currency)
                .toUri();

        Country[] countries = restTemplate.getForObject(uri,Country[].class);

        return countries == null ? List.of() : Arrays.asList(countries);
    }
}
