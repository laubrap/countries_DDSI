package ar.edu.utn.frba.ddsi.countries_api_consume;

import ar.edu.utn.frba.ddsi.countries_api_consume.config.RestCountriesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RestCountriesProperties.class)
public class CountriesApiConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountriesApiConsumeApplication.class, args);
    }

}
